package filesprocessing.manipulators;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class Order extends Manipulator {

    public Order(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public File[] doManipulation(File[] fileArray) {
        if (isReversed){
            Arrays.sort(fileArray, Collections.reverseOrder(comparator()));
        } else Arrays.sort(fileArray, comparator());
        return fileArray;
    }

    abstract Comparator<File> comparator();


}
