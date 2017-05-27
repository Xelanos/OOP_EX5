package filesprocessing.manipulators;
import java.io.File;
import java.util.Comparator;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class AbsOrder extends Order {

    public AbsOrder(boolean isReversed) {
        super(isReversed);
    }


    @Override
    Comparator<File> comparator() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
            }
        };
    }
}
