package characters;

import enums.Colors;
import exceptions.InvalidParameterException;
import placesPackage.APlace;

import java.util.Objects;

public abstract class Animal {
    protected Colors color;
    protected String name;
    protected APlace place;

    public Animal(Colors color, String name) {
        if (color == null)throw new InvalidParameterException("Передается Null в color");
        if (name == null)throw new InvalidParameterException("Передается Null в name");
        this.color = color;
        this.name = name;
    }

    public abstract void run(APlace where);

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        if (color == null)throw new InvalidParameterException("Передается Null в color");
        this.color = color;
    }

    public APlace getPlace() {
        return place;
    }

    public void setPlace(APlace place) {
        if (place == null)throw new InvalidParameterException("Передается Null в place");
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)throw new InvalidParameterException("Передается Null в name");
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
