package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.model.field.Field;

/**
 * Interface defining the contract for various states of a field in the smart farm system.
 * Each state implements behavior for planting crops, harvesting, and applying pesticides.
 */
public interface FieldState {

    /**
     * Plants crops in the field.
     * The behavior depends on the current state of the field.
     *
     * @param field The field instance.
     */
    void plant(Field field);

    /**
     * Harvests crops from the field.
     * The behavior depends on the current state of the field.
     *
     * @param field The field instance.
     */
    void harvest(Field field);

    /**
     * Applies pesticides to the field.
     * The behavior depends on the current state of the field.
     *
     * @param field The field instance.
     */
    void applyPesticides(Field field);
}
