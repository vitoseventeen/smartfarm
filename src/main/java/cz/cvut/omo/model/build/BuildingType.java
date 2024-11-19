package cz.cvut.omo.model.build;

public enum BuildingType {
    BARN("Сарай"),
    STABLE("Хлев"),
    GREENHOUSE("Теплица"),
    WAREHOUSE("Склад"),
    WORKSHOP("Мастерская");

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
