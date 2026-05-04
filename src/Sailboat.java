import java.util.Objects;

public class Sailboat extends Ship {
    private String sailMaterial;
    private double sailArea;

    public Sailboat() {
        super();
        this.sailMaterial = "Ткань";
        this.sailArea = 10.0;
    }

    public Sailboat(int id, String name, String sailMaterial, double sailArea) {
        super(id, name);
        setSailMaterial(sailMaterial);
        setSailArea(sailArea);
    }

    public String getSailMaterial() {
        return sailMaterial;
    }

    public double getSailArea() {
        return sailArea;
    }

    public void setSailMaterial(String sailMaterial) {
        if (sailMaterial == null || sailMaterial.trim().isEmpty()) {
            throw new IllegalArgumentException("Материал парусов не может быть пустым.");
        }
        this.sailMaterial = sailMaterial;
    }

    public void setSailArea(double sailArea) {
        if (sailArea <= 0) {
            throw new IllegalArgumentException("Площадь парусов должна быть больше 0.");
        }
        this.sailArea = sailArea;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Sailboat sailboat = (Sailboat) obj;

        return Double.compare(sailboat.sailArea, sailArea) == 0 &&
                Objects.equals(sailMaterial, sailboat.sailMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sailMaterial, sailArea);
    }

    @Override
    public String toString() {
        return "Парусник {" +
                super.toString() +
                ", sailMaterial='" + sailMaterial + '\'' +
                ", sailArea=" + sailArea +
                '}';
    }
}