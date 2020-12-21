package characters;

import enums.Colors;
import exceptions.InvalidParameterException;
import placesPackage.APlace;

public class Rabbit extends Animal {

    public Rabbit() {
        super(Colors.WHITE, "Тишка");
    }

    public Rabbit(Colors color, String name) {
        super(color, name);
    }

    @Override
    public void run(APlace where) {
        if (where == null)throw new InvalidParameterException("Передается Null в where");
        super.place = where;
        System.out.println("Кролик " + super.name + " бежит в " + where.toString());
    }
}
