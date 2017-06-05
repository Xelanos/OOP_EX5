package filesprocessing.manipulators;

import java.io.File;
import java.util.Comparator;

/**
 * A class for ordering by type of file.
 */
public class TypeOrder extends Order {

    /**
     * constructor for the order.
     * @param isReversed true if the order should be reversed
     */
    public TypeOrder(boolean isReversed) {
        super(isReversed);
    }

    /**
     * @return comparator such that compers between two files by their type.
     */
    Comparator<File> comparator() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return getType(o1).compareTo(getType(o2));
            }

            /**
             * @param file file to get type to.
             * @return the type of the file in string.
             */
            private String getType(File file){
                String fileName = file.getName();
                String type = "";
                int i = fileName.lastIndexOf('.');
                if (i > 0) {
                    type = fileName.substring(i+1);
                }
                return type;
            }
        };
    }

}
