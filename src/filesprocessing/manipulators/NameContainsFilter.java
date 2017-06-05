package filesprocessing.manipulators;


/**
 * A class for the Name contains filter.
 */
public class NameContainsFilter extends FileNameFilter {

    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     * @param compareString string to search in the file name.
     */
    public NameContainsFilter(boolean isReversed, String compareString) {
        super(isReversed, compareString);
    }


    @Override
    protected boolean acceptCondition(String fileName) {
        return fileName.contains(compareString);
    }
}
