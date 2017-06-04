package filesprocessing.manipulators;


/**
 * Created by OrMiz on 27/05/2017.
 */
public class SmallerThanFilter extends SizeFilter {
    public SmallerThanFilter(boolean isReversed, double compareValue){
        super(isReversed,compareValue);
    }

    @Override
    protected boolean passCondition(double size) {
        return size < compareToSize;
    }

}
