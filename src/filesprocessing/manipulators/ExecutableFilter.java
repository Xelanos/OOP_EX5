package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class ExecutableFilter extends PropertiesFilter {
    public ExecutableFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    boolean checkProperty(File file) {
        return file.canExecute();
    }


}
