package characters;

import enums.*;
import exceptions.InvalidParameterException;
import exceptions.NotPutException;
import exceptions.NotTakeException;
import interfaces.IdentificationStrategy;
import interfaces.Moveable;
import materialObjects.Furniture;
import materialObjects.Subject;
import placesPackage.APlace;

import java.util.ArrayList;
import java.util.Objects;

public class MainHero extends Human implements Moveable {
    private double currentCoordinat = 0;
    private double speed;
    private APlace place;
    private Subject subject;

    public MainHero(String name, int age, Sex sex, double speed, IdentificationStrategy IStrategy) {
        super(name, age, sex, IStrategy);
        if (speed < 0) throw new InvalidParameterException("Скорость может быть только положительным числом");
        this.speed = speed;
    }

    @Override
    public void Move() {
        this.currentCoordinat += this.speed;
        if (this.currentCoordinat >= this.place.getDeep()) {
            System.out.printf("%s достигла конца. Дальше ее ждет неизвестность.", super.getName());
            System.out.println();
        } else {
            System.out.printf("%s %s со скоростью %s м/с. Место: %s", super.getName(), place.getPlaceOrientation().toString(), this.speed, place.getTypePlace().toString());
            System.out.println();
            System.out.printf("Текущая координата: %s", this.currentCoordinat);
            System.out.println();
        }
    }

    public void say(String text) {
        if (text == null)throw new InvalidParameterException("Передается Null в text");
        System.out.println(text);
    }

    public void take(Subject sbj) throws NotTakeException {
        if (sbj == null)throw new InvalidParameterException("Передается Null в sbj");
        if (this.subject != null) throw new NotTakeException(super.name + " уже взяла объект");
        this.subject = sbj;
        System.out.println(super.name + " взяла " + sbj.toString());
        if (!this.subject.getTitle().equals("")) {
            System.out.println(super.name + " прочитала на " + this.subject.toString() + "'" + this.subject.getTitle() + "'");
        } else {
            System.out.println(super.name + " попыталась узнать, что за вещь, но эта вещь не подписана");
        }
    }

    public void put(Furniture furn) throws NotPutException {
        if (furn == null)throw new InvalidParameterException("Передается Null в furn");
        if (this.subject == null) throw new NotPutException(super.name + " ничего не держала в руках");
        furn.addSubject(this.subject);
        System.out.println(super.name + " положила " + this.subject + " на " + furn.toString());
        this.subject = null;
    }

    @Override
    public void Look(Direction dir) {
        if (dir == null)throw new InvalidParameterException("Передается Null в dir");
        if (this.currentCoordinat < this.place.getDeep())
        System.out.println(super.getName() + " посмотрела " + dir.toString());
    }

    @Override
    public ArrayList<Furniture> Identificate(Direction dir) {
        if (dir == null)throw new InvalidParameterException("Передается Null в dir");
        return IStrategy.Identificate(dir, place, this.currentCoordinat);
    }

    public void lookFor(Animal animal) {
        if (animal == null)throw new InvalidParameterException("Передается Null в animal");
        this.place = animal.place;
        System.out.println(super.name + " преследует " + animal.name);
    }

    public double getCurrentCoordinat() {
        return currentCoordinat;
    }

    public double getSpeed() {
        return speed;
    }

    public void setCurrentCoordinat(double currentCoordinat) {
        this.currentCoordinat = currentCoordinat;
    }

    public void setSpeed(double speed) {
        if (speed < 0)throw new InvalidParameterException("Скорость не может быть отрицательной");
        this.speed = speed;
    }

    public APlace getPlace() {
        return place;
    }

    public void setPlace(APlace place) {
        if (place == null)throw new InvalidParameterException("Передается Null в place");
        System.out.println("Алиса оказалась в " + place.toString());
        this.place = place;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        if (subject == null)throw new InvalidParameterException("Передается Null в subject");
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MainHero other = (MainHero) o;
        return Double.compare(other.currentCoordinat, currentCoordinat) == 0 &&
                Double.compare(other.speed, speed) == 0 &&
                Objects.equals(place, other.place) &&
                Objects.equals(IStrategy, other.IStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentCoordinat, speed, place, IStrategy);
    }
}
