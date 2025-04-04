package forClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Depth {
        private String station_name;
        private String depth;

        @Override
        public String toString() {
                return "name=" + station_name + ", depth=" + depth;
        }
}
