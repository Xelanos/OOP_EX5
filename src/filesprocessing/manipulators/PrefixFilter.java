package filesprocessing.manipulators;

import java.util.Objects;

/**
 * A class for the prefix filter.
 */
public class PrefixFilter extends FileNameFilter {

    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     * @param comparePrefix prefix to to compare in the file
     */
    public PrefixFilter(boolean isReversed, String comparePrefix) {
        super(isReversed, comparePrefix);
    }

    @Override
    protected boolean acceptCondition(String fileName) {
        String filePrefix = getPrefix(fileName);
        return Objects.equals(filePrefix, compareString);
    }

    /**
     * @param fileName file to get prefix from.
     * @return files name first letters that are in the size of string to search.
     */
    private String getPrefix(String fileName) {
        int searchStringSize = compareString.length();
        int fileNameSize = fileName.length();
        int lastValidIndex = searchStringSize > fileNameSize ? fileNameSize : searchStringSize;
        return fileName.substring(0, lastValidIndex);
    }


}
