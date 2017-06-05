package filesprocessing.manipulators;

import java.io.File;
import java.util.LinkedList;

/**
 *A class for writable file filter.
 */
public class WritableFilter extends PropertiesFilter {
    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     */
    public WritableFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    boolean checkProperty(File file) {
        return file.canWrite();
    }


}
