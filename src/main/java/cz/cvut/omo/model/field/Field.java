package cz.cvut.omo.model.field;

import cz.cvut.omo.state.field.FieldState;
import cz.cvut.omo.state.field.FreeState;

public class Field {
    private int fieldSize;
    private String cropType;
    private FieldState state;

    public Field(String cropType, int fieldSize) {
        this.cropType = cropType;
        this.fieldSize = fieldSize;
        this.state = new FreeState(); // начальное состояние
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public FieldState getState() {
        return state;
    }

    public void setState(FieldState state) {
        this.state = state;
    }

    public void plant() {
        state.plant(this);
    }

    public void harvest() {
        state.harvest(this);
    }

    public void applyPesticides() {
        state.applyPesticides(this);
    }

    @Override
    public String toString() {
        return "Field{" +
                "cropType='" + cropType + '\'' +
                ", fieldSize=" + fieldSize +
                ", state=" + state.getClass().getSimpleName() +
                '}';
    }
}
