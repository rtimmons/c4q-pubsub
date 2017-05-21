package numbergame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Mock Printer printer;

    @Mock
    Player.GivesNextLine scanner;

    // object under test
    @InjectMocks Player player;

    @Test
    public void testFoo() {

    }

}
