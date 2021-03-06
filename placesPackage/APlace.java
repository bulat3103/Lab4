package placesPackage;

import enums.PlaceOrientation;
import enums.Places;
import exceptions.InvalidParameterException;
import materialObjects.Furniture;

import java.util.ArrayList;
import java.util.Objects;

public abstract class APlace {
    private Places typePlace;
    private int deep;
    protected ArrayList<Furniture> furn = new ArrayList<>();
    private final PlaceOrientation placeOrientation;

    public APlace(Places typePlace, int deep, PlaceOrientation placeOrientation) {
        if (typePlace == null) throw new InvalidParameterException("Передается Null в typePlace");
        if (placeOrientation == null) throw new InvalidParameterException("Передается Null в placeOrientation");
        if (deep <= 0) throw new InvalidParameterException("Глубина не может быть отрицательной");
        this.typePlace = typePlace;
        this.deep = deep;
        this.placeOrientation = placeOrientation;
    }

    public PlaceOrientation getPlaceOrientation() {
        return placeOrientation;
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
