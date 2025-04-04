import java.io.File;

public class Main {

    public static void main(String[] args) {
        int coreCount = 4;
        int newWidth = 300;
        String srcFolder = "/users/Admin/Desktop/src";
        String dstFolder = "/users/Admin/Desktop/dst";
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int countForOneCore = files.length / coreCount;
        File[] files1 = new File[countForOneCore];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(newWidth, files1, dstFolder);
        resizer1.start();

        File[] files2 = new File[files.length - 3 * countForOneCore];
        System.arraycopy(files, countForOneCore, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(newWidth, files2, dstFolder);
        resizer2.start();

        File[] files3 = new File[files.length - 2 * countForOneCore];
        System.arraycopy(files, countForOneCore * 2, files3, 0, files3.length);
        ImageResizer resizer3 = new ImageResizer(newWidth, files3, dstFolder);
        resizer3.start();

        File[] files4 = new File[files.length - countForOneCore];
        System.arraycopy(files, countForOneCore, files4, 0, files4.length);
        ImageResizer resizer4 = new ImageResizer(newWidth, files4, dstFolder);
        resizer4.start();
    }
}
