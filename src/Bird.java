public class Bird {
    private final String name;
    private final String latinName;

    public Bird(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
    }

    public Bird(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public String getLatinName() {
        return latinName;
    }

    @Override
    public String toString() {
        return name + " (" + latinName + ")";
    }
}
