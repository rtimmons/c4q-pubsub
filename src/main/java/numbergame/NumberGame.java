package numbergame;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public class NumberGame {

    public static void main(String...args) {
        Printer printer = new ConsolePrinter(System.out);
        NumberGuesser guesser = new NumberGuesser(printer);
        while(true) {
            guesser.play();
        }
    }
}
