import java.util.Scanner;
import java.util.ArrayList;

public class AquariumApp {

    public static void main(String[] args) {

        ArrayList<SeaCreature> tank = new ArrayList<>();

        // Two starter creatures.
        try {
            tank.add(new Fish("Nemo", 4, 3, 1, "><>"));
            tank.add(new Fish("Dory", 30, 2, -1, "><((('>)"));
            tank.add(new Shark("Jaws", 12, 4, 1, ">>()[}\'<"));
            tank.add(new Turtle("Leonardo", 20, 1, -1, "O==[]::::>"));
            tank.add(new Fish("Broken Fish", 100, -40, 3, "><>")); 
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating creatures: " + e.getMessage());
        }
        try{
            tank.add(new Turtle("Evil Turtle", 30, -64, 1, "O==[]::::>"));
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating creatures: " + e.getMessage());
        }
        try{
            tank.add(new Shark("", 21, 8, 1, ">>>[}\'<"));
        } catch (InvalidCreatureException e) {
            System.err.println("Error creating creatures: " + e.getMessage());
        }
        // ================
        // =====================================
        // STUDENT Task
        // =====================================================
        // 1. Create at least TWO additional SeaCreature subclasses.
        // 2. Add objects from those subclasses to this array.
        // 3. Make their movement behavior meaningfully different.
        //
        // Example once you create the class:
        // tank[2] = new Shark(...);
        // tank[3] = new Turtle(...);

        Aquarium aquarium = new Aquarium(tank);
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    aquarium.display();
                    break;

                case "2":
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;

                case "3":
                    aquarium.listCreatureDetails();
                    break;

                case "4":
                    running = false;
                    System.out.println("Aquarium closed. Goodbye!");
                    break;

                case "5":
                    aquarium.addCreature();
                    break;

                default:
                    System.out.println("Please choose 1, 2, 3, 4, or 5.");
            }
        }

        input.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. View Creature Details");
        System.out.println("4. Quit");
        System.out.println("5. Add Creature");
    }
}
