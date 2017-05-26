package filesprocessing.manipulators;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;

/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class Filter extends Manipulator implements FileFilter {

    public Filter(boolean isReversed) {
        super(isReversed);
    }

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
