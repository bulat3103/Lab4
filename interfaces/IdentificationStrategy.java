package interfaces;

import enums.Direction;
import materialObjects.Furniture;
import placesPackage.APlace;

import java.util.ArrayList;

public interface IdentificationStrategy {
    ArrayList<Furniture> Identificate(Direction dir, APlace place, double currentCoordinat);
}
