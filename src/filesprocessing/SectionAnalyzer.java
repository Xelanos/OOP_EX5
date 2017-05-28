
package filesprocessing;
import filesprocessing.manipulators.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by OrMiz on 24/05/2017.
 */
class SectionAnalyzer {

    static ArrayList<Manipulator> getManipulators(LinkedList<String> section){
        ArrayList<Manipulator> sectionManipulators = new ArrayList<>();
        Manipulator manipulator;
        int i = 0;
        if (section.get(3) == null){
            section.set(3, "abs");
        }
        while (section.size() != 0) {
            section.removeFirst();
            if (section.size() != 0) {
                String[] commands = section.getFirst().split("#");
                manipulator = getCommandManipulator(commands);
                sectionManipulators.add(manipulator);
                section.removeFirst();
                i++;
            }
        }
        return sectionManipulators;
    }

    private static Manipulator getCommandManipulator(String[] commandSeq){
        String manipulatorType = commandSeq[0];
        Manipulator manipulator = null;
        try {
            switch (manipulatorType) {
                case "greater_than":
                    manipulator = ManipulatorGenerator.greaterThenFilter(commandSeq);
                    break;
                case "between":
                    manipulator = ManipulatorGenerator.betweenFilter(commandSeq);
                    break;
                case "smaller_than":
                    manipulator = ManipulatorGenerator.smallerThanFilter(commandSeq);
                    break;
                case "file":
                    manipulator = ManipulatorGenerator.nameEqualFilter(commandSeq);
                    break;
                case "contains":
                    manipulator = ManipulatorGenerator.nameContainsFilter(commandSeq);
                    break;
                case "prefix":
                    manipulator = ManipulatorGenerator.prefixFilter(commandSeq);
                    break;
                case "suffix":
                    manipulator = ManipulatorGenerator.suffixFilter(commandSeq);
                    break;
                case "writable":
                    manipulator = ManipulatorGenerator.writableFilter(commandSeq);
                    break;
                case "executable":
                    manipulator = ManipulatorGenerator.executableFilter(commandSeq);
                    break;
                case "hidden":
                    manipulator = ManipulatorGenerator.hiddenFileFilter(commandSeq);
                    break;
                case "all":
                    manipulator = ManipulatorGenerator.allFilter(commandSeq);
                    break;
                case "abs":
                    manipulator = ManipulatorGenerator.absOrder(commandSeq);
                    break;
                case "type":
                    manipulator = ManipulatorGenerator.typeOrder(commandSeq);
                    break;
                case "size":
                    manipulator = ManipulatorGenerator.sizeOrder(commandSeq);
                    break;
                    default:
                        throw new NoSuchFieldException("BAD FORMAT1");
            }
        }
        catch (NoSuchFieldException e){
            System.out.println(e.getMessage());
        }
        return manipulator;
    }




}

