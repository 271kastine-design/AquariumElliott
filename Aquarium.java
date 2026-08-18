import java.util.Arrays;

public class Aquarium {

    public static final int TANK_WIDTH = 48;

    private SeaCreature[] creatures;
    private int turnNumber;

    public Aquarium(SeaCreature[] creatures) {
        this.creatures = creatures;
        this.turnNumber = 0;
    }

    public void display() {
        System.out.println();
        System.out.println("TURN " + turnNumber);
        System.out.println("+" + "-".repeat(TANK_WIDTH) + "+");

        boolean foundCreature = false;

        for (SeaCreature creature : creatures) {
            if (creature != null) {
                foundCreature = true;
                System.out.println(buildLane(creature));
            }
        }

        if (!foundCreature) {
            System.out.println("|" + center("The aquarium is empty.", TANK_WIDTH) + "|");
        }

        System.out.println("+" + "-".repeat(TANK_WIDTH) + "+");
    }

    public void advanceTurn() {
        turnNumber++;

        System.out.println();
        System.out.println("Advancing to turn " + turnNumber + "...");

        for (SeaCreature creature : creatures) {
            if (creature != null) {
                int oldPosition = creature.getPosition();
                creature.move(TANK_WIDTH);

                System.out.println(
                        creature.getName()
                                + " moved from " + oldPosition
                                + " to " + creature.getPosition()
                                + "."
                );
            }
        }
    }

    public void listCreatureDetails() {
        System.out.println();
        System.out.println("CREATURE DETAILS");
        System.out.println("----------------");

        int number = 1;

        for (SeaCreature creature : creatures) {
            if (creature != null) {
                System.out.println(number + ". " + creature);
                number++;
            }
        }

        if (number == 1) {
            System.out.println("No creatures are currently in the aquarium.");
        }
    }

    public SeaCreature[] getCreatures() {
        return creatures;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    private String buildLane(SeaCreature creature) {
        char[] lane = new char[TANK_WIDTH];
        Arrays.fill(lane, ' ');

        String symbol = creature.getSymbol();
        int start = Math.max(0,
                Math.min(creature.getPosition(), TANK_WIDTH - symbol.length()));

        for (int i = 0; i < symbol.length() && start + i < lane.length; i++) {
            lane[start + i] = symbol.charAt(i);
        }

        return "|" + new String(lane) + "| "
                + creature.getName() + " ("
                + creature.getClass().getSimpleName() + ")";
    }

    private String center(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }

        int totalPadding = width - text.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }
}
