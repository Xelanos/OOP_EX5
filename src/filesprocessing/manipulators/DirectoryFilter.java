package filesprocessing.manipulators;

import java.io.File;

/**
 *A class for a directory filter.
 */
public class DirectoryFilter extends PropertiesFilter {
    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     */
    public DirectoryFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    boolean checkProperty(File file) {
        return file.isDirectory();
    }
}
