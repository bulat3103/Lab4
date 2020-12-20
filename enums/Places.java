package enums;

public enum Places {
    PIT("колодец"),
    HOLE("яма"),
    BASEMENT("подвал"),
    BURROW("нора");


    private String title;

    Places(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
