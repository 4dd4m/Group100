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
 * //Mr. Adam Torok - B00798824 Mr. Mateusz Tynkiewicz - B00798825
 * displays the menu */
public class Uni {
    private String courseFileName = "CourseDetails.txt";
    private FileHandler courseHandler;
    private Course course;
    Scanner Scan;
    Uni() throws IOException{
        this.Scan = new Scanner(System.in);
        try {
<<<<<<< HEAD
            FileHandler handler = new FileHandler(fileName);
            //try to load the file, if fails, handler will create a new file
            //and returns an empty ArrayList
            loadFile();
=======
            courseHandler = new FileHandler(courseFileName);
            course = courseHandler.loadCourseFromFile();
>>>>>>> f16ca778dfb4d24e76b15143ef065133cf89bc86
        } catch (IOException ex) {
            Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

<<<<<<< HEAD
    public void loadFile() throws IOException{
        //this.student = handler.loadFile(); //never been tested
    }
    public void saveFile() throws IOException{
        //throws the current ArrayList to save
        handler.saveFile(this.student); //never been tested
    }
    public void displayMenu(){
    //while not exit
    //display choices
    //if choice == n
    //call method n
    }

    private void renameStudent(int index, String oldName, String newName){
        //index = searchStudent(oldname)
        //student[index].rename(newName)
    }

    private Student searchStudent(String studentName){
    //iterating the student ArrayList and return the index of a match
    return new Student("after","a","search");
=======
    public void displayMenu() throws IOException{//Displays a menu
        System.out.println("Application Started");
        String menu = "1. Enrolled Students\n"
            + "2. List Courses Details\n"
            + "3. Add Student\n"
            // + "4. Add Course\n"
            + "4. Search Student\n"
            + "5. Delete a Student\n"
            + "6.Exit\n"
            + "----------------------";

        while(true){ //inf loop
            System.out.println(menu);//display menu
            String choice = Scan.nextLine(); //ask user choice
            switch(choice){ //switch it
                case "1":                                       // list student
                    course.displayEnrolledStudents();
                    break;
                case "2":                                       // list student
                    course.prettifyCourse();
                    break;
                case "3":                                // create a new student
                    if (course.isMaxStudentEnrolled() == false){
                        //only enter interactive mode if student can enroll
                        Student tmpStudent = new Student();
                        if (tmpStudent.valid == true) {
                            course.interactiveEnrollStudent(tmpStudent);
                        }
                    }
                    break;
                    // case "10":                              // create a new course
                    //      course = new Course();
                    //     if (course.valid == true) {
                    //         courseHandler.saveCourse(course);
                    //     }
                    //     break;
                case "4":                                     //search a student
                    course.searchStudent();
                    break;
                case "5":                                    //Delete a student
                    course.listStudentForDelete();
                    break;
                case "6":
                    System.out.println("Bye bye");
                    System.exit(0);
                default:
                    System.out.println("This is not a choice");
                    break;
            }
        }
>>>>>>> f16ca778dfb4d24e76b15143ef065133cf89bc86
    }

    public static void main (String[] args) throws IOException{
        //Program starts here
        Uni app = new Uni();    // instantiation Uni class
        app.displayMenu();      //throw the menu
    }
}
