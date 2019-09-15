import java.util.Scanner;

public class TextUserInterface {
    private final Scanner scanner;
    private final BirdDatabase birdDatabase;

    public TextUserInterface(Scanner scanner, BirdDatabase birdDatabase) {
        this.scanner = scanner;
        this.birdDatabase = birdDatabase;
    }

    public void startMenu() {
        boolean quit = false;

        while (!quit) {
            printMenu();
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "x":
                    quit = true;
                    break;
                case "1":
                    addBird();
                    break;
                case "2":
                    addObservation();
                    break;
                case "3":
                    birdDatabase.printAllBirds();
                    break;
                case "4":
                    printBird();
                    break;
                default:
                    System.out.println("Enter a valid command");
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.printf("%nChoose command:%n"
                + "[1] Add bird%n"
                + "[2] Add observation%n"
                + "[3] Print all birds%n"
                + "[4] Print one bird%n"
                + "[x] Quit%n%n> ");
    }

    private void addBird() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Latin name: ");
        String latinName = scanner.nextLine();

        birdDatabase.addBird(name, latinName);
    }

    private void addObservation() {
        System.out.print("What bird was observed? ");
        String bird = scanner.nextLine();

        if (birdDatabase.hasBird(bird)) {
            birdDatabase.incrementBird(bird);
        } else {
            System.out.println("Is not a bird!");
        }
    }

    private void printBird() {
        System.out.print("What bird? ");
        String bird = scanner.nextLine();

        if (birdDatabase.hasBird(bird)) {
            birdDatabase.printBird(bird);
        }
    }
}
