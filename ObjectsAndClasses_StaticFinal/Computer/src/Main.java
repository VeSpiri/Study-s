public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer(
                new Processor(60, 8, "Intel", 0.1),
                new RAM("Static", 8, 0.125),
                new Storage(StorageType.SSD, 1024, 0.5),
                new Screen(27.2, ScreenType.IPS, 5.3),
                new Keyboard(KeyboardVariations.MECHANICAL, true, 1),
                "Hyper",
                "Game"
        );

        Computer computer1 = new Computer(
                new Processor(90, 16, "Intel", 0.12),
                new RAM("Static", 16, 0.25),
                new Storage(StorageType.SSD, 2048, 1),
                new Screen(29, ScreenType.IPS, 8),
                new Keyboard(KeyboardVariations.MECHANICAL, true, 1.5),
                "Hyper",
                "Game"
        );

        System.out.println(computer);
        System.out.println(computer1);
    }


}
