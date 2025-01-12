package cz.cvut.fel.omo.smartfarm.model.field;

import cz.cvut.fel.omo.smartfarm.state.field.FieldState;
import cz.cvut.fel.omo.smartfarm.state.field.FreeState;

/**
 * Represents an agricultural field within the smart farm system.
 * This class manages the characteristics of a field such as its crop type and size,
 * as well as its current state which dictates possible actions.
 */
public class Field {
    private int fieldSize;
    private String cropType;
    private FieldState state;

    /**
     * Constructs a Field with specified crop type and field size, initializing in a free state.
     *
     * @param cropType The type of crop planted in the field.
     * @param fieldSize The size of the field in area units.
     */
    public Field(String cropType, int fieldSize) {
        this.cropType = cropType;
        this.fieldSize = fieldSize;
        this.state = new FreeState();
    }

    /**
     * Returns the size of the field.
     *
     * @return The size of the field.
     */
    public int getFieldSize() {
        return fieldSize;
    }

    /**
     * Sets the size of the field.
     *
     * @param fieldSize The new size of the field in area units.
     */
    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    /**
     * Returns the type of crop planted in the field.
     *
     * @return The crop type.
     */
    public String getCropType() {
        return cropType;
    }

    /**
     * Sets the type of crop to be planted in the field.
     *
     * @param cropType The new type of crop.
     */
    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    /**
     * Returns the current state of the field.
     *
     * @return The field's current state.
     */
    public FieldState getState() {
        return state;
    }

    /**
     * Sets the state of the field, affecting its available actions and behavior.
     *
     * @param state The new state of the field.
     */
    public void setState(FieldState state) {
        this.state = state;
    }

    /**
     * Initiates the planting process on the field based on its current state.
     */
    public void plant() {
        state.plant(this);
    }

    /**
     * Initiates the harvesting process on the field based on its current state.
     */
    public void harvest() {
        state.harvest(this);
    }

    /**
     * Applies pesticides to the field based on its current state.
     */
    public void applyPesticides() {
        state.applyPesticides(this);
    }

    /**
     * Provides a string representation of the field, including its crop type, size, and current state.
     *
     * @return A string description of the field.
     */
    @Override
    public String toString() {
        return "Field{" +
                "cropType='" + cropType + '\'' +
                ", fieldSize=" + fieldSize +
                ", state=" + state.getClass().getSimpleName() +
                '}';
    }
}
