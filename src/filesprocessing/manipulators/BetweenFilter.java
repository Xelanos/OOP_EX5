package filesprocessing.manipulators;


/**
 * A class for in between filter
 */
public class BetweenFilter extends SizeFilter {

    /**
     * constructor for the filter with two sided comparison.
     * @param isReversed true if the filter should reversed.
     * @param lowerBound lower bound of the comparison
     * @param upperBound upper bound of the comparison
     */
    public BetweenFilter(boolean isReversed, double lowerBound, double upperBound) {
        super(isReversed, lowerBound, upperBound);
    }

    @Override
    protected boolean passCondition(double size) {
        return  size <= upperBound && size >= lowerBound;
    }

}
