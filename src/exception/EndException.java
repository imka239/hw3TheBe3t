package exception;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class EndException extends ParsingException{
    public EndException(String in, int pos) {
        super(in, pos);
    }
}
