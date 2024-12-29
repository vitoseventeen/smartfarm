package cz.cvut.fel.omo.smartfarm.strategy.data;

import cz.cvut.fel.omo.smartfarm.model.farm.Farm;

import java.util.Optional;

public interface FarmDataStrategy {
    Optional<Farm> read();
}
