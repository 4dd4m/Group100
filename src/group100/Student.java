package group100;

/**
 *
 * @author matro
 */

import java.util.*;

public class Student {
    private String name,gender, address, dob;
    protected boolean valid;
    static int numOfStudent = 0;
    static int male = 0;        //class var to keep track all males
    static int female = 0;      //class var to keep track all males
    Scanner Scan = new Scanner(System.in);
    
    //Standrad constructor. So we can do this: 
    //new Student('John Doe','Male','Jordanstown',01/01/1991')
    public Student(String name, String gender, String address, String dob){
        //all variables are String, valiadates only on empty string
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        isValidStudent();
    }
    
    //Constructor Overload, if no arguments were supplied, we step into 
    //'interactive mode', so we can do this: new Srudent();
    public Student(){
        System.out.print("Stundent Add. Interactive mode (press 'x' to exit)\n");
        addStudent(); 
    }

    Student(Object next) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean addStudent(){//call the necessary methods, interactive mode
        this.name = askQuestion("Student name: ", "name");
        this.gender = askQuestion("Student gender (type \"male\" or \"female\")"
                + ": ", "gender");
        this.address = askQuestion("Student Address: ", "address");
        this.dob = askQuestion("Student DOB: ", "dob");
        return isValidStudent();   
    }
    
    private String askQuestion(String question, String field){ 
    //asks a question, with
        String tmpInput = "";
        while(tmpInput.length() == 0){
            System.out.print(question);
            tmpInput = Scan.nextLine();
            if (field.equals("gender")){
                if (tmpInput.equals("male") || tmpInput.equals("female")) {
                    switch(tmpInput){
                            case "male":
                                male++;
                                break;
                            case "female":
                                female++;
                                break;
                    }             
                }else{
                    System.out.println("Invalid gender. (Type \"male\" or"
                            + " \"female\")");
                    tmpInput = "";
                }
            }
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
    
    private boolean isValidStudent(){ 
        //true if it is a valid student 
        //(all field filled)
        if(this.name.length() > 0 && 
           this.gender.length() > 0 && 
           this.address.length() > 0 && 
           this.dob.length() > 0 && canStoreStudent() == true){
                this.valid = true;
                numOfStudent++;
                return true;
        }else{
            System.out.print("Invalid Data or the number of maximum "
                    + "student is reached. No student added...");
            this.valid = false;
            return false; //if this is not a valid student, return false
        }
    }
    
    @Override
    public String toString(){
        //represents a student (used while writing a txt file)
        return ""+this.name+","+this.gender+","+this.address+","+this.dob+"\n";
    }
    
    public String prettifyStudent(){ //displays a pretty versin of students
        System.out.print("Name:\t\t" +this.name
                       +"\nGender:\t\t"+this.gender
                       +"\nAddress:\t"+this.address
                       +"\nDate:\t\t"+this.dob+"\n" );
        return "";
    }
    
    public int searchStudent(String partOfName){
        //if there is a match, returns an index
        return this.name.indexOf(partOfName);
    }
    
    public static int getNumOfStudent(){
        //returns the number of Students
        return numOfStudent;
    }
    
    private static boolean canStoreStudent(){
        //maximum of 20 student can enrolled
        return numOfStudent < 20;
    }
    
    public String getName(){
        //returns with a student name (mostly for displays)
        return this.name;
    }
    
    public void rename(String newName){
        //rename the student
        this.name = newName;
    }
    
    public String getGender(){
        //get the gender of the student
        return this.gender;
    }
}