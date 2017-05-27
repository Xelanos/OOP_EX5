package filesprocessing.manipulators;

import java.io.File;
import java.util.Objects;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class PrefixFilter extends FileNameFilter {
    public PrefixFilter(boolean isReversed, String compareString) {
        super(isReversed, compareString);
    }

    @Override
    protected boolean acceptCondition(String fileName) {
        String filePrefix = getPrefix(fileName);
        return Objects.equals(filePrefix, compareString);
    }

    /**
     * @return files name first letters that are in the size of string to search.
     */
    protected String getPrefix(String fileName) {
        int searchStringSize = compareString.length();
        int fileNameSize = fileName.length();
        int lastValidIndex = searchStringSize > fileNameSize ? fileNameSize : searchStringSize;
        return fileName.substring(0, lastValidIndex);
    }


}
