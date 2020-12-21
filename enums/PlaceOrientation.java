package enums;

public enum PlaceOrientation {
    VERTICAL("летит"),
    HORIZONTAL("ползет");

    private String title;

    PlaceOrientation(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
