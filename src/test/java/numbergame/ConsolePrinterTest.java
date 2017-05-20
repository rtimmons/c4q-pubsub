package numbergame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
@RunWith(MockitoJUnitRunner.class)
public class ConsolePrinterTest {

    @Mock PrintStream ps;

    // object under test
    @InjectMocks ConsolePrinter printer;

    @Test
    public void printsArrayOfObjects() {
        Object o = new Object() {
            @Override
            public String toString() {
                return "<SomeObject>";
            }
        };

        printer.p(1, 2, "3", null, o);

        verify(ps).print("1");
        verify(ps).print("2");
        verify(ps).print("3");
        verify(ps).print("null");
        verify(ps).print("<SomeObject>");
        verify(ps).println();

        verifyNoMoreInteractions(ps);
    }


}
