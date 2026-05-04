import java.util.Objects;

public class Ship {
    private int id;
    private String name;

    public Ship() {
        this.id = 0;
        this.name = "Без названия";
    }

    public Ship(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID не может быть отрицательным.");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ship ship = (Ship) obj;

        return id == ship.id &&
                Objects.equals(name, ship.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + "'";
    }
}