package placesPackage;

import enums.Places;
import materialObjects.Furniture;

import java.util.ArrayList;
import java.util.Objects;

public abstract class APlace {
    private Places typePlace;
    private int deep;
    protected ArrayList<Furniture> furn = new ArrayList<>();

    public APlace() {
        this.typePlace = Places.PIT;
        this.deep = 10;
    }

    public APlace(Places typePlace, int deep) {
        this.typePlace = typePlace;
        this.deep = deep;
    }

    public int getDeep() {
        return this.deep;
    }

    public ArrayList<Furniture> getFurn() {
        return furn;
    }

    public Places getTypePlace() {
        return this.typePlace;
    }

    public abstract void addFurn(Furniture f);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APlace aPlace = (APlace) o;
        return deep == aPlace.deep &&
                typePlace.equals(aPlace.typePlace) &&
                Objects.equals(furn, aPlace.furn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typePlace, deep, furn);
    }

    @Override
    public String toString() {
        return typePlace.toString();
    }
}
