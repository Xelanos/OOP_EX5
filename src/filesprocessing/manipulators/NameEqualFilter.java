package filesprocessing.manipulators;

import java.io.File;
import java.util.Objects;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class NameEqualFilter extends FileNameFilter {
    public NameEqualFilter(boolean isReversed, String compareString) {
        super(isReversed, compareString);
    }

    @Override
    protected boolean acceptCondition(String fileName) {
        return Objects.equals(fileName, compareString);
    }


}
