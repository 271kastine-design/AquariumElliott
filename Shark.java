public class Shark extends SeaCreature{
    private static final String SYMBOL = ">>()[]}\'<";
    
    public Shark(String name, int position, int speed, int direction) throws InvalidCreatureException {
        super(name, position, speed, direction);
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction*2;
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
