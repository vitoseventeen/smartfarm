package cz.cvut.omo.model.field;

public interface FieldState {
    void plant(Field field);
    void harvest(Field field);
    void applyPesticides(Field field);
}
