import airplanes.Airplane;
import airplanes.PrivateAirplane;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulatorTest {

    DistanceCalculator calculator;
    Simulator simulator;

    @BeforeEach
    public void setUp() {
        calculator = new DistanceCalculator();
        simulator = new Simulator();
    }
    @Test
    public void testDistanceBetweenAarhusAndHanoi() {
        Airport aarhus = new Airport("Aarhus", 56.2999988, 10.617997528);
        Airport hanoi = new Airport("Hanoi", 21.221200943, 105.807998657);
        double distance = calculator.distance(aarhus, hanoi, "K");
        assertEquals(8368.0, distance, 10);
    }

    @Test
    public void testDistanceBetweenAalborgAndNewYork() {
        Airport aalborg =  new Airport("Aalborg", 55.73749705, 9.150999396);
        Airport newYork = new Airport("New York", 40.641766, -73.780968);
        double distance = calculator.distance(aalborg, newYork, "K");
        assertEquals(5976.0, distance, 10);
    }

    @Test
    public void testAirport() {
        Airport aarhus = new Airport("Aarhus", 56.2999988, 10.617997528);
        assertEquals("Aarhus", aarhus.getName());
        assertEquals(56.2999988, aarhus.getLatitude(), 0.1);
        assertEquals(10.617997528, aarhus.getLongitude(), 0.1);
    }

    @Test
    public void testPrivateAirplane() {
        Airplane airplane = new PrivateAirplane();
        assertEquals(airplane.getAirplaneType(), Airplane.AirplaneType.PRIVATE);
        assertEquals(airplane.getEmptyWeight(), 10_000);
        assertEquals(airplane.getMaxTakeoffWeight(), 20_000);
        assertEquals(airplane.getPilotList().size(), 1);
        // TODO: Add more assertions
    }

}
