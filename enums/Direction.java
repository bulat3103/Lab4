package enums;

public enum Direction {
    LEFT ("налево"),
    RIGHT ("направо"),
    BACK ("назад"),
    FORWARD ("вперед"),
    DOWN ("вниз"),
    UP ("вверх");

    private String title;

    Direction(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static Direction randomDirection() {
        int rnd = (int) (Math.random() * 6);
        switch (rnd) {
            case 0:
                return Direction.LEFT;
            case 1:
                return Direction.RIGHT;
            case 2:
                return Direction.BACK;
            case 3:
                return Direction.FORWARD;
            case 4:
                return Direction.DOWN;
            case 5:
                return Direction.UP;
        }
        return Direction.FORWARD;
    }
}
