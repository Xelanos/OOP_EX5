package filesprocessing.manipulators;

import java.io.File;

/**
 * A class for file size filters
 */
abstract class SizeFilter extends Filter {
    /** compare value in case of one sided */
    protected double compareToSize;

    /** lower bound in case of two sided */
    protected double lowerBound;
    /** upper bound in case of two sided */
    protected double upperBound;

    /**
     * constructor for the filter with one side comparison.
     * @param isReversed true if the filter should reversed.
     * @param compareToSize size to compare too.
     */
    public SizeFilter(boolean isReversed, double compareToSize) {
        super(isReversed);
        this.compareToSize = compareToSize;
    }

    /**
     * constructor for the filter with two sided comparison.
     * @param isReversed true if the filter should reversed.
     * @param lowerBound lower bound of the comparison
     * @param upperBound upper bound of the comparison
     */
    public SizeFilter(boolean isReversed, double lowerBound, double upperBound){
        super(isReversed);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean accept(File pathname) {
        double size = fileSize(pathname);
        boolean shouldAccept = passCondition(size);
        return isReversed != shouldAccept;
    }

    /**
     * pass condition of the filter.
     * @param size size of the file
     * @return true if the filter should pass the file. false if not.
     */
    protected abstract boolean passCondition(double size);

    /**
     * @param file file to get size too.
     * @return file size in Kb (in double format)
     */
    private double fileSize(File file){
        return file.length() / 1024;

    }

}
