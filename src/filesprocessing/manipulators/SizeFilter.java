package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
abstract class SizeFilter extends Filter {
    protected double compareToSize;
    protected double lowerBound;
    protected double upperBound;

    public SizeFilter(boolean isReversed, double compareToSize) {
        super(isReversed);
        this.compareToSize = compareToSize;
    }

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
    protected double fileSize(File file){
        return file.length() / 1024;

    }

}
