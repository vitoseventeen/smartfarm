package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.model.field.Field;

public interface FieldState {
    void plant(Field field);
    void harvest(Field field);
    void applyPesticides(Field field);
}
