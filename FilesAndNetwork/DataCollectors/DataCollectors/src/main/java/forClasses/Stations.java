package forClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Stations {
    private final String name;
    private final String line;
    private final LocalDate date;
    private final Double depth;
    private final boolean hasConnection;
}
