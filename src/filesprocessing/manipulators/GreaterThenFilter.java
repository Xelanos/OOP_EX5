package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class GreaterThenFilter extends SizeFilter {


    public GreaterThenFilter(boolean isReversed, double compareValue) {
        super(isReversed, compareValue);
    }

    @Override
    protected boolean passCondition(double size) {
        return size >= compareToSize;
    }


}
