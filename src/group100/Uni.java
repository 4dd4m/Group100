package group100;
import group100.Student;
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

    private String fileName = "course.txt";
    private FileHandler handler;
    private ArrayList<Student> student = new ArrayList<Student>();
    Scanner Scan = new Scanner(System.in);
    //
    Uni() throws IOException{
        try {
            handler = new FileHandler(fileName); // file exist? of not, please create
            loadFile(); //load the students
        } catch (IOException ex) {
            Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void loadFile() throws IOException{ //called from the constructor automatically
        student = handler.loadFile();
    }
    
    public void saveFile() throws IOException{ //saves the current students
        //throws the class ArrayList<Student> to save
        student = handler.saveFile(student);
    }
    public void displayMenu(){//Displays a menu
        System.out.println("Application Started");
        String menu = "1. List of current Students\n2. Search Student (nonW)\n3.Exit\n----------------------";
        
    while(true){ //inf loop
        System.out.println(menu);//display menu
        String choice = Scan.nextLine(); //ask user choice
            switch(choice){ //switch it
                case "1":
                    displayStudents("Current Students");
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
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
    
    public void displayStudents(String prefix){ //display students in the menu
        //Simply display the class Students
        System.out.println(prefix);
        for(Student singleStudent : student){
            System.out.println(singleStudent.prettifyStudent());
        }
    }

    public static void main (String[] args) throws IOException{
        Uni app = new Uni();
        app.displayMenu();
    }
}
