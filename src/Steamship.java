import java.util.Objects;

public class Steamship extends Ship {
    private String fuelType;
    private int enginePower;

    public Steamship() {
        super();
        this.fuelType = "Уголь";
        this.enginePower = 100;
    }

    public Steamship(int id, String name, String fuelType, int enginePower) {
        super(id, name);
        setFuelType(fuelType);
        setEnginePower(enginePower);
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setFuelType(String fuelType) {
        if (fuelType == null || fuelType.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип топлива не может быть пустым.");
        }
        this.fuelType = fuelType;
    }

    public void setEnginePower(int enginePower) {
        if (enginePower <= 0) {
            throw new IllegalArgumentException("Мощность двигателя должна быть больше 0.");
        }
        this.enginePower = enginePower;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Steamship steamship = (Steamship) obj;

        return enginePower == steamship.enginePower &&
                Objects.equals(fuelType, steamship.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelType, enginePower);
    }

    @Override
    public String toString() {
        return "Пароход {" +
                super.toString() +
                ", fuelType='" + fuelType + '\'' +
                ", enginePower=" + enginePower +
                '}';
    }
}