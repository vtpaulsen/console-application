import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import java.io.IOException;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTest {
    @Test
    public void test() {
        System.out.println("Hello World");
    }

    @Test
    public void test2() {
        Welcome welcome = new Welcome();
        assertEquals(1, welcome.number());
    }

    @Test
    public void testHelloWorld() {
        Welcome welcome = new Welcome();
        assertEquals("Hello World", welcome.hello());
    }

}
