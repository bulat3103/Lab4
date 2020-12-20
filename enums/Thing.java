package enums;

public enum Thing {
    WARDROBE("шкаф"),
    LOCKER ("шкафчик"),
    SHELF ("полку"),
    PICTURE ("картину"),
    MAP ("географическую карту");

    private String title;

    Thing(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static Thing randomThing() {
        int rnd = (int) (Math.random() * 5);
        switch (rnd) {
            case 0:
                return null;
            case 1:
                return Thing.WARDROBE;
            case 2:
                return Thing.LOCKER;
            case 3:
                return Thing.SHELF;
            case 4:
                return Thing.PICTURE;
            case 5:
                return Thing.MAP;
        }
        return Thing.WARDROBE;
    }
}
