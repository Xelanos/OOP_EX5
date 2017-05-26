package filesprocessing.manipulators;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class PropertiesFilter extends Filter {
    public PropertiesFilter(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public boolean accept(File pathname) {
        boolean shouldAccept = false;
        if (checkProperty(pathname)){
            shouldAccept = true;
        }
        if (isReversed){
            return !shouldAccept;
        } else return shouldAccept;
    }

    /**
     * checks if supplied file has the property
     * @param file file to check
     * @return true if file has the property, false if not
     */
    abstract boolean checkProperty(File file);
}
