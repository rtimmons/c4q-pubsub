package numbergame;

import java.util.Scanner;

/**
 * @author rtimmons@
 * @since 5/21/17
 */
public class Player {

    final Printer printer;
    final GivesNextLine in;

    public Player(Printer printer, GivesNextLine in) {
        this.printer = printer;
        this.in = in;
    }

    interface GivesNextLine {
        String nextLine();
    }
    static class ScannerBasedGivesNextLine  implements GivesNextLine {
        final Scanner scanner;
        public ScannerBasedGivesNextLine(Scanner scanner) {
            this.scanner = scanner;
        }
        @Override
        public String nextLine() {
            return scanner.nextLine();
        }
    }

    NumberGuesser.RESPONSE decide(int guess) {
        while (true) {
            printer.p("Guess ", guess, ". Enter C (correct), H (higher), or L (lower)");
            String response = in.nextLine().toLowerCase();
            switch (response) {
                case "c":
                    return NumberGuesser.RESPONSE.CORRECT;
                case "h":
                    return NumberGuesser.RESPONSE.HIGHER;
                case "l":
                    return NumberGuesser.RESPONSE.LOWER;
            }
        }
    }

}
