package characters;

import enums.*;
import exceptions.InvalidParameterException;
import exceptions.NotPutException;
import exceptions.NotTakeException;
import interfaces.IdentificationStrategy;
import interfaces.iFlyable;
import materialObjects.Furniture;
import materialObjects.Subject;
import placesPackage.APlace;

import java.util.ArrayList;
import java.util.Objects;

public class MainHero extends Human implements iFlyable {
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
    public void Fly() {
        this.currentCoordinat += this.speed;
        if (this.currentCoordinat >= this.place.getDeep()) {
            System.out.println("Алиса достигла дна " + place.getTypePlace().toString() + " и открыла волшебную дверь");
        } else {
            System.out.println(super.getName() + " летит со скоростью " + this.speed + " м/с. Место: " + place.getTypePlace().toString());
            System.out.println("Текущая координата: " + this.currentCoordinat);
        }
    }

    @Override
    public void say(String text) {
        System.out.println(text);
    }

    public void take(Subject sbj) throws NotTakeException {
        if (this.subject == null) throw new NotTakeException(super.name + " уже взяла объект");
        this.subject = sbj;
        System.out.println(super.name + " взяла " + sbj.toString());
        if (!this.subject.getTitle().equals("")) {
            System.out.println(super.name + " прочитала на " + this.subject.toString() + "'" + this.subject.getTitle() + "'");
        } else {
            System.out.println(super.name + " попыталась узнать, что за вещь, но эта вещь не подписана");
        }
    }

    public void put(Furniture furn) throws NotPutException {
        if (this.subject == null) throw new NotPutException(super.name + " ничего не держала в руках");
        furn.addSubject(this.subject);
        System.out.println(super.name + " положила " + this.subject + " на " + furn.toString());
        this.subject = null;
    }

    @Override
    public void Look(Direction dir) {
        if (this.currentCoordinat < this.place.getDeep())
        System.out.println(super.getName() + " посмотрела " + dir.toString());
    }

    @Override
    public void walk(APlace place) {
        System.out.println(super.name + " идет по " + place.toString());
    }


    @Override
    public ArrayList<Furniture> Identificate(Direction dir) {
        return IStrategy.Identificate(dir, place, this.currentCoordinat);
    }

    public void lookFor(Animal animal) {
        System.out.println(super.name + " преследует " + animal.name);
    }

    public double getCurrentCoordinat() {
        return currentCoordinat;
    }

    public void setCurrentCoordinat(double currentCoordinat) {
        this.currentCoordinat = currentCoordinat;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public APlace getPlace() {
        return place;
    }

    public void setPlace(APlace place) {
        System.out.println("Алиса оказалась в " + place.toString());
        this.place = place;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
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
