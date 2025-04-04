public class Dimensions {
    private final double width;
    private final double height;
    private final double length;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public void volumeCalculate() {
        double volume = width * height * length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getVolume() {
        return  width * height * length;
    }
}
