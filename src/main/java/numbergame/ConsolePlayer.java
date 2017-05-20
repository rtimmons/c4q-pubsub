package numbergame;

import java.util.Scanner;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
class ConsolePlayer implements Player {

    private final Printer printer;
    private final Scanner in;

    ConsolePlayer(Printer printer, Scanner in) {
        this.printer = printer;
        this.in = in;
    }

    @Override
    public Response decide(int guess) {
        while (true) {
            printer.p("Guess ", guess, ". Enter C (correct), H (higher), or L (lower)");
            String response = in.nextLine().toLowerCase();
            switch (response) {
                case "c":
                    return Response.CORRECT;
                case "h":
                    return Response.HIGHER;
                case "l":
                    return Response.LOWER;
            }
        }
    }
}
