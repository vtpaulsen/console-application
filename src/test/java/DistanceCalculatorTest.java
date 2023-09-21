import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceCalculatorTest {


    private final InputStream originalSystemIn = System.in;

    private DistanceCalculator calculator = new DistanceCalculator();

    @BeforeEach
    public void setUp() {
        // Redirect System.in to provide custom input

        String input = "1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @After
    public void tearDown() {
        // Restore the original System.in
        System.setIn(originalSystemIn);
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

    // Add more tests here
    // - Test that the airports need to exist
    // - Test that the airports are not the same
    // - ...

}
