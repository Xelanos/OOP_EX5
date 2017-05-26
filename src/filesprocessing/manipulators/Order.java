package filesprocessing.manipulators;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;


/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class Order extends Manipulator {

    public Order(boolean isReversed) {
        super(isReversed);
    }

    @Override
    File[] doManipulation(File[] fileArray) {
        if (isReversed){
            Arrays.sort(fileArray, comparator().reversed());
        } else Arrays.sort(fileArray, comparator());
        return fileArray;
    }

    abstract Comparator<File> comparator();
}
