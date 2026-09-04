import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class AquariumApp {

    public static void main(String[] args) {
        ArrayList<SeaCreature> tank = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File("Fish.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    tank.add(parseCreature(line));
                } catch (InvalidCreatureException | IllegalArgumentException e) {
                    System.err.println("Could not parse line: " + line);
                    System.err.println("Reason: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not open Fish.txt: " + e.getMessage());
        }

        Aquarium aquarium = new Aquarium(tank);
        // Scanner reads user input from the keyboard
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");

        // Main event loop: continues until user chooses to quit
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            // trim() removes leading/trailing whitespace from user input
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    aquarium.display();
                    break;

                case "2":
                    // Advance turn first, then display so user sees the updated positions
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;

                case "3":
                    aquarium.listCreatureDetails();
                    break;

                case "4":
                    // Set running to false to exit the loop and end the program
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

        // Close the Scanner to release system resources
        input.close();
    }

    private static SeaCreature parseCreature(String line) throws InvalidCreatureException {
        String[] fields = line.split(",", 5);

        if (fields.length != 5) {
            throw new IllegalArgumentException("Expected type, name, position, speed, and direction.");
        }
        String type = fields[0].trim();
        String name = fields[1].trim();
        int position = Integer.parseInt(fields[2].trim());
        if(position < 0 || position > 48) {
            throw new InvalidCreatureException("Position must be between 0 and 48.");
        }
        int speed = Integer.parseInt(fields[3].trim());
        int direction = Integer.parseInt(fields[4].trim());
        if(direction != 1 && direction != -1) {
            throw new InvalidCreatureException("Direction must be 1 (right) or -1 (left).");
        }
        switch (type) {
            case "Fish":
                return new Fish(name, position, speed, direction);
            case "Shark":
                return new Shark(name, position, speed, direction);
            case "Turtle":
                return new Turtle(name, position, speed, direction);
            default:
                throw new IllegalArgumentException("Unknown creature type: " + type);
        }
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