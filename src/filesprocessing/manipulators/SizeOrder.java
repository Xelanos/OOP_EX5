package filesprocessing.manipulators;

import java.io.File;
import java.util.Comparator;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class SizeOrder extends Order {

    public SizeOrder(boolean isReversed) {
        super(isReversed);
    }

    @Override
    Comparator<File> comparator() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return (int) (o1.length() - o2.length());
            }

            @Override
            public Comparator<File> reversed() {
                return new Comparator<File>() {
                    @Override
                    public int compare(File o1, File o2) {
                        return (int) (o2.length() - o1.length());
                    }
                };
            }
        };
    }
}
