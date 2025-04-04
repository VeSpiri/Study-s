import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static String url = "https://sendel.ru/";
    public static void main(String[] args) {
        TreeMaker maker = new TreeMaker(url, "");
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        pool.invoke(maker);
        try {
            FileWriter writer = new FileWriter("/users/Admin/Desktop/ParseUrls.txt");
            writer.append(maker.getBuilder().toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
