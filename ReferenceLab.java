import java.util.ArrayList;
public class ReferenceLab {

    public static void main(String[] args) {

        // ==================================================
        // EXPERIMENT A: ALIASING
        // ==================================================

        SeaCreature nemo = null;
        // Try-catch is needed because Fish constructor validates parameters and can throw
        // InvalidCreatureException if the creature data is invalid
        try {
            nemo = new Fish("Nemo", 5, 3, 1);
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating nemo: " + e.getMessage());
        }
        // copy is assigned the same reference as nemo - both variables point to the same
        // Fish object in memory (not a separate copy of the data)
        SeaCreature copy = nemo;

        // PREDICT BEFORE RUNNING:
        // What will copy.getPosition() return after nemo.setPosition(25)?

        nemo.setPosition(25);

        System.out.println("Experiment A - Aliasing");
        System.out.println("nemo position: " + nemo.getPosition());
        System.out.println("copy position: " + copy.getPosition());
        // Both show 25 because nemo and copy are aliases (references to the same Fish object).
        // Modifying one affects the other since they share the same memory location.

        // ==================================================
        // EXPERIMENT B: TWO DIFFERENT OBJECTS
        // ==================================================

        SeaCreature fish1 = null;
        SeaCreature fish2 = null;
        // Even though both Fish objects have identical parameters, they are separate
        // instances created with distinct 'new' calls in different memory locations
        try {
            fish1 = new Fish("Fish", 10, 2, 1);
            fish2 = new Fish("Fish", 10, 2, 1);
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating fish: " + e.getMessage());
        }

        // PREDICT BEFORE RUNNING:
        // Will fish1 == fish2 be true or false?

        System.out.println();
        System.out.println("Experiment B - Separate Objects");
        System.out.println("fish1 == fish2: " + (fish1 == fish2));
        // Returns false because '==' compares object references (memory addresses), not content.
        // fish1 and fish2 are different objects in memory, even though their data is identical.

        // ==================================================
        // EXPERIMENT C: ARRAY REFERENCES
        // ==================================================

        // ArrayList is declared with type SeaCreature (parent class) to allow storing
        // any SeaCreature subtype (Fish, Shark, Turtle, etc.) for polymorphic flexibility
        ArrayList<SeaCreature> tank = new ArrayList<>();
        try {
            tank.add(new Fish("Bubbles", 8, 1, 1));
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating bubbles: " + e.getMessage());
        }

        // selected holds a reference to the Fish object stored in tank (at index 0).
        // This reference can be used to modify the original object in the ArrayList.
        SeaCreature selected = tank.get(0);

        // PREDICT BEFORE RUNNING:
        // What happens to tank.get(0) if selected is modified?
        // Modifying selected will also update tank.get(0) because they reference the same Fish object.
        selected.setPosition(35);

        System.out.println();
        System.out.println("Experiment C - Array References");
        System.out.println("selected position: " + selected.getPosition());
        System.out.println("tank.get(0) position: " + tank.get(0).getPosition());
        // Both print 35 because selected is an alias to the Fish object stored in the ArrayList.
    }
}
