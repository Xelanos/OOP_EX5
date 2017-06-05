package filesprocessing.manipulators;

import java.util.Objects;

/**
 * A class for suffix filter.
 */
public class SuffixFilter extends FileNameFilter {

    /**
     * constructor for the filter.
     * @param isReversed true if the filter should be reversed
     * @param compareSuffix suffix to to compare in the file
     */
    public SuffixFilter(boolean isReversed, String compareSuffix) {
        super(isReversed, compareSuffix);
    }

    @Override
    protected boolean acceptCondition(String fileName) {
        String fileSuffix = getSuffix(fileName);
        return Objects.equals(fileSuffix, compareString);
    }


    /**
     * @param fileName the file to check suffix in.
     * @return last letters of the file name, by number of letters in string to compare.
     * if compare string is larger then files name, returns null.
     */
    private String getSuffix(String fileName) {
        int searchStringSize = compareString.length();
        int fileNameSize = fileName.length();
        int subStringStartIndex = fileNameSize - searchStringSize;
        if (subStringStartIndex < 0) {
            return null;
        } else {
            return fileName.substring(subStringStartIndex);
        }
    }
}
