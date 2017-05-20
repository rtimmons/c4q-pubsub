package numbergame;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public class NumberGame {

    public static void main(String...args) {
        NumberGuesser guesser =  new NumberGuesser();
        while(true) {
            guesser.play();
        }
    }
}
