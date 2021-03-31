package group100;

/**
 *
 * @author matro
 */

import java.util.*;

public class Student {
    private String name,gender, address, dob;
    protected boolean valid;
    Scanner Scan = new Scanner(System.in);
    
    //Standrad constructor. So we can do this: new Student('John Doe','Male','Jordanstown',01/01/1991')
    public Student(String name, String gender, String address, String dob){
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        validateStudent();
    }
    
    //Constructor Overload, if no arguments were supplied, we step into 'interactive mode', so we can do this: new Srudent();
    public Student(){
        System.out.print("Stundent Add. Interactive mode (press 'x' to exit)\n");
        addStudent();
    }
    
    private boolean addStudent(){//call the necessary methods, interactive mode
        this.name = askQuestion("Student name: ");
        this.gender = askQuestion("Student gender: ");
        this.address = askQuestion("Student Address: ");
        this.dob = askQuestion("Student DOB: ");
        return validateStudent();   
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
    
    private boolean validateStudent(){ //true if it is a valid student (all field filled)
        if(this.name.length() > 0 && this.gender.length() > 0 && this.address.length() > 0 && this.dob.length() > 0){
            this.valid = true;
            return true;
        }else{
            System.out.print("Student contains empty fields... No student added...");
            this.valid = false;
            return false; //if this is not a valid student, return false
        }
    }
    
    @Override
    public String toString(){//represents a student (used while writing a txt file)
        return ""+this.name+","+this.gender+","+this.address+","+this.dob+"\n";
    }
    
    public String prettifyStudent(){ //displays a pretty versin of students
        System.out.print("Name:\t\t" +this.name+"\nGender:\t\t"+this.gender+"\nAddress:\t"+this.address+"\nDate:\t\t"+this.dob+"\n" );
        return "";
    }
    
    public int searchStudent(String partOfName){
        //if there is a match, returns an index
        return this.name.indexOf(partOfName);
    }
}