package cz.cvut.fel.omo.smartfarm.model.equipment;

import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;

/**
 * Represents a Tool within the smart farm system.
 * Tools are specific types of equipment characterized by their usage types, such as cutting, drilling, or fastening.
 */
public class Tool extends Equipment {
    private String usageType;

    /**
     * Constructs a Tool with a specified name and usage type.
     * Initializes the tool in an off state.
     *
     * @param name The name of the tool, used for identification.
     * @param usageType The specific type of usage for the tool, defining its main function or application.
     */
    public Tool(String name, String usageType) {
        super(name, new OffState());
        this.usageType = usageType;
    }

    /**
     * Returns the usage type of the tool.
     *
     * @return The usage type of the tool.
     */
    public String getUsageType() {
        return usageType;
    }

    /**
     * Sets the usage type of the tool.
     *
     * @param usageType The new usage type for the tool.
     */
    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }
}
