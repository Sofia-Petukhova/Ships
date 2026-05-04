import java.util.Objects;

public class Corvette extends Ship {
    private String weaponSystem;
    private int crewCount;

    public Corvette() {
        super();
        this.weaponSystem = "Пушка";
        this.crewCount = 50;
    }

    public Corvette(int id, String name, String weaponSystem, int crewCount) {
        super(id, name);
        setWeaponSystem(weaponSystem);
        setCrewCount(crewCount);
    }

    public String getWeaponSystem() {
        return weaponSystem;
    }

    public int getCrewCount() {
        return crewCount;
    }

    public void setWeaponSystem(String weaponSystem) {
        if (weaponSystem == null || weaponSystem.trim().isEmpty()) {
            throw new IllegalArgumentException("Система вооружения не может быть пустой.");
        }
        this.weaponSystem = weaponSystem;
    }

    public void setCrewCount(int crewCount) {
        if (crewCount <= 0) {
            throw new IllegalArgumentException("Численность экипажа должна быть больше 0.");
        }
        this.crewCount = crewCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Corvette corvette = (Corvette) obj;

        return crewCount == corvette.crewCount &&
                Objects.equals(weaponSystem, corvette.weaponSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weaponSystem, crewCount);
    }

    @Override
    public String toString() {
        return "Корвет {" +
                super.toString() +
                ", weaponSystem='" + weaponSystem + '\'' +
                ", crewCount=" + crewCount +
                '}';
    }
}