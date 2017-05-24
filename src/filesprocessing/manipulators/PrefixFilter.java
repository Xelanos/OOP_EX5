package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class PrefixFilter extends FileNameFilter {
    public PrefixFilter(boolean isReversed, String compareString) {
        super(isReversed, compareString);
    }

    @Override
    public File[] doManipulation(File[] fileArray) {
        return new File[0];
    }
}
