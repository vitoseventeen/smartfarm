package cz.cvut.omo.model;

public class Farmer {
    private String name;
    private int age;
    private FarmerActionStatus currentAction;

    public Farmer(String name, int age, FarmerActionStatus currentAction) {
        this.name = name;
        this.age = age;
        this.currentAction = currentAction;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", currentAction=" + currentAction +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public FarmerActionStatus getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(FarmerActionStatus currentAction) {
        this.currentAction = currentAction;
    }
}
