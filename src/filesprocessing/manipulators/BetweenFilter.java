package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class BetweenFilter extends SizeFilter {


    public BetweenFilter(boolean isReversed, double lowerBound, double UpperBound) {
        super(isReversed, lowerBound, lowerBound);
    }

    @Override
    public File[] doManipulation(File[] fileArray) {
        return new File[0];
    }

    @Override
    public boolean accept(File pathname) {
        return false;
    }
}
