package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class Manipulator {

    /** true if the manipulator is reversed, false if not */
    boolean isReversed;

    /**
     * constructor for the manipulator.
     * @param isReversed true if the manipulator should be reversed
     */
    public Manipulator(boolean isReversed) {
        this.isReversed = isReversed;
    }

    /**
     * takes a File array and returns the file array after doing some manipulation on it.
     * @param fileArray array to manipulate.
     * @return a File array after the manipulation done to fileArray.
     */
    public abstract File[] doManipulation(File[] fileArray);

    /**
     * @return if the manipulator is reversed or not.
     */
    public boolean isReversed(){
        return isReversed;
    }

}
