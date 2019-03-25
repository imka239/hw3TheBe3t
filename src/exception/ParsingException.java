package exception;

public abstract class ParsingException extends Exception {

    ParsingException(String in, int pos) {
        super(pos + genMessage(in, pos));
    }

    private static String genMessage(String in, int index) {
        StringBuilder out = new StringBuilder("\n" + in.substring(0, Math.min(in.length(), index + 10)));
        out.append('\n');
        for (int i = 0; i < index - 1; i++) {
            out.append('-');
        }
        out.append('^');
        out.append('\n');
        return out.toString();
    }
}
