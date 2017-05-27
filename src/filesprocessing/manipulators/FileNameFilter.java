package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class FileNameFilter extends Filter {
    protected String compareString;

    public FileNameFilter(boolean isReversed, String compareString) {
        super(isReversed);
        this.compareString = compareString;
    }

    @Override
    public boolean accept(File pathname) {
        String fileName = pathname.getName();
        boolean shouldAccept = acceptCondition(fileName);
        return isReversed != shouldAccept;
    }

    /**
     * checks if the files name hold the condition of the filter.
     * @param fileName name no check
     * @return true if file should pass the filter, false if not
     */
    protected abstract boolean acceptCondition(String fileName);

}
