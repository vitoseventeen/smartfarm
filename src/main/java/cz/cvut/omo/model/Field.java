package cz.cvut.omo.model;

public class Field {
    private String cropType; // crop это культура (пример: пшеница, подсолнух)
    private double fieldSize; // в гектарах
    private FieldStatus fieldStatus;

    public Field(String cropType, double fieldSize, FieldStatus fieldStatus) {
        this.cropType = cropType;
        this.fieldSize = fieldSize;
        this.fieldStatus = fieldStatus;
    }

    @Override
    public String toString() {
        return "Field{" +
                "cropType='" + cropType + '\'' +
                ", fieldSize=" + fieldSize +
                ", fieldStatus=" + fieldStatus +
                '}';
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public double getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(double fieldSize) {
        this.fieldSize = fieldSize;
    }

    public FieldStatus getFieldStatus() {
        return fieldStatus;
    }

    public void setFieldStatus(FieldStatus fieldStatus) {
        this.fieldStatus = fieldStatus;
    }
}
