public class Turtle extends SeaCreature{
    private static final String SYMBOL = "o=o";
    private int turnNumber;
    
    public Turtle(String name, int position, int speed, int direction) throws InvalidCreatureException {
        super(name, position, speed, direction);
    }

    @Override
    public void move(int tankWidth) {
        if(turnNumber % 2 == 0)
        {
            position += speed * direction*2;
            keepInsideTank(tankWidth);
        }
        turnNumber++;
    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? SYMBOL : reverseSymbol(SYMBOL);
    }

    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    } 
}
