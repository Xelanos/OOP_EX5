package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 27/05/2017.
 */
public class DirectoryFilter extends PropertiesFilter {
    public DirectoryFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    boolean checkProperty(File file) {
        return file.isDirectory();
    }
}
