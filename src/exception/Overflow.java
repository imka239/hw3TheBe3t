package exception;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class Overflow extends ImpossibleOperation{
    public Overflow() {
        super("overflow while trying");
    }
}
