class Car {
    private static final int MIN_FORWARD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_FORWARD) {
            position++;
        }
    }

    public boolean isMaxPosition(int max) {
        return position == max;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
