package exception;

/**
 * Created by Dmitry Gnatyuk on 10.02.2019.
 */
public class Constant extends ParsingException {
    public Constant(String in, int pos) {
        super(in, pos);
    }
}
