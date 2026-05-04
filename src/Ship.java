import java.util.Objects;

public class Ship {
    private int id;
    private String name;

    private static final int DEFAULT_ID = 0;
    private static final String DEFAULT_NAME = "Корабль без названия";

    public Ship() {
        this(DEFAULT_ID, DEFAULT_NAME);
    }

    public Ship(int id, String name) {
        this.id = id;
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNullElse(name, DEFAULT_NAME);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Ship ship)) {
            return false;
        }

        return id == ship.id && Objects.equals(name, ship.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ID корабля: " + id +
                ",\n Название корабля:" + name;
    }
}