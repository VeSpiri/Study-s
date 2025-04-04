import java.text.SimpleDateFormat;
import java.util.Random;

import static java.lang.System.out;

public class Main {
    private static final int USERS = 20;
    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");
    private static LoadDB loadDB = new LoadDB();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            loadDB.connect();
            for (int reg = 1; reg <= USERS; reg++) {
                loadDB.log(reg);
                out.println("Показываем пользователя " + reg);
                int purchase = new Random().nextInt(20) + 1;
                    if ((new Random().nextInt(10) + 1) == 10) {
                        out.println("> Пользователь " + purchase + " оплатил услугу!");
                        out.println("Показываем пользователя " + purchase);
                        Thread.sleep(1000);
                }
            }
            loadDB.shutdown();
        }
    }
}
