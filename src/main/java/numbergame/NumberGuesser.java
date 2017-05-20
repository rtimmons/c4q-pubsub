package numbergame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
class NumberGuesser {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Printer printer;

    NumberGuesser(Printer printer) {
        this.printer = printer;
    }

    void play() {
        int guesses = 0;
        int min = 0;
        int max = 100;

        printer.p("Guess a number between ", min, " and ", max);

        int guess;
        RESPONSE response = null;

        G:
        while (true) {
            guesses++;

            guess =
                max - min == 1 ? response == RESPONSE.HIGHER ? max : min
                : max - (max - min) / 2;

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

        printer.p("Guessed your number ", guess, " in ", guesses, " guesses");
    }

    Scanner in = new Scanner(System.in);

    enum RESPONSE {
        CORRECT,
        HIGHER,
        LOWER,
    }

    RESPONSE decide(int guess) {
        while (true) {
            printer.p("Guess ", guess, ". Enter C (correct), H (higher), or L (lower)");
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
