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
                long difference = o1.length() - o2.length();
                if (difference > 0){
                    return 1;
                } else if (difference < 0){
                    return -1;
                } else return 0;
            }
        };
    }

}
