package filesprocessing.manipulators;

import java.io.File;
import java.util.Comparator;

/**
 * Created by OrMiz on 24/05/2017.
 */
public class TypeOrder extends Order {

    public TypeOrder(boolean isReversed) {
        super(isReversed);
    }

    @Override
    Comparator<File> comparator() {
        return null;
    }

}
