package cz.cvut.omo.model;

public class Building {
    //TODO: Создать новые классы на основе его (пример: хлев, сарай...), сделать абстрактным
    private double area; // площадь в метрах квадратных
    private String name;
    private String type;

    public Building(String name, double area, String type) {
        this.name = name;
        this.area = area;
        this.type = type;
    }

    public void storeItems(String item, int quantity) {
        System.out.println(quantity + " units of " + item + " stored in the building.");
    }

    public void upgrade() {
        System.out.println("Building " + name + " has been upgraded to a higher level.");
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
