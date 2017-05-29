
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
        ManipulatorGenerator manipulatorFactory = new ManipulatorGenerator();
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
            try {
                manipulator = manipulatorFactory.getCommandManipulator(commands);
            }
            catch (FirstException e){
                System.out.println("Warning in line"+sectionNum*(i+1));
                manipulator = null;
            }
            sectionManipulators[i/2] = manipulator;
        }
        return sectionManipulators;
    }


}

