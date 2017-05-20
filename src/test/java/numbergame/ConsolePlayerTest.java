package numbergame;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
@RunWith(MockitoJUnitRunner.class)
public class ConsolePlayerTest {

    @Test
    public void acceptslforlower() {
        givenInput("l");
        thenResponse(Response.LOWER);
        andReadLines(1);
    }

    @Test
    public void acceptshforlower() {
        givenInput("h");
        thenResponse(Response.HIGHER);
        andReadLines(1);
    }

    @Test
    public void acceptscforcorrect() {
        givenInput("c");
        thenResponse(Response.CORRECT);
        andReadLines(1);
    }

    @Test
    public void acceptsCforcorrect() {
        givenInput("C");
        thenResponse(Response.CORRECT);
        andReadLines(1);
    }

    @Test
    public void continuesToReadIfGivenGarbage() {
        when(scanner.nextLine())
            .thenReturn("")
            .thenReturn("null")
            .thenReturn("correct")
            .thenReturn("1")
            .thenReturn("higher")
            .thenReturn("")
            .thenReturn(" ")
            .thenReturn("c");

        thenResponse(Response.CORRECT);
        andReadLines(8);
    }

    ///////////////////////////////////

    @Mock
    ConsolePlayer.ScannerWrapper scanner;
    @Mock
    Printer printer;
    @InjectMocks
    ConsolePlayer player;

    private void thenResponse(Response expected) {
        final Response response = player.decide(5);
        assertEquals(expected, response);
    }

    private void givenInput(String line) {
        when(scanner.nextLine()).thenReturn(line);
    }

    private void andReadLines(int times) {
        verify(scanner, times(times)).nextLine();
    }

    @After
    public void noMore() {
        verifyNoMoreInteractions(scanner);
    }
}
