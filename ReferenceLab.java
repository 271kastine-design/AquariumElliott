import java.util.ArrayList;
public class ReferenceLab {

    public static void main(String[] args) {

        // ==================================================
        // EXPERIMENT A: ALIASING
        // ==================================================

        SeaCreature nemo = null;
        try {
            nemo = new Fish("Nemo", 5, 3, 1, "><>");
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating nemo: " + e.getMessage());
        }
        SeaCreature copy = nemo;

        // PREDICT BEFORE RUNNING:
        // What will copy.getPosition() return after nemo.setPosition(25)?

        nemo.setPosition(25);

        System.out.println("Experiment A - Aliasing");
        System.out.println("nemo position: " + nemo.getPosition());
        System.out.println("copy position: " + copy.getPosition());
        //This will return 25 for both nemo and copy because they are referencing the same object in memory. 
        // When you modify the position of nemo, it also affects copy since they are both pointing to the same instance of the Fish class.

        // ==================================================
        // EXPERIMENT B: TWO DIFFERENT OBJECTS
        // ==================================================

        SeaCreature fish1 = null;
        SeaCreature fish2 = null;
        try {
            fish1 = new Fish("Fish", 10, 2, 1, "><>");
            fish2 = new Fish("Fish", 10, 2, 1, "><>");
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating fish: " + e.getMessage());
        }

        // PREDICT BEFORE RUNNING:
        // Will fish1 == fish2 be true or false?

        System.out.println();
        System.out.println("Experiment B - Separate Objects");
        System.out.println("fish1 == fish2: " + (fish1 == fish2));
        //This will turn false because while these two objects are the same type, they are not the same object in memory. 
        // They are two different instances of the Fish class, so they will not be equal when compared using the '==' operator.
        //'==' compares the memory addresses of the two objects.

        // ==================================================
        // EXPERIMENT C: ARRAY REFERENCES
        // ==================================================

        ArrayList<SeaCreature> tank = new ArrayList<>();
        try {
            tank.add(new Fish("Bubbles", 8, 1, 1, "><((('>)"));
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating bubbles: " + e.getMessage());
        }

        SeaCreature selected = tank.get(0);

        // PREDICT BEFORE RUNNING:
        // What happens to tank.get(0) if selected is modified?
        //tank.get(0) will also be modified because selected is a reference to the same object in memory.
        selected.setPosition(35);

        System.out.println();
        System.out.println("Experiment C - Array References");
        System.out.println("selected position: " + selected.getPosition());
        System.out.println("tank.get(0) position: " + tank.get(0).getPosition());
    }
}
