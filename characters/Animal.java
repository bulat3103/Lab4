package characters;

import enums.Colors;
import placesPackage.APlace;

import java.util.Objects;

public abstract class Animal {
    protected Colors color;
    protected String name;

    public Animal(Colors color, String name) {
        this.color = color;
        this.name = name;
    }

    public abstract void run(APlace where);

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return color == animal.color &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
