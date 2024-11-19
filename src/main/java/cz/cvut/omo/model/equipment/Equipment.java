package cz.cvut.omo.model.equipment;

// Базовый класс для оборудования
public abstract class Equipment {
    private String name;
    private EquipmentStatus status; // "Активный", "В ожидании", "Выключен"

    public Equipment(String name, EquipmentStatus status) {
        this.name = name;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipmentStatus getStatus() {
        return status;
    }

    public void setStatus(EquipmentStatus status) {
        this.status = status;
    }


    public abstract void performAction();
}

// Подкласс для машин


// Подкласс для другого оборудования
