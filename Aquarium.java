import java.util.ArrayList;
import java.util.Arrays;

public class Aquarium {

    public static final int TANK_WIDTH = 48;

    private ArrayList<SeaCreature> creatures;
    private int turnNumber;

    public Aquarium(ArrayList<SeaCreature> creatures) {
        this.creatures = creatures;
        this.turnNumber = 0;
    }

    public void display() {
        System.out.println();
        System.out.println("TURN " + turnNumber);
        System.out.println("+" + repeat("-", TANK_WIDTH) + "+");

        // Track if any creatures exist to display appropriate message
        boolean foundCreature = false;

        for (SeaCreature creature : creatures) {
            // Only display non-null creatures (in case some were removed)
            if (creature != null) {
                foundCreature = true;
                System.out.println(buildLane(creature));
            }
        }

        if (!foundCreature) {
            System.out.println("|" + center("The aquarium is empty.", TANK_WIDTH) + "|");
        }

        System.out.println("+" + repeat("-", TANK_WIDTH) + "+");
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
    
    public ArrayList<SeaCreature> getCreatures() {
        return creatures;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
    public void addCreature() {
        // Randomly select one of three creature types (Fish, Shark, or Turtle)
        int i = (int)(Math.random()*3 + 1);
        try {
            if(i == 1){
                // Random position 0-29, fixed speed 2, random direction (-1 or 1)
                creatures.add(new Fish("Fishy", (int)(Math.random() * 30), 2, Math.random() < 0.5 ? -1 : 1, "><>"));
            } else if(i == 2) {
                creatures.add(new Shark("Sharky", (int)(Math.random() * 30), 4, Math.random() < 0.5 ? -1 : 1, ">>()[}\'<"));
            } else {
                creatures.add(new Turtle("Turtley", (int)(Math.random() * 30), 1, (Math.random() < 0.5) ? -1 : 1, "O==[]::::>"));
            }
            System.out.println();
            System.out.println("Adding a new creature to the aquarium...");
        } catch (InvalidCreatureException e) {
            System.err.println("Error adding creature: " + e.getMessage());
        }
    }

    private String buildLane(SeaCreature creature) {
        // Create an array of spaces representing the tank width
        char[] lane = new char[TANK_WIDTH];
        Arrays.fill(lane, ' ');

        String symbol = creature.getSymbol();
        // Clamp position to valid range: Math.max(0, ...) ensures position >= 0,
        // Math.min(..., TANK_WIDTH - symbol.length()) ensures symbol doesn't extend past tank edge
        int start = Math.max(0,
                Math.min(creature.getPosition(), TANK_WIDTH - symbol.length()));

        // Place each character of the creature's symbol into the lane at the correct position
        for (int i = 0; i < symbol.length() && start + i < lane.length; i++) {
            lane[start + i] = symbol.charAt(i);
        }

        // Build the display line: tank walls, creature, creature name and type
        return "|" + new String(lane) + "| "
                + creature.getName() + " ("
                + creature.getClass().getSimpleName() + ")";
    }

    // Centers text within a given width, truncating if text is too long
    private String center(String text, int width) {
        // If text exceeds width, truncate it to fit
        if (text.length() >= width) {
            return text.substring(0, width);
        }

        // Calculate padding to center the text
        int totalPadding = width - text.length();
        int leftPadding = totalPadding / 2;
        // rightPadding accounts for odd widths where left and right padding differ by 1
        int rightPadding = totalPadding - leftPadding;

        return repeat(" ", leftPadding) + text + repeat(" ", rightPadding);
    }

    // Efficiently repeats a string by using StringBuilder (more efficient than string concatenation)
    private String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}