package group100;

/**
 *
 * @author matro
 */

import java.util.*;

public class Student {
    private String name,gender, address, dob;
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
    
    private void addStudent(){//call the necessary methods, interactive mode
        askName();
        askGender();
        askAddress();
        askDob();
        validateStudent();   
    }
     
    private void askName(){ //get the name from input
        String tmpName = "";
        while(tmpName.length() == 0){
            System.out.print("Enter Student's Name: ");
            tmpName = Scan.nextLine();
            exitOnX(tmpName); //if user send x, exit
            this.name = tmpName;
        }
    }
    
    private void askGender(){ //get the gender from input
        String genderInput = "";
        while(genderInput.length() == 0){
            System.out.print("Enter Student's Gender: ");
            genderInput = Scan.nextLine().toLowerCase();
            exitOnX(genderInput);//if user send x, exit
            if("male".equals(genderInput) || "1".equals(genderInput)){
                this.gender = "male";
            }else{
                this.gender = "female";
            }
        }
    }
    
    public void askAddress(){ //get the address from input
        String tmpAddress = "";
        while(tmpAddress.length() == 0){
            System.out.print("Enter Student's Address: ");
            tmpAddress = Scan.nextLine();
            exitOnX(tmpAddress);//if user send x, exit
            this.address = tmpAddress;
        }
    }
    
    private void askDob(){ //get the dob from input
        String tmpDob = "";
        while(tmpDob.length() == 0){
            System.out.print("Enter Student's Birthdate: ");
            tmpDob = Scan.nextLine();
            exitOnX(tmpDob);//if user send x, exit
            this.dob = tmpDob;           
        }
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
            return true;
        }else{
            System.out.print("Student contains empty fields... No student added...");
            return false; //if this is not a valid student, return false
        }
    }
    
    @Override
    public String toString(){//represents a student (used while writing a txt file)
        return ""+this.name+","+this.gender+","+this.address+","+this.dob;
    }
    
    public String prettifyStudent(){ //displays a pretty versin of students
        System.out.print("Name:\t\t" +this.name+"\nGender:\t\t"+this.gender+"\nAddress:\t"+this.address+"\nDate:\t\t"+this.dob+"\n" );
        return "";
    }
}