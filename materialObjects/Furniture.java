package materialObjects;

import enums.*;
import exceptions.InvalidParameterException;
import exceptions.NotPutException;

import java.util.ArrayList;
import java.util.Objects;

public class Furniture{
    private final Thing type;
    private final Direction dir;
    private final int deepCoordinat;
    private ArrayList<Subject> subjects;

    private Furniture(Builder builder) {
        if (builder == null) throw new InvalidParameterException("Передается Null в builder");
        this.type = builder.type;
        this.dir = builder.dir;
        this.deepCoordinat = builder.deepCoordinat;
        this.subjects = builder.subjects;
    }

    public static class Builder {
        private Thing type;
        private Direction dir;
        private int deepCoordinat;
        private ArrayList<Subject> subjects = null;

        public Builder type(Thing type) {
            if (type == null)throw new InvalidParameterException("Передается Null в type");
            this.type = type;
            return this;
        }

        public Builder dir(Direction dir) {
            if (dir == null)throw new InvalidParameterException("Передается Null в dir");
            this.dir = dir;
            return this;
        }

        public Builder deepCoordinat(int deepCoordinat) {
            if (deepCoordinat < 0) throw new InvalidParameterException("Координата должна быть положительным числом");
            this.deepCoordinat = deepCoordinat;
            return this;
        }

        public Builder subjects() {
            this.subjects = new ArrayList<>();
            return this;
        }

        public Furniture build() {
            return new Furniture(this);
        }
    }

    public void addSubject(Subject sbj) throws NotPutException {
        if (sbj == null) throw new InvalidParameterException("Передается Null в Subject");
        if (this.type == Thing.PICTURE || this.type == Thing.MAP) {
            throw new NotPutException("Сюда нельзя положить вещи");
        }
        subjects.add(sbj);
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public Thing getType() {
        return type;
    }

    public Direction getDir() {
        return dir;
    }

    public int getDeepCoordinat() {
        return deepCoordinat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return deepCoordinat == furniture.deepCoordinat &&
                type == furniture.type &&
                dir == furniture.dir &&
                Objects.equals(subjects, furniture.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, dir, deepCoordinat, subjects);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
