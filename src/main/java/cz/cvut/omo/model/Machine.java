package cz.cvut.omo.model;

public class Machine {
    //TODO: Создать новые классы на основе его (пример: трактор, комбайн, сеялка), сделать абстрактным
    protected String name;
    protected String type;
    protected MachineStatus machineStatus;

    public Machine(String name, String type, MachineStatus machineStatus) {
        this.name = name;
        this.type = type;
        this.machineStatus = machineStatus;
    }

    public void refuel(int fuelAmount) {
        System.out.println(name + " refueled with " + fuelAmount + " liters.");
    }

    public void diagnose() {
        System.out.println(name + " is currently " + machineStatus + ".");
    }


    @Override
    public String toString() {
        return "Machine{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", machineStatus=" + machineStatus +
                '}';
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

    public MachineStatus getStatus() {
        return machineStatus;
    }

    public void setStatus(MachineStatus machineStatus) {
        this.machineStatus = machineStatus;
    }
}
