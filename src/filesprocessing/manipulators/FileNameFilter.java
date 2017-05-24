package filesprocessing.manipulators;

/**
 * Created by OrMiz on 24/05/2017.
 */
public abstract class FileNameFilter extends Filter {
    private final String compareString;

    public FileNameFilter(boolean isReversed, String compareString) {
        super(isReversed);
        this.compareString = compareString;
    }
}
