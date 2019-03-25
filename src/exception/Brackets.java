package exception;

/**
 * Created by Dmitry Gnatyuk on 10.02.2019.
 */
public class Brackets extends ParsingException {
    public Brackets(String in, int pos) {
        super(in, pos);
    }
}

