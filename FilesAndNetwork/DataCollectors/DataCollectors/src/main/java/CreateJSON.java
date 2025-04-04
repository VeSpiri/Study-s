import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import forClasses.*;
import lombok.RequiredArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CreateJSON {
    private final List<Station> stations;
    private final List<Lines> lines;
    private final List<Depth> depths;
    private final List<StationDate> dates;
    private final MetroMap metroMap;
    List<Stations> stationsList = new ArrayList<>();
    public void createFile()
    {
        stationsList = createStationsList();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            String linesAndStations = objectMapper.writeValueAsString(metroMap);
            FileWriter fileWriterFirst = new FileWriter("linesAndStations.json");
            fileWriterFirst.write(linesAndStations);
            fileWriterFirst.close();
            String stations = objectMapper.writeValueAsString(stationsList);
            FileWriter fileWriterSecond = new FileWriter("stations.json");
            fileWriterSecond.write(stations);
            fileWriterSecond.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<Stations> createStationsList()
    {
        stations.forEach(s -> {
            lines.forEach(l -> {
                if (l.getLineNumber().equals(s.getStationLine())) {
                    depths.forEach(dpt -> {
                        if (dpt.getStation_name().equals(s.getStationName())) {
                            double depth;
                            if (dpt.getDepth().matches("-[0-9]+.[0-9]+")) {
                                depth = Double.parseDouble(dpt.getDepth().replace(',', '.'));
                            } else {
                                depth = 0;
                            }
                            dates.forEach(dt -> {
                                if (dt.getName().equals(s.getStationName())) {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                                    LocalDate date = LocalDate.parse(dt.getDate(), formatter);
                                    boolean canAddStation = false;
                                    if (stationsList.size() != 0) {
                                        for (Stations st : stationsList) {
                                            if (st.getDate().equals(date) &&
                                                    st.getName().equals(s.getStationName())  &&
                                                    st.getLine().equals(l.getLineName())) {
                                                return;
                                            } else {
                                                canAddStation = true;
                                            }
                                        }
                                    }
                                    if (stationsList.size() == 0 || canAddStation) {
                                        stationsList.add(new Stations(s.getStationName(), l.getLineName(), date, depth, s.isHasConnection()));
                                    }
                                }
                            });
                        }
                    });
                }
            });
        });
        return stationsList;
    }
}
