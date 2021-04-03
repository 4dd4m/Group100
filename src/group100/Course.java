package group100;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class Course {
    private String name,lecturer;
    private int totalStudents = 0;
    private int maleCounter = 0;
    private int femaleCounter = 0;
    private float malePercent = 0f;
    final int MAXSTUDENTS = 20;
    protected boolean valid;
    private ArrayList<Student> students = new ArrayList<>();
    private FileHandler studentHandler;
    final String studentFileName = "StudentDetails.txt";
    Scanner Scan = new Scanner(System.in);
    
    //Standrad constructor. So we can do this: new Course('Drink Chiller','Lecturer Bill')
    public Course(String name, String lecturer) throws IOException{
        studentHandler = new FileHandler(studentFileName);
        this.name = name;
        this.lecturer = lecturer;
        validateCourse();
        loadStudents();
    }
    
    //Constructor Overload, if no arguments were supplied, we step into 'interactive mode', so we can do this: new Srudent();
    public Course() throws IOException{
        System.out.print("Course Add. Interactive mode (press 'x' to exit)\n");
        addCourse();
        loadStudents();
    }
    
    private void loadStudents() throws IOException{
        ArrayList<Student> studentFromFile = studentHandler.loadStudentsFromFile();
        Iterator i = studentFromFile.iterator();
        while(i.hasNext()){
            enrollStudent((Student) i.next());
        }  
    }
    
    private void saveStudents() throws IOException{
        //pass all the student to the student handler and save2
        FileHandler studdenthandler = new FileHandler("StudentDetails.txt");
        studdenthandler.saveStudents(students);  
    }
    
    public String getName(){
        return name; //returns a course name
    }
    
    public String getLecturer(){
        return lecturer; //returns a lecturer
    }
    
    public ArrayList<Student> getEnrolledStudents(){
        return students; //get all students who enrolled
    }
    
    public void enrollStudent(Student student) throws IOException{ //enroll a student
        if (totalStudents < MAXSTUDENTS) {      //can we store more?
            students.add(student);              //add the student
            totalStudents++;                    //increase the course counter
            if ("male".equals(student.getGender())) {
                this.maleCounter++;             //register the gender
            }else{
                this.femaleCounter++;
            }
            if (this.femaleCounter > 0 && this.maleCounter > 0) {
                //avoid div0, cast to float, calulate the gender%
                this.malePercent = 100 * (float) this.maleCounter / this.totalStudents;
            }else{
                this.malePercent = 0f;          //if one of the oprands 0, keep 0
            }
            saveStudents();
        }else{//max number of students reached
            System.out.println("Maximum number of students reached");
        }
    }
    
    private boolean addCourse(){
        //call the necessary methods, interactive mode
        //if the file is empty
        this.name = askQuestion("Course name: ");
        this.lecturer = askQuestion("Lecturer: ");
        return validateCourse();   
    }
    
    private String askQuestion(String question){
        //asks the question an returns a String
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
    
    private boolean validateCourse(){ 
        //true if it is a valid course (all field filled)
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
    public String toString(){
        //represents a student (used while writing a txt file)
        return ""+this.name+","+this.lecturer+"\n";
    }
    
    public void displayEnrolledStudents(){
        //display students in the main menu
        System.out.println("Enrolled Students: ");
        students.forEach((singleStudent) -> {
            System.out.println(singleStudent.prettifyStudent());
        });
    }
    
    public String prettifyCourse(){ 
        //displays a pretty version of course details
        System.out.println();
        System.out.print("Course Name:\t" +this.name+"\n"
                + "Lecturer:\t"+this.lecturer+"\n"
                + "Number of Students:\t"+this.totalStudents+"\n"
                + "Males: " + this.maleCounter +"\n"
                + "Male%: " + Math.round(this.malePercent) +"%\n"
                + "Females: " + this.femaleCounter +"\n");
        System.out.println();
        return "";
    }
}