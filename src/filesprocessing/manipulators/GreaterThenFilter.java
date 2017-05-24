package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class GreaterThenFilter extends SizeFilter {


    public GreaterThenFilter(boolean isReversed, double value) {
        super(isReversed, value);
    }

    @Override
    public File[] doManipulation(File[] fileArray) {
        return new File[0];
    }
}
