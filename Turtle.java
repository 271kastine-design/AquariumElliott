public class Turtle extends SeaCreature{
    private String symbol;
    private int turnNumber;
    
    public Turtle(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        this.symbol = symbol;
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
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }

    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    } 
}
