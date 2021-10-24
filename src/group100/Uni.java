package group100;

import java.io.IOException;
import java.util.ArrayList;
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
    //
    Uni(){
        try {
            FileHandler handler = new FileHandler(fileName);
            //try to load the file, if fails, handler will create a new file
            //and returns an empty ArrayList
            loadFile();
        } catch (IOException ex) {
            Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
    }

    public static void main (String[] args){
        Uni app = new Uni();
        System.out.println("Started...");
    }
}
