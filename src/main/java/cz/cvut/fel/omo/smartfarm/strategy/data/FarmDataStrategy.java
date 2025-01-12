package cz.cvut.fel.omo.smartfarm.strategy.data;

import cz.cvut.fel.omo.smartfarm.model.farm.Farm;

import java.util.Optional;

/**
 * This interface defines the strategy for reading farm data.
 * Any class implementing this interface must provide a concrete implementation
 * to read farm data and return it as an Optional of Farm.
 */
public interface FarmDataStrategy {

    /**
     * Reads farm data and returns an Optional containing the Farm object.
     * If the data is invalid or could not be read, an empty Optional is returned.
     *
     * @return An Optional containing the Farm, or an empty Optional if the data is invalid.
     */
    Optional<Farm> read();
}
