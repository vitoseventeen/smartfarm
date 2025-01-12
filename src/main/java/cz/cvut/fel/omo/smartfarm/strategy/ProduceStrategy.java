package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Product;

/**
 * This interface defines the strategy for producing products in a building (e.g., barn).
 * Each implementing class will provide the specific production process for a particular type of product.
 */
public interface ProduceStrategy {

    /**
     * This method defines the production process for a product in the given building.
     * Each specific implementation will handle the creation and addition of a product (e.g., milk, eggs, etc.).
     *
     * @param barn The building (e.g., barn) where the production takes place.
     */
    void produce(Building barn);
}
