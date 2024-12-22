package cz.cvut.fel.omo.smartfarm.model.equipment;

import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;

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