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
    private String courseFileName = "CourseDetails.txt";
    private FileHandler courseHandler;
    private Course course;
    Scanner Scan;

    Uni() throws IOException{
        this.Scan = new Scanner(System.in);
        try {
            courseHandler = new FileHandler(courseFileName);
            course = courseHandler.loadCourseFromFile();
        } catch (IOException ex) {
            Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayMenu() throws IOException{//Displays a menu
        System.out.println("Application Started");
        String menu = "1. Enrolled Students\n2. List of current Courses\n3. Add Student\n4. Add Course\n5. Search Student (nonW)\n6.Exit\n----------------------";
        
    while(true){ //inf loop
        System.out.println(menu);//display menu
        String choice = Scan.nextLine(); //ask user choice
            switch(choice){ //switch it
                case "1": // list student
                    course.displayEnrolledStudents();
                    break;
                case "2": // list student
                    course.prettifyCourse();
                    break;
                case "3": // create a new student
                    Student tmpStudent = new Student();
                    if (tmpStudent.valid == true) {
                        course.enrollStudent(tmpStudent);
           
                    }         
                    break;
                case "4": // create a new student
                     course = new Course();
                    if (course.valid == true) {
                        courseHandler.saveCourse(course);
                    }         
                    break;
                case "5":
                    //
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

    public static void main (String[] args) throws IOException{
        Uni app = new Uni();
        app.displayMenu();
    }
}
