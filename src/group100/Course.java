package group100;

import java.util.*;

public class Course {
    private String name,lecturer;
    private int totalStudents = 0;
    private float male = 0f;
    protected boolean valid;
    Scanner Scan = new Scanner(System.in);
    
    //Standrad constructor. So we can do this: new Course('Drink Chiller','Lecturer Bill')
    public Course(String name, String lecturer){
        this.name = name;
        this.lecturer = lecturer;
        validateCourse();
    }
    
    //Constructor Overload, if no arguments were supplied, we step into 'interactive mode', so we can do this: new Srudent();
    public Course(){
        System.out.print("Stundent Add. Interactive mode (press 'x' to exit)\n");
        addCourse();
    }
    
    private boolean addCourse(){//call the necessary methods, interactive mode
        this.name = askQuestion("Course name: ");
        this.lecturer = askQuestion("Lecturer: ");
        return validateCourse();   
    }
    private String askQuestion(String question){
        String tmpInput = "";
        while(tmpInput.length() == 0){
            System.out.print(question);
            tmpInput = Scan.nextLine();
            exitOnX(tmpInput); //if user send x, exit
        }
        return tmpInput;
    }
    
    private void exitOnX(String input){
        //if the user sends an x it will terminate the program
        if ("x".equals(input)) {
            System.out.print("Program has been terminated by user\n");
            System.exit(0);
        }
    }
    
    private boolean validateCourse(){ //true if it is a valid student (all field filled)
        if(this.name.length() > 0 && this.lecturer.length() > 0){
            this.valid = true;
            return true;
        }else{
            System.out.print("Invalid Course data");
            this.valid = false;
            return false; //if this is not a valid course, return false
        }
    }
    
    @Override
    public String toString(){//represents a student (used while writing a txt file)
        return ""+this.name+","+this.lecturer+"\n";
    }
    
    public String prettifyCourse(){ //displays a pretty version of course details
        System.out.print("Course Name:\t\t" +this.name+"\t\tLecturer:\t\t"+this.lecturer);
        return "";
    }
}