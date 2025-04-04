import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Loader {

//    before 20000 ms
//    after 8500 ms

    public static volatile Long timeThread;

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        List<Thread> threads = new ArrayList<>();

        for (int count = 1; count <= 4; count++) {
            threads.add(new NumbersForRegion(letters, count));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

//    private static String padNumber(int number, int numberLength) {
//        String numberStr = Integer.toString(number);
//        int padSize = numberLength - numberStr.length();
//
//        for (int i = 0; i < padSize; i++) {
//            numberStr = '0' + numberStr;
//        }
//
//        return numberStr;
//    }
}
