package cz.cvut.fel.omo.smartfarm.strategy.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.cvut.fel.omo.smartfarm.adapters.*;
import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
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

/**
 * This class implements the FarmDataStrategy interface and provides methods to read and save farm data in JSON format.
 * It uses the Gson library to convert between Java objects and JSON.
 */
public class JsonFarmDataStrategy implements FarmDataStrategy {

    private final String filePath;
    private final Gson gson;

    /**
     * Constructor that initializes the JsonFarmDataStrategy with the given file path for saving and reading farm data.
     * It also sets up a Gson instance with custom adapters for serializing and deserializing farm-related objects.
     *
     * @param filePath The file path where farm data will be saved or read from.
     */
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

    /**
     * Reads the farm data from the JSON file specified by the filePath.
     * It converts the JSON content into a Farm object and returns it wrapped in an Optional.
     * If the file is not found or there's an error reading it, an exception is thrown.
     *
     * @return An Optional containing the Farm object if the file is read successfully, or an empty Optional if not.
     */
    @Override
    public Optional<Farm> read() {
        try (FileReader reader = new FileReader(this.filePath)) {
            return Optional.ofNullable(gson.fromJson(reader, Farm.class));
        } catch (IOException e) {
            throw new RuntimeException("Error reading farm data from JSON file", e);
        }
    }

    /**
     * Saves the given Farm object to a JSON file at the specified filePath.
     * It serializes the Farm object into JSON and writes it to the file.
     * If an error occurs while writing to the file, an exception is thrown.
     *
     * @param farm The Farm object to be saved to the JSON file.
     */
    public void save(Farm farm) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            gson.toJson(farm, writer);
            AppLogger.getInstance().logInfo("Farm configuration saved successfully to " + filePath);
        } catch (IOException e) {
            AppLogger.getInstance().logError("Error writing farm data to JSON file");
            throw new RuntimeException("Error writing farm data to JSON file", e);
        }
    }
}
