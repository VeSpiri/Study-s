public class Computer {
    private Processor processor;
    private RAM ram;
    private Storage storage;
    private Screen screen;
    private Keyboard keyboard;

    private final String vendor;
    private final String name;

    private double totalWeight = 0;


    public Computer(Processor processor, RAM ram, Storage storage, Screen screen, Keyboard keyboard, String vendor, String name) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.name = name;
    }

    private double calculateTotalWeight() {
        totalWeight = totalWeight +
                processor.getWeight() +
                ram.getWeight() +
                storage.getWeight() +
                screen.getWeight() +
                keyboard.getWeight();
        return totalWeight;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String toString() {
        return name +
                "\n" + vendor +
                "\n" + "Processor:" +
                "\n" + "Vendor: " + processor.getManufacturer() +
                "\n" + "Frequency: " + processor.getFrequency() +
                "\n" + "Number of cores: " + processor.getNumberOfCores() +
                "\n" + "Weight: " + processor.getWeight() +
                "\n" + "RAM:" +
                "\n" + "Type: " + ram.getType() +
                "\n" + "Volume: " + ram.getVolume() +
                "\n" + "Weight: " + ram.getWeight() +
                "\n" + "Screen:" +
                "\n" + "Diagonal: " + screen.getDiagonal() +
                "\n" + "Type: " + screen.getType() +
                "\n" + "Weight: " + screen.getWeight() +
                "\n" + "Keyboard:" +
                "\n" + "Type: " +  keyboard.getType() +
                "\n" + "Highlights: " +  keyboard.isHighlights() +
                "\n" + "Weight: " + keyboard.getWeight() +
                "\n" + "Total weight: " + calculateTotalWeight();
    }
}
