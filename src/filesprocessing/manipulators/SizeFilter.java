package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
abstract class SizeFilter extends Filter {
    private double compareToSize;
    private double lowerBound;
    private double upperDouble;

    public SizeFilter(boolean isReversed, double compareToSize) {
        super(isReversed);
        this.compareToSize = compareToSize;
    }

    public SizeFilter(boolean isReversed, double lowerBound, double upperDouble){
        super(isReversed);
        this.lowerBound = lowerBound;
        this.upperDouble = upperDouble;
    }

}
