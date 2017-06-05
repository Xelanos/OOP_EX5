package filesprocessing.manipulators;
import java.io.File;
import java.util.Comparator;

/**
 * A class for ordering files by absolute file name.
 */
public class AbsOrder extends Order {

    /**
     * constructor for the order.
     * @param isReversed true if the order should be reversed
     */
    public AbsOrder(boolean isReversed) {
        super(isReversed);
    }


    /**
     * @return comparator such that compers between two files by their absolute name.
     */
    Comparator<File> comparator() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
            }
        };
    }
}
