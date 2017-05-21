package numbergame;

import java.util.Scanner;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public class NumberGame {

    public static void main(String...args) {
        Printer printer = new ConsolePrinter(System.out);
        Scanner in = new Scanner(System.in);
        Player player = new Player(printer, new Player.ScannerBasedGivesNextLine(in));
        NumberGuesser guesser = new NumberGuesser(printer,player);
        while(true) {
            guesser.play();
        }
    }
}
