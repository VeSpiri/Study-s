package forClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationDate {
    private String date;
    private String name;

    @Override
    public String toString() {
        return "name=" + name + ", date=" + date;
    }
}
