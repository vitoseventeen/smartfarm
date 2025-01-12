package cz.cvut.fel.omo.smartfarm.model.build;

/**
 * Enumerates the different types of buildings within the smart farm system.
 * Each type has a display name for easier identification and use within the application.
 */
public enum BuildingType {
    BARN("Barn"),            // Represents a barn used primarily for storing hay and livestock.
    STABLE("Stable"),        // Represents a stable for housing horses or other farm animals.
    GREENHOUSE("Greenhouse"),// Represents a greenhouse for growing plants in a controlled environment.
    WAREHOUSE("Warehouse"),  // Represents a warehouse used for storing farm products and equipment.
    HOUSE("House"),          // Represents a residential house for farm workers or owners.
    WORKSHOP("Workshop");    // Represents a workshop for maintenance and repair tasks.

    private final String displayName;

    /**
     * Constructs a new BuildingType with a display name.
     *
     * @param displayName The friendly name of the building type used in user interfaces.
     */
    BuildingType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of the building type.
     *
     * @return The display name of the building type.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Returns the display name when the enum is converted to a string.
     *
     * @return The display name of the building type.
     */
    @Override
    public String toString() {
        return displayName;
    }
}
