package cz.cvut.omo.model.field;

public class Field {
    // crop это культура (пример: пшеница, подсолнух)
    private int fieldSize;
    private String cropType;
    private FieldStatus fieldStatus;

    public Field(String cropType, int fieldSize, FieldStatus fieldStatus) {
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

    public void setFieldSize(int fieldSize) {
        if (fieldSize < 0) {
            return;
        }

        this.fieldSize = fieldSize;
    }

    public FieldStatus getStatus() {
        return fieldStatus;
    }

    public void setStatus(FieldStatus fieldStatus) {
        this.fieldStatus = fieldStatus;
    }
}
