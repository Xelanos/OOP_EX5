package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class GreaterThanFilter extends SizeFilter {


    public GreaterThanFilter(boolean isReversed, double compareValue) {
        super(isReversed, compareValue);
    }

    @Override
    protected boolean passCondition(double size) {
        return size >= compareToSize;
    }


}
