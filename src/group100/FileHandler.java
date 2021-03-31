package group100;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author group100
 * Handles the file reading 
 * Checks file existance
 * Create New files if needed
 * In paramters ArrayList (on save)
 * Return ArrayList (on load)
 * Actual data never stored in this class, just receive an ArrayList
 * and gives it back.
 */

public class FileHandler {
    //Some class variables
    private final File f;
    private final String fileName;
    private boolean exists;

    //sets up the class variables and try to read a file if exists
    public FileHandler(String fileName) throws IOException{
        this.f = new File(fileName);
        this.fileName = fileName;
        this.exists = this.f.isFile();
        if (this.exists == false) { // ... or create the file
            createFile();
        }
    }

    //creates the file of not exists
    private void createFile() throws IOException{
        if (this.exists == false) {
            f.createNewFile();
            System.out.println("Creating New file: " +this.fileName);
            this.exists = true;
        }
    }
    
    //saves the file this.fileName by iterating the given ArrayList
    public void saveFile(ArrayList fileData) throws IOException{
        //deleting the existing contents and create a new file since
        //all data come through the argument
        this.f.delete();
        this.f.createNewFile();
        
        //setting up the writer
        PrintWriter writer = new PrintWriter(new FileWriter(this.fileName));
        
        //iterating the ArrayList and write them to a file
        fileData.forEach((line) -> {
            writer.write(line.toString());
        });
        writer.close();
    }
    
    //loads a file
    public ArrayList loadFile(String type) throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
        //Local List for students
        ArrayList fileLines = new ArrayList();
        
        
        if ("student".equals(type)) {
            //iterating through the line
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String studentData[] = line.split(","); //explode it!
                if (line.length() > 0) {
                 //make new students
                 fileLines.add(new Student(studentData[0], studentData[1], studentData[2], studentData[3]));
                }
            }
         }
        if ("course".equals(type)) {
            //iterating through the line
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String courseData[] = line.split(","); //explode it!
                if (line.length() > 0) {
                 //make new students
                 fileLines.add(new Course(courseData[0], courseData[1]));
                }
            }
         }
        in.close();
        return fileLines;
    }
}