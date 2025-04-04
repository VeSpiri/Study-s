import java.io.IOException;


public class Main {
    static String url = "https://skillbox-java.github.io/";
    static String directory ="data";
    public static void main(String[] args)
    {
        ParseHTML html = new ParseHTML();
        FindFiles files = new FindFiles();
        files.findFiles(directory);
        try {
            html.findHtmlCode(url);
            CreateJSON createJson = new CreateJSON(
                    html.getStations(),
                    html.getLines(),
                    files.getDepths(),
                    files.getDates(),
                    html.getMetroMap());
            createJson.createFile();
        } catch (IOException e) {
            System.out.println("Еееееееееех..."
                    + "\n"
                    + "Неверная ссылка.");
        }

    }

}
