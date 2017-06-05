package filesprocessing.manipulators;

import java.util.Objects;

/**
 * A class for file name equal filter.
 */
public class NameEqualFilter extends FileNameFilter {

    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     * @param compareName name to to compare the file name to.
     */
    public NameEqualFilter(boolean isReversed, String compareName) {
        super(isReversed, compareName);
    }

    @Override
    protected boolean acceptCondition(String fileName) {
        return Objects.equals(fileName, compareString);
    }


}
