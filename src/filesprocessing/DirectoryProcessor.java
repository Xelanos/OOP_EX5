
package filesprocessing;

import filesprocessing.manipulators.AbsOrder;
import filesprocessing.manipulators.DirectoryFilter;
import filesprocessing.manipulators.Manipulator;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by OrMiz on 24/05/2017.
 */

public class DirectoryProcessor {
    public static void main(String[] args) {
        String directoryPath = args[0];
        String filterPath = args[1];
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
                Manipulator defaultOrder = new AbsOrder(false);
                Manipulator filter = manipulators[0];
                Manipulator order = manipulators[1];

                if (filter != null) result = filter.doManipulation(result);
                if (result == null) continue;
                result = defaultOrder.doManipulation(result);
                if (order != null) result = order.doManipulation(result);
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
