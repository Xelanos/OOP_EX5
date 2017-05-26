package filesprocessing.manipulators;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class WritableFilter extends PropertiesFilter {
    public WritableFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    boolean checkProperty(File file) {
        return file.canWrite();
    }


}
