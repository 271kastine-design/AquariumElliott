public abstract class SeaCreature {

    protected String name;
    protected int position;
    protected int speed;
    protected int direction;

    public SeaCreature(String name, int position, int speed, int direction) throws InvalidCreatureException {
        if (position < 0 || position >= 48) {
            throw new InvalidCreatureException("Position is out of bounds.");
        }
        if (speed < 0) {
            throw new InvalidCreatureException("Speed cannot be negative.");
        }
        if(name == null || name.isEmpty()) {
            throw new InvalidCreatureException("Name cannot be null or empty.");
        }
        this.name = name;
        this.position = position;
        this.speed = speed;
        this.direction = direction;
    }

    // Each subclass decides how it moves.
    public abstract void move(int tankWidth);

    // Each subclass decides how it looks in the terminal.
    public abstract String getSymbol();

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void turnAround() {
        direction *= -1;
    }

    protected void keepInsideTank(int tankWidth) {
        int maxPosition = Math.max(0, tankWidth - getSymbol().length());

        if (position > maxPosition) {
            position = maxPosition;
            direction = -1;
        }

        if (position < 0) {
            position = 0;
            direction = 1;
        }
    }

    public String getDirectionWord() {
        return direction >= 0 ? "right" : "left";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " | name=" + name
                + " | position=" + position
                + " | speed=" + speed
                + " | direction=" + getDirectionWord();
    }
}
