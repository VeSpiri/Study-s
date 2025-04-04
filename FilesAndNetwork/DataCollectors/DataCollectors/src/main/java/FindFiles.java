import forClasses.Depth;
import forClasses.StationDate;
import forFind.CSV;
import forFind.JSON;
import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
@Getter
public class FindFiles {
    List<StationDate> dates = new ArrayList<>();
    List<Depth> depths = new ArrayList<>();
    public void findFiles(String directory) {
        try {
            Stream<Path> paths = Files.walk(Paths.get(directory));
            paths.filter(p -> p.toFile().isFile()).forEach(path ->
            {
                if (path.getFileName().toString().contains(".json"))
                {
                    JSON parsing = new JSON();
                    try {
                        depths.addAll(parsing.parseFile(path));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    CSV parse = new CSV();
                    try {
                        dates.addAll(parse.parseFile(path));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            paths.close();

        } catch (IOException e) {
            System.out.println("Что-то не так с путём, подумай ещё");
        }
    }
}
