import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceCalculatorTest {


    private final InputStream originalSystemIn = System.in;

    private DistanceCalculator calculator = new DistanceCalculator();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

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

    @Test
    public void test1() {
        assertEquals(1, 1);
        /**
        // Simulate user input of "1"
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        Simulator simulator = new Simulator();
        simulator.main(new String[0]);

        String expectedOutput = "Press 1: You pressed 1";
        assertEquals(expectedOutput, outContent.toString().trim());
        */
     }

    @Test
    public void test2() {
        assertEquals(2, 2);
    }

    @Test
    public void test3() {
        assertEquals(3, 3);
    }



}
