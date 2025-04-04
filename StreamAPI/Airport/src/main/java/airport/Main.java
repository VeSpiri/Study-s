package airport;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        List<Aircraft> allAircraft = airport.getAllAircrafts();

        return allAircraft.stream().
                filter(aircraft -> aircraft.getModel().contains(model))
                .count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        return airport.getTerminals()
                .stream()
                .collect(Collectors.toMap(Terminal::getName,
                        terminal -> terminal.getParkedAircrafts().size())
                );
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        return airport.getTerminals()
                .stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> flight.getDate().isAfter(Instant.now()))
                .filter(flight -> flight.getDate().isBefore(Instant.now().plus(hours, ChronoUnit.HOURS)))
                .collect(Collectors.toList());
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        return airport.getTerminals()
                .stream()
                .filter(t -> t.getName().equals(terminalName))
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(f -> f.getType().equals(Flight.Type.ARRIVAL))
                .min(Comparator.comparing(Flight::getDate));
    }
}