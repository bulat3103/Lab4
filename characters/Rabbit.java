package characters;

import enums.Colors;
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
        System.out.println("Кролик " + this.name + " бежит в " + where.getTypePlace());
    }
}
