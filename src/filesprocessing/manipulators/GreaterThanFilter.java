package filesprocessing.manipulators;


/**
 * A class for the Greater_then filter
 */
public class GreaterThanFilter extends SizeFilter {

    /**
     * constructor for the filter
     * @param isReversed true if the filter should reversed.
     * @param compareValue value to check if larger from from
     */
    public GreaterThanFilter(boolean isReversed, double compareValue) {
        super(isReversed, compareValue);
    }

    @Override
    protected boolean passCondition(double size) {
        return size > compareToSize;
    }


}
