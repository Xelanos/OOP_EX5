package filesprocessing.manipulators;


/**
 * A class for the Smaller_then filter
 */
public class SmallerThanFilter extends SizeFilter {

    /**
     * constructor for the filter.
     * @param isReversed true if the filter should reversed.
     * @param compareValue value to check if smaller from
     */
    public SmallerThanFilter(boolean isReversed, double compareValue){
        super(isReversed,compareValue);
    }

    @Override
    protected boolean passCondition(double size) {
        return size < compareToSize;
    }

}
