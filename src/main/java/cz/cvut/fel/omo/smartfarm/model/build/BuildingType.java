package cz.cvut.fel.omo.smartfarm.model.build;

public enum BuildingType {
    BARN("Barn"),
    STABLE("Stable"),
    GREENHOUSE("Greenhouse"),
    WAREHOUSE("Warehouse"),
    HOUSE("House"),
    WORKSHOP("Workshop");

    private final String displayName;

    BuildingType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
