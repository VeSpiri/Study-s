package forClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Station {
    private String stationName;
    private String stationLine;
    private boolean hasConnection;
}
