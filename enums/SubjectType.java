package enums;

public enum SubjectType {
    JAR("банку"),
    BOTTLE("бутылку"),
    CUP("чашку");

    private String title;

    SubjectType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static SubjectType randomSubject() {
        int rnd = (int) (Math.random() * 3);
        switch (rnd) {
            case 0:
                return SubjectType.JAR;
            case 1:
                return SubjectType.BOTTLE;
            case 2:
                return SubjectType.CUP;
        }
        return SubjectType.JAR;
    }
}
