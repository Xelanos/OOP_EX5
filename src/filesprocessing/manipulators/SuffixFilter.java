package filesprocessing.manipulators;

import java.io.File;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class SuffixFilter extends FileNameFilter {
    public SuffixFilter(boolean isReversed, String compareString) {
        super(isReversed, compareString);
    }

    @Override
    protected boolean acceptCondition(String fileName) {
        String fileSuffix = getSuffix(fileName);
        return fileSuffix.equals(compareString);
    }


    /**
     * @return last letters of the file name, by number of letters in string to compare.
     * if compare string is larger then files name, returns null
     */
    protected String getSuffix(String fileName) {
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
