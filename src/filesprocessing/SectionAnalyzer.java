
package filesprocessing;
import filesprocessing.manipulators.*;


/**
 * A class that Analyzing Sections
 */
class SectionAnalyzer {

    private static final int FILTER_FIELD = 0;
    private static final int ORDER_FIELD = 2;
    private static final String VALUES_SEPARATE_SYMBOL = "#";
    private static final int FILTER_COMMAND = 1;
    private static final int ORDER_COMMAND = 3;
    private static final int COMMAND_ARGUMET = 0;

    /**
     * Checking if a given section has the correct sub-section format
     * @param section the section to check
     * @throws SecondException - In case the template is not good.
     */
    static void checkSection(String[] section) throws SecondException{
        if ((section[FILTER_FIELD] == null) || (section[ORDER_FIELD] == null)){
            throw new SecondException("Missing field");
        }
        else if ((!section[FILTER_FIELD].equals("FILTER"))){
            throw new SecondException("Missing FILTER field");
        }
        else if ((!section[ORDER_FIELD].equals("ORDER"))){
            throw new SecondException("Missing ORDER field");
        }
    }

    /**
     * Makes an array with the requested manipulators in the section
     * @param section the section to analyze
     * @param sectionNum the number of the section out of the full text file
     * @return an array of Manipulator according to the given section
     */
    static Manipulator[] getManipulators(String[] section, int sectionNum){
        ManipulatorGenerator manipulatorFactory = new ManipulatorGenerator();
        Manipulator[] sectionManipulators = new Manipulator[2]; // only 2 manipulators every section
        Manipulator manipulator;
        for (int i = 1; i < section.length; i+=2){
            String[] commands = new String[1]; // the default is a command without arguments
            // if has a command
            if (section[i] != null){
                commands = section[i].split(VALUES_SEPARATE_SYMBOL);
            }
            // complete by default
            else{
                if (i == FILTER_COMMAND){
                    commands[COMMAND_ARGUMET] = "all";
                }
                else if (i == ORDER_COMMAND){
                    commands[COMMAND_ARGUMET] = "abs";
                }
            }
            try {
                manipulator = manipulatorFactory.getCommandManipulator(commands);
            }
            catch (FirstException e){
                // if has a warning, calculate the line number.
                int lineNumber = 0;
                if (sectionNum > 1){
                    for (int index = 0; index < sectionNum - 1; index++){
                        lineNumber +=  DirectoryProcessor.lines.get(index);
                    }
                    lineNumber += (i+1);
                }
                else
                {
                    lineNumber = i + 1;
                }
                System.err.println("Warning in line " + lineNumber);
                manipulator = null;
            }
            sectionManipulators[i/2] = manipulator;
        }
        return sectionManipulators;
    }


}

