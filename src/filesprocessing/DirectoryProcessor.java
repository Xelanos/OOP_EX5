
package filesprocessing;

import filesprocessing.manipulators.DirectoryFilter;
import filesprocessing.manipulators.Manipulator;
import sun.swing.SwingUtilities2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by OrMiz on 24/05/2017.
 */

public class DirectoryProcessor {
    public static void main(String[] args) {
        String filterPath = args[0];
        String directoryPath = args[1];
        ArrayList<Manipulator[]> check = new ArrayList<>();
        File[] filesInDir;
        File[] result;
        try {
            ArrayList<String[]> test = getSections(filterPath);
            for (int i = 0; i < test.size(); i++) {
                SectionAnalyzer.checkSection(test.get(i));
                check.add(SectionAnalyzer.getManipulators(test.get(i), i+1));
            }
            filesInDir = getFilesArray(directoryPath);
            for (Manipulator[] manipulators : check) {
                result = filesInDir;
                for (Manipulator manipulator : manipulators) {
                    if (manipulator != null)
                        result = manipulator.doManipulation(result);
                }
                System.out.println("----------");
                for (File file : result) {
                    System.out.println(file.getName());
                }
            }
        } catch (SecondException secondException) {
            System.out.print(secondException.getMessage());
        }

    }

    private static ArrayList<String[]> getSections(String pathToFilterFile) throws SecondException{
        ArrayList<String[]> sections = new ArrayList<>();
        try(BufferedReader lineReader = new BufferedReader(new FileReader(pathToFilterFile))) { // try yo open the file
            String[] section;
            String line = lineReader.readLine();
            while (line != null){
                section = new String[4];
                for (int i = 0; i < 4; i++){
                    section[i] = line;
                    line = lineReader.readLine();
                }
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
