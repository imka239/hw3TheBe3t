package exception;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class ForgottenArgument extends ParsingException {
    public ForgottenArgument(String in, int pos) {
        super(in, pos);
    }
}
