
package filesprocessing;

import filesprocessing.manipulators.AbsOrder;
import filesprocessing.manipulators.DirectoryFilter;
import filesprocessing.manipulators.Manipulator;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by OrMiz on 24/05/2017.
 */

public class DirectoryProcessor {

    public static LinkedList<Integer> lines;
    public static void main(String[] args) {
        File[] filesInDir;
        File[] result;
        lines = new LinkedList<>();
        try {
            if (args.length != 2 ) throw new SecondException("Invalid usage - Bad arguments");
            String directoryPath = args[0];
            String filterPath = args[1];
            ArrayList<String[]> test = getSections(filterPath);
            Manipulator[] manipulators;
            filesInDir = getFilesArray(directoryPath);
            Manipulator defaultOrder = new AbsOrder(false);
            for (String[] section : test){
                SectionAnalyzer.checkSection(section);
            }
            for (int i = 0; i < test.size(); i++) {
                manipulators = SectionAnalyzer.getManipulators(test.get(i), i+1);
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

    private static ArrayList<String[]> getSections(String pathToFilterFile) throws SecondException{
        ArrayList<String[]> sections = new ArrayList<>();
        int sectionLineCounter;
        try(BufferedReader lineReader = new BufferedReader(new FileReader(pathToFilterFile))) { // try yo open the file
            String[] section;
            String line = lineReader.readLine();
            while (line != null){
                sectionLineCounter = 0;
                section = new String[4];
                for (int i = 0; i < 4; i++){
                        section[i] = line;
                        sectionLineCounter++;
                        line = lineReader.readLine();
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

    private static File[] getFilesArray(String path){
        File folder = new File(path);
        File[] filesArray =folder.listFiles(new DirectoryFilter(true));
        return filesArray;
    }
}
