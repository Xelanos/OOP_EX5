package filesprocessing.manipulators;

import java.io.File;

/**
 * A class to pass all files.
 */
public class AllFilter extends Filter {
    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     */
    public AllFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public File[] doManipulation(File[] fileArray) {
        if (isReversed) return null;
        else return fileArray;
    }

    @Override
    public boolean accept(File pathname) {
        return !isReversed;
    }
}
