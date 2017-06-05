package filesprocessing.manipulators;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/**
 * An abstract class for order type manipulator.
 */
public abstract class Order extends Manipulator {

    /**
     * constructor for the order.
     * @param isReversed true if the order should be reversed
     */
    public Order(boolean isReversed) {
        super(isReversed);
    }

    /**
     * takes a file array, and order it based on the natural order imposed by the comparator provided.
     * @param fileArray array to manipulate.
     * @return the array after required order.
     */
    public File[] doManipulation(File[] fileArray) {
        if (isReversed){
            Arrays.sort(fileArray, Collections.reverseOrder(comparator()));
        } else Arrays.sort(fileArray, comparator());
        return fileArray;
    }

    /**
     * @return comparator to imposed a natural order based on it.
     */
    abstract Comparator<File> comparator();


}
