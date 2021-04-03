package group100;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author group100
 * Handles the file reading and writing
 * Checks file existance
 * Create New files if needed
 * Load a course call loadCourseFromFile returns Course
 * Load students call loadStudentsFromFile returns ArrayList<Student>
 * Save a course call saveCourse(Course);
 * Save students call loadStudentsFromFile(ArrayList<Student>)
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
    public void saveStudents(ArrayList fileData) throws IOException{
        //deleting the existing contents and create a new file since
        //all data come through the argument
        this.f.delete();
        this.f.createNewFile();
        
        //setting up the writer
        PrintWriter writer = new PrintWriter(new FileWriter("StudentDetails.txt"));
        
        //iterating the ArrayList and write them to a file
        fileData.forEach((line) -> {
            writer.write(line.toString());
        });
        writer.close();
    }
    
    //loads a file
    public ArrayList<Student> loadStudentsFromFile() throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader("StudentDetails.txt"));
        //Local List for students
        ArrayList<Student> studentList = new ArrayList<>();
        
            //iterating through the line
            for (String line = in.readLine(); line != null; line = in.readLine()) {
     
                if (line.length() > 0) {
                    String studentData[] = line.split(","); //explode it!
                 //make new students
                 studentList.add(new Student(studentData[0], studentData[1], studentData[2], studentData[3]));
                }
            }
        in.close();
        return studentList;
    }
    //loads a course
    public Course loadCourseFromFile() throws FileNotFoundException, IOException{
            Course course; //initialize just for safety
            BufferedReader in = new BufferedReader(new FileReader("CourseDetails.txt"));
            String line = in.readLine();
            try{
                 if(line.length() > 0){
                String[] details = line.split(",");
                course = new Course(details[0],details[1]);
            
            }
            else{
                f.delete();
                createFile();
                System.out.println("No courses exists..");
                course = new Course();
                saveCourse(course);
            }
            }catch(java.lang.NullPointerException e){
                f.delete();
                createFile();
                System.out.println("No courses exists..");
                course = new Course();
                saveCourse(course);
            }
           
   
            
            
            in.close();
        return course;
    }
   
    public void saveCourse(Course courseDetails) throws FileNotFoundException, IOException{
        //saves a course name, lecturer
            PrintWriter writer = new PrintWriter(new FileWriter("CourseDetails.txt"));
            String tmpString = courseDetails.getName() + "," + courseDetails.getLecturer()+"\n";
            writer.write(tmpString);
            writer.close();
    }
}