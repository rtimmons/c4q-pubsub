package numbergame;

import java.io.PrintStream;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
class ConsolePrinter implements Printer {
    private final PrintStream ps;

    ConsolePrinter(PrintStream ps) {
        this.ps = ps;
    }

    @Override
    public void p(Object... obs) {

        for (Object o : obs) {
            ps.print(String.valueOf(o));
        }
        ps.println();
    }
}
