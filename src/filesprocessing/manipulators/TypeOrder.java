package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class TypeOrder extends Order {

    public TypeOrder(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public File[] doManipulation(File[] fileArray) {
        return new File[0];
    }
}