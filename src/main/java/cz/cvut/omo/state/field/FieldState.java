package cz.cvut.omo.state.field;

import cz.cvut.omo.model.field.Field;

public interface FieldState {
    void plant(Field field);
    void harvest(Field field);
    void applyPesticides(Field field);
}
