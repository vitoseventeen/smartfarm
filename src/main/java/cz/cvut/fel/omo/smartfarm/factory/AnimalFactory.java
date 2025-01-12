package cz.cvut.fel.omo.smartfarm.factory;
import cz.cvut.fel.omo.smartfarm.model.animal.*;

public class AnimalFactory extends BaseFactory<Animal> {

    public AnimalFactory() {
        register("cow", Cow::new);
        register("chicken", Chicken::new);
        register("sheep", Sheep::new);
        register("pig", Pig::new);
    }

    @Override
    public Animal create(String type) {
        System.out.println("Creating animal of type: " + type);
        return super.create(type);
    }
}
