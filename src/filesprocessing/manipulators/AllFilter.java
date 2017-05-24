package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class AllFilter extends Filter {
    public AllFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public File[] doManipulation(File[] fileArray) {
        if (isReversed) return null;
        else return fileArray;
    }
}
