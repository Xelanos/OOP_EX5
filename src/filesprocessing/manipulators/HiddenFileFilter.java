package filesprocessing.manipulators;

import java.io.File;

/**
 *A class for hidden files filter.
 */
public class HiddenFileFilter extends PropertiesFilter {
    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     */
    public HiddenFileFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    boolean checkProperty(File file) {
        return file.isHidden();
    }


}
