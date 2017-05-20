import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public class HelloWorldTest {

    @Test
    public void testWeHaveJava8AndCanRunTests() {
        assertEquals(
            "We have java 8 and can do trivial math. " +
                "Compiler error? Check JDK version in module settings.",
            6d,
            Stream.of(1, 2, 3)
                .map(Integer::doubleValue)
                .reduce(0d, (a, b) -> a + b),
            0.001d
        );
    }
}
