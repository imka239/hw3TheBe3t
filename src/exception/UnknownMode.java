package exception;

/**
 * Created by Dmitry Gnatyuk on 03.03.2019.
 */
public class UnknownMode extends Exception {
    public UnknownMode(String in) {
        super("\n Invalid mode: " + in);
    }
}
