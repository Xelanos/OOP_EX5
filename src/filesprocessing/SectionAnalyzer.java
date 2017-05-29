
package filesprocessing;
import filesprocessing.manipulators.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by OrMiz on 24/05/2017.
 */
class SectionAnalyzer {

    static void checkSection(String[] section) throws SecondException{
        if ((!section[0].equals("FILTER"))){
            throw new SecondException("Missing FILTER field");
        }
        else if ((!section[2].equals("ORDER"))){
            throw new SecondException("Missing ORDER field");
        }
    }

    static Manipulator[] getManipulators(String[] section, int sectionNum){
        Manipulator[] sectionManipulators = new Manipulator[2];
        Manipulator manipulator;
        for (int i = 1; i < section.length; i+=2){
            String[] commands = new String[1];
            if (section[i] != null){
                commands = section[i].split("#");
            }
            else{
                if (i == 1){
                    commands[0] = "all";
                }
                else if (i == 3){
                    commands[0] = "abs";
                }
            }
            manipulator = getCommandManipulator(commands, sectionNum*(i+1));
            sectionManipulators[i/2] = manipulator;
        }
        return sectionManipulators;
    }

    private static Manipulator getCommandManipulator(String[] commandSeq,  int lineNum){
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
                        throw new FirstException("BAD FORMAT");
            }
        }
        catch (FirstException firstException){
            System.err.println("Warning in Line: " + lineNum);
        }
        return manipulator;
    }
}

