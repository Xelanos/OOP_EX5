package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class SuffixFilter extends FileNameFilter {
    public SuffixFilter(boolean isReversed, String compareString) {
        super(isReversed, compareString);
    }


    @Override
    public boolean accept(File pathname) {
        return false;
    }
}
