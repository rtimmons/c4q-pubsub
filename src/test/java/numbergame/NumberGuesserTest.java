package numbergame;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
@RunWith(MockitoJUnitRunner.class)
public class NumberGuesserTest {

    @Test
    public void testGuesses30() {
        givenCorrectAnswer(30);
        whenPlayed();
        thenGuesses(50, 25, 38, 32, 29, 31, 30);
    }

    @Test
    public void testGuessesFirstTry() {
        givenCorrectAnswer(50);
        whenPlayed();
        thenGuesses(50);
    }

    @Test
    public void testGuessMin() {
        givenCorrectAnswer(0);
        whenPlayed();
        thenGuesses(50, 25, 13, 7, 4, 2, 1, 0);
    }

    @Test
    public void testGuessMax() {
        givenCorrectAnswer(100);
        whenPlayed();
        thenGuesses(50, 75, 88, 94, 97, 99, 100);
    }

    // Boring details

    @SuppressWarnings("unused") // need mockito to create mock instance
    @Mock private Printer printer;

    @Mock private Player player;

    // object under-test
    @InjectMocks private NumberGuesser guesser;

    private void whenPlayed() {
        guesser.play();
    }

    private void thenGuesses(int...guesses) {
        for(int g : guesses) {
            verify(player).decide(g);
        }
    }

    private void givenCorrectAnswer(int answer) {
        when(player.decide(anyInt())).then(r -> {
            int guess = r.getArgument(0);
            return answer == guess ? Response.CORRECT :
                   answer > guess  ? Response.HIGHER :
                                     Response.LOWER;
        });
    }

    @After
    public void noMoreInteractions() {
        verifyNoMoreInteractions(player);
    }
}
