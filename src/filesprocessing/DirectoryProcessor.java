
package filesprocessing;

import filesprocessing.manipulators.DirectoryFilter;
import filesprocessing.manipulators.Manipulator;
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
        ArrayList<LinkedList<String>> test = getSections(filterPath);
        ArrayList<Manipulator> check = SectionAnalyzer.getManipulators(test.get(0));
        File[] filesInDir = getFilesArray(directoryPath);
        File[] result = filesInDir;
        try {
            for (Manipulator action : check) {
                if (action != null) {
                    result = action.doManipulation(result);
                }
            }

            for (File file : result) {
                System.out.println(file.getName());
            }
        }
        catch (NullPointerException e){
            System.out.println("No Results");
        }

    }

    private static ArrayList<LinkedList<String>> getSections(String pathToFilterFile){
        try(BufferedReader lineReader = new BufferedReader(new FileReader(pathToFilterFile))){ // try yo open the file
            String line = lineReader.readLine();
            ArrayList<LinkedList<String>> sections = new ArrayList<>();
            LinkedList<String> section;
            while (line != null){
                section = new LinkedList<>();
                for (int i=0; i< 4;i++){
                    if (line != null){
                        section.add(i, line);
                        line = lineReader.readLine();
                    }
                    else if (i == 3){
                            section.add(i, "abs");
                        }
                }
                sections.add(section);
            }
            return sections;

        }
        catch (FileNotFoundException badFilePath){ // couldn't open the file
            System.out.println("Bad Address");
        }
        catch (Exception e){ // any other exception
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
        return null;
    }

    private static File[] getFilesArray(String path){
        File folder = new File(path);
        File[] filesArray =folder.listFiles(new DirectoryFilter(false));
        return filesArray;
    }
}
