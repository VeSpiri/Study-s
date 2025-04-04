import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NumbersForRegion extends Thread{

    char[] letters;
    int regionStart;
    int regionEnd;

    public NumbersForRegion(char[] letters, int numberThread) {
        this.letters = letters;
        regionStart = ((numberThread - 1) * 25) + 1;
        regionEnd = numberThread * (100 / 4);
    }

    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter("res/end_region" + regionEnd + ".txt");
            for (; regionStart <= regionEnd; regionStart++) {
                StringBuilder carNumber = new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                carNumber.append(firstLetter);
                                carNumber.append(padNumber(number, 3));
                                carNumber.append(secondLetter);
                                carNumber.append(thirdLetter);
                                carNumber.append(padNumber(regionStart, 2));
                                carNumber.append("\n");
                            }
                        }
                    }
                }
                writer.write(carNumber.toString());
            }

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder();
        numberStr.append(number);
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, "0");
        }

        return numberStr.toString();
    }
}
