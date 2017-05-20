package numbergame;

import java.util.Scanner;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
class ConsolePlayer implements Player {

    private final Printer printer;
    private final ScannerWrapper in;

    interface ScannerWrapper {
        String nextLine();
    }

    static class DefaultScannerWrapper implements ScannerWrapper {
        private final Scanner scanner;
        DefaultScannerWrapper(Scanner scanner) {
            this.scanner = scanner;
        }
        @Override
        public String nextLine() {
            return scanner.nextLine();
        }
    }

    ConsolePlayer(Printer printer, ScannerWrapper in) {
        this.printer = printer;
        this.in = in;
    }

    ConsolePlayer(Printer printer, Scanner in) {
        this.printer = printer;
        this.in = new DefaultScannerWrapper(in);
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
