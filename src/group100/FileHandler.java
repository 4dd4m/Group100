package group100;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author group100
 * Handles the file reading 
 * Checks file existance
 * Create New files if needed
 * In paramters ArrayList<Student> (on save)
 * Return ArrayList<Student> (on load)
 * The students never stored in this class, just receive an ArrayList
 * and gives it back. Students are locating in the Uni.students
 */

public class FileHandler {
    //Some class variables
    private File f;
    private String fileName;
    private boolean exists;

    //sets up the class variables and try to...
    FileHandler(String fileName) throws IOException{
        this.f = new File(fileName);
        this.fileName = fileName;
        this.exists = this.f.isFile();
        
        // ... create the file
        if (this.exists == false) {
            createFile(this.fileName);
        }else{
            loadFile();
        }
    }

    //creates the file of not exists
    private void createFile(String fileName) throws IOException{
        if (this.exists == false) {
            f.createNewFile();
            System.out.println("Creating New file");
            this.exists = true;
        }
    }
    
    //saves the file by iterating the given ArrayList<Student>
    public void saveFile(ArrayList<Student> student) throws IOException{
        //deleting the existing contents
        this.f.delete();
        this.f.createNewFile();
        
        //setting up the writer
        PrintWriter writer = new PrintWriter(new FileWriter(this.fileName));
        
        //iterating the ArrayList<Student> and write them to a file
        for (Student studentLine : student) {
            writer.write(studentLine.toString());       
        }
        writer.close();
    }
    
    //loads a file
    public ArrayList<Student> loadFile() throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
        //Local List for students
        ArrayList<Student> studentFromFile = new ArrayList<Student>();
        
        //iterating through the lines
        for (String line = in.readLine(); line != null; line = in.readLine()) {
             String studentData[] = line.split(","); //explode it!
             //make new students
             studentFromFile.add(new Student(studentData[0], studentData[1], studentData[2]));
        }
        in.close();
        return studentFromFile;
    }
}