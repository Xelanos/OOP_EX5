
package filesprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by OrMiz on 24/05/2017.
 */

public class DirectoryProcessor {
    public static void main(String[] args) {
    }

    private ArrayList<LinkedList<String>> getSections(String pathToFilterFile){
        try(BufferedReader lineReader = new BufferedReader(new FileReader(pathToFilterFile))){ // try yo open the file
            String line = lineReader.readLine();
            ArrayList<LinkedList<String>> sections = new ArrayList<>();
            LinkedList<String> section = new LinkedList<>();
            while (line != null){
                section.add(line);
                line = lineReader.readLine();
                if (line != null) {
                    // separate to sections
                    if (line.equals("FILTER")) {
                        sections.add(section);
                        section = new LinkedList<>();
                    }
                }
            }
            sections.add(section); // add last section
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
}
