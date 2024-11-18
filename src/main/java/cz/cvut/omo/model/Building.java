package cz.cvut.omo.model;

public abstract class Building {
    //TODO: Создать новые классы на основе его (пример: хлев, сарай...)
    private double area; // площадь в метрах квадратных
    private String name;
    private String type;

    public Building(String name, double area, String type) {
        this.name = name;
        this.area = area;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Building{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
