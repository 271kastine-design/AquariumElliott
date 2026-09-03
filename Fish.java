public class Fish extends SeaCreature {

    private static final String SYMBOL = "><o";

    public Fish(String name, int position, int speed, int direction) throws InvalidCreatureException {
        super(name, position, speed, direction);
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);
    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? SYMBOL : reverseSymbol(SYMBOL);
    }

    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
