package group100;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author group100
 * This is the main class of the application, instantiate itself
 * call the filehandler, if file exists, load them, if not, create them
 * displays the menu */
public class Uni {
    private String studentFileName = "StudentDetails.txt";
    private String courseFileName = "CourseDetails.txt";
    private FileHandler studentHandler;
    private FileHandler courseHandler;
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    Scanner Scan;
    //
    Uni() throws IOException{
        this.Scan = new Scanner(System.in);
        try {
            studentHandler = new FileHandler(studentFileName); // file exist? of not, please create
            courseHandler = new FileHandler(courseFileName);
            loadFile(); //load the students
        } catch (IOException ex) {
            Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadFile() throws IOException{ //called from the constructor automatically
        studentList = studentHandler.loadFile("student");
        courseList = courseHandler.loadFile("course");
    }
    
    public void saveFile() throws IOException{ //saves the current students
        //throws the class ArrayList to save
        studentHandler.saveFile(studentList);
        courseHandler.saveFile(courseList);
    }
    public void displayMenu() throws IOException{//Displays a menu
        System.out.println("Application Started");
        String menu = "1. List of current Students\n2. List of current Courses\n3. Add Student\n4. Add Course\n5. Search Student (nonW)\n6.Exit\n----------------------";
        
    while(true){ //inf loop
        System.out.println(menu);//display menu
        String choice = Scan.nextLine(); //ask user choice
            switch(choice){ //switch it
                case "1": // list student
                    displayStudents("Current Students");
                    break;
                case "2": // list student
                    displayCourse("Current Courses");
                    break;
                case "3": // create a new student
                    Student tmpStudent = new Student();
                    if (tmpStudent.valid == true) {
                        studentList.add(tmpStudent);
                        saveFile();
                    }         
                    break;
                case "4": // create a new student
                    Course tmpCourse = new Course();
                    if (tmpCourse.valid == true) {
                        courseList.add(tmpCourse);
                        saveFile();
                    }         
                    break;
                case "5":
                    searchStudent();
                    break;
                case "6":
                    System.out.println("Bye bye");
                    System.exit(0);
                default:
                    System.out.println("This is not a choice");
                    break;
            }
        }
    }
    
    private void renameStudent(int index, String oldName, String newName){
        //index = searchStudent(oldname)
        //student[index].rename(newName)
    }
    
    private Student searchStudent(){ //search a student in the students
        System.out.println("Enter student name: ");
        String query = Scan.nextLine();
        System.out.println("Will display results later");
        //iterating the student ArrayList and return the index of a match
        return new Student("name","gender","address","dob");
    }
    
    private void displayCourse(String prefix){
        System.out.println(prefix);
        courseList.forEach((singleCourse) -> {
            System.out.println(singleCourse.prettifyCourse());
        });
    }
    
    public void displayStudents(String prefix){ //display students in the menu
        //Simply display the class Students
        System.out.println(prefix);
        studentList.forEach((singleStudent) -> {
            System.out.println(singleStudent.prettifyStudent());
        });
    }

    public static void main (String[] args) throws IOException{
        Uni app = new Uni();
        app.displayMenu();
    }
}
