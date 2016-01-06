package structures;

/**
 * Created by Jinesh Patel on 2016-01-05.
 */
public class ClipBoard {
    private static Object value;

    public static Object getValue() {
        return value;
    }

    public static void setValue(Object transfer) {
        value = transfer;
    }
}
