package forClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.TreeMap;

@Getter
@Setter
@AllArgsConstructor
public class MetroMap {
    private final TreeMap<String, List<String>> stations;
    private final List<Lines> lines;

}
