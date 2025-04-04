public class Storage {
    private final StorageType type;
    private final int volume;
    private final double weight;

    public Storage(StorageType type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public StorageType getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}
