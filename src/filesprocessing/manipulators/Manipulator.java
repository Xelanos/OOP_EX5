package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class Manipulator {

    boolean isReversed;

    public Manipulator(boolean isReversed) {
        this.isReversed = isReversed;
    }

    public abstract File[] doManipulation(File[] fileArray);

    /**
     * @return if the manipulator is reversed or not
     */
    public boolean isReversed(){
        return isReversed;
    }

}
