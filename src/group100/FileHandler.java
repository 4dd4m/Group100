package group100;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author group100
<<<<<<< HEAD
 * Handles the file reading
 * Checks file existance
 * Create New files if needed
 * In paramters ArrayList<Student> (on save)
 * Return ArrayList<Student> (on load)
 * The students never stored in this class, just receive an ArrayList
 * and gives it back. Students are locating in the Uni.students
=======
 * Handles the file reading and writing
 * Checks file existance, Create New files if needed
 * Load a course call loadCourseFromFile returns Course
 * Load students call loadStudentsFromFile returns ArrayList<Student>
 * Save a course call saveCourse(Course);
 * Save students call loadStudentsFromFile(ArrayList<Student>)
 * //Mr. Adam Torok - B00798824 Mr. Mateusz Tynkiewicz - B00798825
>>>>>>> f16ca778dfb4d24e76b15143ef065133cf89bc86
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
<<<<<<< HEAD

        // ... create the file
        if (this.exists == false) {
            createFile(this.fileName);
        }else{
            loadFile();
=======
        if (this.exists == false) { // ... or create the file
            createFile();
>>>>>>> f16ca778dfb4d24e76b15143ef065133cf89bc86
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

<<<<<<< HEAD
    //saves the file by iterating the given ArrayList<Student>
    public void saveFile(ArrayList<Student> student) throws IOException{
        //deleting the existing contents
=======
    //saves the file this.fileName by iterating the given ArrayList
    public int saveStudents(ArrayList fileData) throws IOException{
        //deleting the existing contents and create a new file since
        //all data come through the argument
>>>>>>> f16ca778dfb4d24e76b15143ef065133cf89bc86
        this.f.delete();
        this.f.createNewFile();

        //setting up the writer
<<<<<<< HEAD
        PrintWriter writer = new PrintWriter(new FileWriter(this.fileName));

        //iterating the ArrayList<Student> and write them to a file
        for (Student studentLine : student) {
            writer.write(studentLine.toString());
        }
=======
        PrintWriter writer = new PrintWriter(new FileWriter("StudentDetails.txt"));

        //iterating the ArrayList and write them to a file
        fileData.forEach((line) -> {
            writer.write(line.toString());
        });
>>>>>>> f16ca778dfb4d24e76b15143ef065133cf89bc86
        writer.close();
        return 0;
    }

    //loads a file
    public ArrayList<Student> loadStudentsFromFile() throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader("StudentDetails.txt"));
        //Local List for students
<<<<<<< HEAD
        ArrayList<Student> studentFromFile = new ArrayList<Student>();

        //iterating through the lines
        for (String line = in.readLine(); line != null; line = in.readLine()) {
             String studentData[] = line.split(","); //explode it!
             //make new students
             studentFromFile.add(new Student(studentData[0], studentData[1], studentData[2]));
        }
=======
        ArrayList<Student> studentList = new ArrayList<>();

            //iterating through the line
            for (String line = in.readLine(); line != null; line = in.readLine()) {

                if (line.length() > 0) {
                    String studentData[] = line.split(","); //explode it!
                 //make new students
                 studentList.add(new Student(studentData[0],
                                             studentData[1],
                                             studentData[2],
                                             studentData[3]));
                }
            }
>>>>>>> f16ca778dfb4d24e76b15143ef065133cf89bc86
        in.close();
        return studentList;
    }

    //loads a course from file
    public Course loadCourseFromFile() throws FileNotFoundException, IOException{
            Course course; //initialize just for safety
            BufferedReader in = new BufferedReader(new FileReader("CourseDetails.txt"));
            String line = in.readLine();
            try{
                 if(line.length() > 0){
                String[] details = line.split(",");
                course = new Course(details[0],details[1]);

            }
            else{ //create a new file and adds a new course
                f.delete();
                createFile();
                System.out.println("No courses exists..");
                course = new Course();
                saveCourse(course);
            }
            }catch(java.lang.NullPointerException e){
                //create a new file and adds a new course
                f.delete();
                createFile();
                System.out.println("No courses exists..");
                course = new Course();
                saveCourse(course);
            }
            in.close();
        return course;
    }

    public void saveCourse(Course courseDetails)
                throws FileNotFoundException, IOException{
        //saves a course name, lecturer
            PrintWriter writer = new PrintWriter(new FileWriter("CourseDetails.txt"));
            String tmpString = courseDetails.getName() + "," +
                               courseDetails.getLecturer()+"\n";
            writer.write(tmpString);
            writer.close();
    }
}
