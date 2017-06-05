package filesprocessing.manipulators;

import java.io.File;
import java.util.LinkedList;

/**
 * A class for file properties filters.
 */
public abstract class PropertiesFilter extends Filter {
    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     */
    public PropertiesFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public boolean accept(File pathname) {
        boolean shouldAccept = checkProperty(pathname);
        return isReversed != shouldAccept;
    }

    /**
     * checks if supplied file has the property
     * @param file file to check.
     * @return true if file has the property, false if not
     */
    abstract boolean checkProperty(File file);
}
