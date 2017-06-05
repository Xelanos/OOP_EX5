package filesprocessing.manipulators;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;

/**
 * An abstract class for filters type manipulators. compatible with Javas File "filter" method.
 */
public abstract class Filter extends Manipulator implements FileFilter {

    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     */
    public Filter(boolean isReversed) {
        super(isReversed);
    }

    /**
     * remove elements from file array based on accept condition of the filter
     * @param fileArray array to manipulate.
     * @return an array without the elements who didn't pass.
     */
    public File[] doManipulation(File[] fileArray) {
        LinkedList<File> filteredList = new LinkedList<File>();
        for (File file : fileArray){
            if (accept(file)){
                filteredList.add(file);
            }
        }
        return filteredList.toArray(new File[filteredList.size()]);
    }

}
