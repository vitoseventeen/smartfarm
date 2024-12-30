package cz.cvut.fel.omo.smartfarm.strategy.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.cvut.fel.omo.smartfarm.adapters.*;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.products.Product;
import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;
import cz.cvut.fel.omo.smartfarm.state.farmer.FarmerState;
import cz.cvut.fel.omo.smartfarm.state.field.FieldState;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class JsonFarmDataStrategy implements FarmDataStrategy {

    private final String filePath;
    private final Gson gson;

    public JsonFarmDataStrategy(String filePath) {
        this.filePath = filePath;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(FarmerState.class, new FarmerStateAdapter())
                .registerTypeAdapter(FieldState.class, new FieldStateAdapter())
                .registerTypeAdapter(EquipmentState.class, new EquipmentStateAdapter())
                .registerTypeAdapter(Building.class, new BuildingAdapter())
                .registerTypeAdapter(Equipment.class, new EquipmentAdapter())
                .registerTypeAdapter(Animal.class, new AnimalAdapter())
                .registerTypeAdapter(Product.class, new ProductAdapter())  // Ensure correct adapter for Product
                .create();
    }

    @Override
    public Optional<Farm> read() {
        try (FileReader reader = new FileReader(this.filePath)) {
            return Optional.ofNullable(gson.fromJson(reader, Farm.class));
        } catch (IOException e) {
            throw new RuntimeException("Error reading farm data from JSON file", e);
        }
    }

    public void save(Farm farm) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            gson.toJson(farm, writer);
            System.out.println("Farm configuration saved successfully to " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error writing farm data to JSON file", e);
        }
    }
}