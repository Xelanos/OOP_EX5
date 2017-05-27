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
                long o1SizeInKb = o1.length() / 1024;
                long o2SizeInKb = o2.length() / 1024;
                long difference = o1SizeInKb - o2SizeInKb;
                if (difference > 0){
                    return 1;
                } else if (difference < 0){
                    return -1;
                } else return 0;
            }
        };
    }

}
