package cz.cvut.omo.model;

public class Animal {
    //TODO:Создать новые классы на основе его (пример:корова, свинья, лошадь), сделать абстрактным
    private String type;
    private int count;

    public Animal(String type, int count) {
        this.type = type;
        this.count = count;
    }
    
    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", count=" + count +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
