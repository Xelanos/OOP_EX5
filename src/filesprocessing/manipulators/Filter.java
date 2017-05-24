package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class Filter extends Manipulator {

    public Filter(boolean isReversed) {
        super(isReversed);
    }
}
