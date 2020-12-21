package characters;

import enums.*;
import exceptions.InvalidParameterException;
import interfaces.IdentificationStrategy;
import interfaces.iHuman;
import materialObjects.Furniture;
import placesPackage.APlace;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Human implements iHuman {
    protected String name;
    protected int age;
    protected Sex sex;
    protected IdentificationStrategy IStrategy;

    public Human() {
        this.name = "Неизвестный";
        this.age = 18;
        this.sex = Sex.BOY;
    }

    public Human(String name, int age, Sex sex, IdentificationStrategy IStrategy) {
        if (age < 0) throw new InvalidParameterException("Возраст может быть только положительным числом");
        if (name == null) throw new InvalidParameterException("Полю Name пытаются передать значение Null");
        if (IStrategy == null)throw new InvalidParameterException("Передается Null в IStrategy");
        if (sex == null)throw new InvalidParameterException("Передается Null в sex");
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.IStrategy = IStrategy;
    }

    public abstract ArrayList<Furniture> Identificate(Direction dir);

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setIStrategy(IdentificationStrategy iStrategy) {
        if (IStrategy == null)throw new InvalidParameterException("Передается Null в IStrategy");
        this.IStrategy = iStrategy;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(name, human.name) &&
                sex == human.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    public Sex getSex() {
        return this.sex;
    }
}
