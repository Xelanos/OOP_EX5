
package filesprocessing;

import filesprocessing.manipulators.AbsOrder;
import filesprocessing.manipulators.DirectoryFilter;
import filesprocessing.manipulators.Manipulator;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Processes a Directory with a given FLT file.
 */

public class DirectoryProcessor {


    private static final int DIRECTORY_PATH = 0;
    private static final int FILTER_PATH = 1;
    private static final int NUMBER_OF_ARGUMENTS = 2;
    private static final int SECTION_TOTAL_LENGTH = 4;

    static LinkedList<Integer> lines;   // will store the number of lines in each section
    public static void main(String[] args) {
        File[] filesInDir;
        File[] result;
        lines = new LinkedList<>();
        try {
            // check arguments
            if (args.length != NUMBER_OF_ARGUMENTS ) throw new SecondException("Invalid usage - Bad arguments");
            String directoryPath = args[DIRECTORY_PATH];
            String filterPath = args[FILTER_PATH];
            Manipulator[] manipulators; // will store all the manipulators in the file.
            ArrayList<String[]> sections = getSections(filterPath);
            filesInDir = getFilesArray(directoryPath);
            Manipulator defaultOrder = new AbsOrder(false);
            for (String[] section : sections){
                SectionAnalyzer.checkSection(section);
            }
            for (int i = 0; i < sections.size(); i++) {
                manipulators = SectionAnalyzer.getManipulators(sections.get(i), i+1);
                result = filesInDir;
                Manipulator filter = manipulators[0];
                Manipulator order = manipulators[1];
                if (filter != null) result = filter.doManipulation(result);
                if (result == null) continue;
                if (order != null){
                    defaultOrder = new AbsOrder(order.isReversed());
                    result = defaultOrder.doManipulation(result);
                    result = order.doManipulation(result);
                } else result = defaultOrder.doManipulation(result);
                for (File file : result) {
                    System.out.println(file.getName());
                }
            }
        } catch (SecondException secondException) {
            System.err.println(secondException.getMessage());
        }

    }

    /**
     * Separating a FLT file into sections stored in array list.
     * @param pathToFilterFile the address of the FLT file.
     * @return an ArrayList of String array, each array represents a section in the file.
     * @throws SecondException in case of ERRORS.
     */
    private static ArrayList<String[]> getSections(String pathToFilterFile) throws SecondException{
        ArrayList<String[]> sections = new ArrayList<>();
        int sectionLineCounter;
        try(BufferedReader lineReader = new BufferedReader(new FileReader(pathToFilterFile))) { // try yo open the file
            String[] section;
            String line = lineReader.readLine();
            while (line != null){
                sectionLineCounter = 0; // counting the total section lines (can be some with less than four.
                section = new String[SECTION_TOTAL_LENGTH];
                for (int i = 0; i < SECTION_TOTAL_LENGTH; i++){
                        section[i] = line; // add line to the section
                        sectionLineCounter++;
                        line = lineReader.readLine();
                    // in case a section ends with less than four lines.
                    if (line != null) {
                        if ((i != 0) && (line.equals("FILTER"))) {
                            break;
                        }
                    }
                }
                lines.add(sectionLineCounter);
                sections.add(section);
            }
        }
        catch (IOException badFile){
            throw new SecondException("Bad File Path");
        }
        return sections;
    }

    /**
     *
     * @param path a directory path
     * @return an array of all the files in the folder
     */
    private static File[] getFilesArray(String path){
        File folder = new File(path);
        File[] filesArray =folder.listFiles(new DirectoryFilter(true));
        return filesArray;
    }
}
