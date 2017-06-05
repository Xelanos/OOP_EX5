package filesprocessing.manipulators;

import java.io.File;

/**
 * A class for File Name Filters
 */
public abstract class FileNameFilter extends Filter {

    /** string to check in files */
    protected String compareString;

    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     * @param compareString string to compare in the file
     */
    public FileNameFilter(boolean isReversed, String compareString) {
        super(isReversed);
        this.compareString = compareString;
    }

    @Override
    public boolean accept(File pathname) {
        String fileName = pathname.getName();
        boolean shouldAccept = acceptCondition(fileName);
        return isReversed != shouldAccept;
    }

    /**
     * checks if the files name hold the condition of the filter.
     * @param fileName name to check
     * @return true if file should pass the filter, false if not
     */
    protected abstract boolean acceptCondition(String fileName);

}
