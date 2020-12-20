package placesPackage;

import enums.Places;
import materialObjects.Furniture;

public class Place extends APlace {
    public Place() {
        super();
    }

    public Place(Places typePlace, int deep) {
        super(typePlace, deep);
    }

    @Override
    public void addFurn(Furniture f) {
        super.furn.add(f);
    }
}
