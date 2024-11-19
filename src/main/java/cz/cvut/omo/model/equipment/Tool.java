package cz.cvut.omo.model.equipment;

public class Tool extends Equipment {
    private String usageType; // "Ручной", "Электрический" и тд

    public Tool(String name, EquipmentStatus status, String usageType) {
        super(name, status);
        this.usageType = usageType;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    @Override
    public void performAction() {
        System.out.println("Инструмент " + getName() + " используется.");
    }
}
