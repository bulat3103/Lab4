package placesPackage;

import enums.PlaceOrientation;
import enums.Places;
import exceptions.InvalidParameterException;
import materialObjects.Furniture;

public class Place extends APlace {
    public Place() {
        super(Places.PIT, 10, PlaceOrientation.HORIZONTAL);
    }

    public Place(Places typePlace, int deep, PlaceOrientation placeOrientation) {
        super(typePlace, deep, placeOrientation);
    }

    @Override
    public void addFurn(Furniture f) {
        if (f == null) throw new InvalidParameterException("Передается Null в type");
        super.furn.add(f);
    }
}
