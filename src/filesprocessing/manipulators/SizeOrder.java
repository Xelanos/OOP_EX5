package filesprocessing.manipulators;

import java.io.File;
import java.util.Comparator;

/**
 *A class for ordering files by size.
 */
public class SizeOrder extends Order {

    /**
     * constructor for the order.
     * @param isReversed true if the order should be reversed
     */
    public SizeOrder(boolean isReversed) {
        super(isReversed);
    }

    /**
     * @return comparator such that compers between two files by their size.
     */
    Comparator<File> comparator() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                long difference = o1.length() - o2.length();
                if (difference > 0){
                    return 1;
                } else if (difference < 0){
                    return -1;
                } else return 0;
            }
        };
    }

}
