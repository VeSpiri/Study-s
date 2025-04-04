import forClasses.Lines;
import forClasses.MetroMap;
import forClasses.Station;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


@Getter
public class ParseHTML
{
    Document codeHTML;
    List<Lines> lines = new ArrayList<>();
    List<Station> stations = new ArrayList<>();
    MetroMap metroMap;
    public void findHtmlCode(String url)
            throws IOException
    {
        codeHTML = Jsoup.connect(url).get();
        findMetroStations();
        findMetroLine();
        createMetroMap();
    }
    private void findMetroLine()
    {
        Elements foundLines = codeHTML.select("span.js-metro-line");
        foundLines.forEach(foundLine ->
        {
            String name = foundLine.select("span.js-metro-line").text();
            String number = foundLine.attr("data-line");
            Lines line = new Lines(name, number);
            lines.add(line);
        });
    }
    private void findMetroStations()
    {
        Elements foundStations = codeHTML.select("p.single-station");
        foundStations.forEach(foundStation ->
        {
            String name = foundStation.select("span.name").text();
            String lineNumber = foundStation.parents().attr("data-line");
            boolean hasConnection = foundStation.childrenSize() == 3;
            Station station = new Station(name, lineNumber, hasConnection);
            stations.add(station);
        });
    }
    private void createMetroMap()
    {
        TreeMap<String, List<String>> stOnLine = new TreeMap<>();
        for (Lines line : lines)
        {
            List<String> st = new ArrayList<>();
            for (Station station : stations)
            {
                if (station.getStationLine().equals(line.getLineNumber()))
                {
                    st.add(station.getStationName());
                }
            }
            stOnLine.put(line.getLineNumber(), st);
        }
        metroMap = new MetroMap(stOnLine, lines);
    }

}
