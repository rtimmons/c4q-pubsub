package numbergame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
class NumberGuesser {

    private final Logger log = LoggerFactory.getLogger(getClass());

    void play() {
        int guesses = 0;
        int min = 0;
        int max = 100;

        p("Guess a number between ", min, " and ", max);

        int guess;
        RESPONSE response;

        G:
        while (true) {
            guess = max - (max - min) / 2;

            log.debug("Guessing max - (max - min)/2 = {} - ({} - {})/2 = {}",
                max, max, min, guess);

            response = decide(guess);
            log.debug("Answer is {}", response);

            switch (response) {
                case CORRECT:
                    break G;
                case HIGHER:
                    min = guess;
                    continue;
                case LOWER:
                    max = guess;
                    continue;
                default:
                    throw new RuntimeException("Impossible");
            }
        }

        p("Guessed your number ", guess, " in ", guesses, " guesses");
    }

    PrintStream ps = System.out;

    void p(Object... obs) {
        for (Object o : obs) {
            ps.print(String.valueOf(o));
        }
        ps.println();
    }

    Scanner in = new Scanner(System.in);

    enum RESPONSE {
        CORRECT,
        HIGHER,
        LOWER,
    }

    RESPONSE decide(int guess) {
        while (true) {
            p("Guess ", guess, ". Enter C (correct), H (higher), or L (lower)");
            String response = in.nextLine().toLowerCase();
            switch (response) {
                case "c":
                    return RESPONSE.CORRECT;
                case "h":
                    return RESPONSE.HIGHER;
                case "l":
                    return RESPONSE.LOWER;
            }
        }
    }

}
