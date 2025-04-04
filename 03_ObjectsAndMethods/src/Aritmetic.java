public class Aritmetic {
    private int numberOne;
    private int numberTwo;

    public Aritmetic (int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public int getSum() {
        int sum = numberOne + numberTwo;
        return sum;
    }

    public int getMultiplier() {
        int multiplier= numberOne * numberTwo;
        return multiplier;
    }

    public int getMax() {
        if (numberOne > numberTwo) {
            int max = numberOne;
            return max;
        }
        int max = numberTwo;
        return max;
    }

    public int getMin() {
        if (numberOne > numberTwo) {
            int min = numberTwo;
            return min;
        }
        int min = numberOne;
        return min;
    }
}
