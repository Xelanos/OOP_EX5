package filesprocessing.manipulators;

import java.io.File;

/**
 *A class for executable files filter.
 */
public class ExecutableFilter extends PropertiesFilter {
    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     */
    public ExecutableFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    boolean checkProperty(File file) {
        return file.canExecute();
    }


}
