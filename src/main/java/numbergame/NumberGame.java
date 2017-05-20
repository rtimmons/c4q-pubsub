package numbergame;

import java.util.Scanner;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public class NumberGame {

    public static void main(String... args) {

        final Scanner input = new Scanner(System.in);
        final Printer printer = new ConsolePrinter(System.out);
        final Player player = new ConsolePlayer(printer, input);
        final NumberGuesser guesser = new NumberGuesser(printer, player);

        while(true) {
            guesser.play();
        }
    }
}
