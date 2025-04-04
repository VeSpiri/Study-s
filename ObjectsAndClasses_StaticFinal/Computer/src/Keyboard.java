public class Keyboard {
    private final KeyboardVariations type;
    private final boolean highlights;
    private final double weight;

    public Keyboard(KeyboardVariations type, boolean highlights, double weight) {
        this.type = type;
        this.highlights = highlights;
        this.weight = weight;
    }

    public KeyboardVariations getType() {
        return type;
    }

    public boolean isHighlights() {
        return highlights;
    }

    public double getWeight() {
        return weight;
    }
}
