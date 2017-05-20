package numbergame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
class NumberGuesser {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final ConsolePrinter printer;
    private final ConsolePlayer player;

    NumberGuesser(ConsolePrinter printer, ConsolePlayer player) {
        this.printer = printer;
        this.player = player;
    }

    void play() {
        int guesses = 0;
        int min = 0;
        int max = 100;

        printer.p("Guess a number between ", min, " and ", max);

        int guess;
        Response response = null;

        G:
        while (true) {
            guesses++;

            guess =
                max - min == 1 ? response == Response.HIGHER ? max : min
                : max - (max - min) / 2;

            response = player.decide(guess);
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

}
