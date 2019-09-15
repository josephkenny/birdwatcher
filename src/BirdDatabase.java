import java.util.HashMap;
import java.util.Map;

public class BirdDatabase {
    private final Map<Bird, Integer> birdToObservation = new HashMap<>();

    public Bird getBird(String name) {
        for (Bird bird : birdToObservation.keySet()) {
            if (name.equals(bird.getName())) {
                return bird;
            }
        }
        return null;
    }

    public void addBird(String name, String latinName) {
        Bird bird = new Bird(name, latinName);
        birdToObservation.putIfAbsent(bird, 0);
    }

    public void incrementBird(String name) {
        Bird bird = getBird(name);
        birdToObservation.replace(bird, birdToObservation.get(bird) + 1);
    }

    public void printBird(String name) {
        Bird bird = getBird(name);
        if (bird == null) {
            System.out.println("Is not a bird!");
            return;
        }

        if (birdToObservation.get(bird) == 1) {
            System.out.println(bird + ": " + birdToObservation.get(bird) + " observation");
        } else {
            System.out.println(bird + ": " + birdToObservation.get(bird) + " observations");
        }
    }

    public void printAllBirds() {
        for (Bird bird : birdToObservation.keySet()) {
            printBird(bird.getName());
        }
    }

    public boolean hasBird(String name) {
        return getBird(name) != null;
    }
}
