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
