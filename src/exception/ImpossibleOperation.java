package exception;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */

public abstract class ImpossibleOperation extends Exception{
    ImpossibleOperation(String s) {
        super("\n" + "Impossible operation: " + s);
    }
}
