package forFind;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import forClasses.StationDate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSV
{
    public List<StationDate> parseFile(Path path) throws IOException {

        String csv = Files.readString(path);
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema
                .builder()
                .addColumn("name")
                .addColumn("date")
                .setSkipFirstDataRow(true)
                .build();
        List<StationDate> dates;
        try (MappingIterator<StationDate> iterator = mapper
                    .readerFor(StationDate.class)
                    .with(schema)
                    .readValues(csv)) {
                dates = iterator.readAll();
            }
        return dates;
    }
}
