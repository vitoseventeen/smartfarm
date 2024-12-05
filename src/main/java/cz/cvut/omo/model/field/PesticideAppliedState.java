package cz.cvut.omo.model.field;

public class PesticideAppliedState implements FieldState {
    @Override
    public void plant(Field field) {
        System.out.println("The field has pesticides. Wait for the crop to grow.");
    }

    @Override
    public void harvest(Field field) {
        System.out.println("The field with pesticides is not ready for harvest.");
    }

    @Override
    public void applyPesticides(Field field) {
        System.out.println("Pesticides have already been applied.");
    }
}
