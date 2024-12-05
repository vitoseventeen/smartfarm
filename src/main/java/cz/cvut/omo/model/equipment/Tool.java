package cz.cvut.omo.model.equipment;

public class Tool extends Equipment {
    private String usageType;

    public Tool(String name, String usageType) {
        super(name, new OffState());
        this.usageType = usageType;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }
}