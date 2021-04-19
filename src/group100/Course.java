package group100;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
//describe a course, containing students in a list
public class Course {
    private String name,lecturer;
    private int totalStudents = 0;
    private int maleCounter = 0;
    private int femaleCounter = 0;
    private float malePercent = 0f;
    private float femalePercent = 0f;
    final int MAXSTUDENTS = 20;
    protected boolean valid;
    private ArrayList<Student> students = new ArrayList<>();
    private FileHandler studentHandler;
    final String studentFileName = "StudentDetails.txt";
    Scanner Scan = new Scanner(System.in);

    //Standrad constructor. So we can do this:
    //new Course('Drink Chiller','Lecturer Bill')
    public Course(String name, String lecturer) throws IOException{
        studentHandler = new FileHandler(studentFileName);
        this.name = name;
        this.lecturer = lecturer;
        validateCourse();
        loadStudents();
    }

    //Constructor Overload, if no arguments were supplied,
    //we step into 'interactive mode', so we can do this: new Srudent();
    public Course() throws IOException{
        System.out.print("Course Add. Interactive mode (press 'x' to exit)\n");
        addCourse();
        loadStudents();
    }

    private void loadStudents() throws IOException{
        //get the stored students from the filehandler
        //every student passed to enrollStudent (data integrity)
        ArrayList<Student> studentFromFile = studentHandler.loadStudentsFromFile();
        Iterator i = studentFromFile.iterator();
        while(i.hasNext()){
            enrollStudent((Student) i.next());
        }
    }

    public void saveStudents() throws IOException{
        //pass all the students<> to the student handler and save2
        FileHandler studentHandler = new FileHandler("StudentDetails.txt");
        studentHandler.saveStudents(students);
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

    public void interactiveEnrollStudent(Student student) throws IOException{
        //enroll a student and save the new student list
        enrollStudent(student);
        saveStudents();
    }

    public boolean isMaxStudentEnrolled(){
        //this is a pre-check to avoid on those cases where the course is full
        //and we want to avoid straight enetring into interaction mode
        if (students.size() >= 20) {
            System.out.println("-------------------------------");
            System.out.println("This course is full ("+ MAXSTUDENTS+" students)");
            System.out.println("-------------------------------");
            return true;
        }else{
            return false;
        }
    }

    private void enrollStudent(Student student) throws IOException{
    //enroll a student
    //automatic pre-populate calls this function
    //interactive enroll calls this function
        if (totalStudents < MAXSTUDENTS) {              //can we store more?
            students.add(student);                      //add the student
            totalStudents++;                            //increase the courseCount
            if ("male".equals(student.getGender())) {
                this.maleCounter++;                     //register the gender
            }else{
                this.femaleCounter++;
            }
            calculatePercent();                         //update the percentage
        }else{//max number of students reached
            System.out.println("Maximum number of students reached");
        }
    }

    private void calculatePercent(){
        //calculate the male percent or dis
        if (this.femaleCounter > 0 && this.maleCounter > 0) {
                //avoid div0, cast to float, calulate the gender%
                this.malePercent = 100 * (float) this.maleCounter / this.totalStudents;
                this.femalePercent = 100 - this.malePercent;
        }else if(this.maleCounter > 0 && this.femaleCounter == 0){
            //course is pure males
            this.malePercent = 100f;
        }else if(this.femaleCounter > 0 && this.maleCounter == 0){
            //course is pure males
            this.malePercent = 0f;
            this.femalePercent = 100f;
        }else{
            //pure females or division 0
                this.malePercent = 0f;          //if one of the oprands 0, keep 0
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
        String output = "Course Name:\t\t" +this.name+"\n"
                + "Lecturer:\t\t"+this.lecturer+"\n"
                + "Number of Students:\t"+this.totalStudents+"\n"
                + "Males:\t\t\t" + this.maleCounter +"\n"
                + "Females:\t\t" + this.femaleCounter +"\n"
                + "Male%:\t\t\t" + Math.round(this.malePercent) +"%\n"
                + "Female%:\t\t" + Math.round(this.femalePercent) +"%\n";
        System.out.print(output);
        System.out.println();
        return output;
    }

    public void searchStudent(){
        //search a student
        if (!this.students.isEmpty()) {
            System.out.print("Enter a student name: ");
            String query = Scan.nextLine();
            searchStudent(query);
        }else{
            System.out.println("There is no student in this course");
        }
    }

    public void searchStudent(String query){
        //search a student and returns with his/her name
        boolean isFound = false;
        for (Student student : students){
            if (student.getName().contains(query)) {
                System.out.println("-------------");
                System.out.println("Student found");
                System.out.println("-------------");
                student.prettifyStudent();
                System.out.println("-----------------");
                isFound = true;
                break;
            }
        }
        if (isFound == false) {
            System.out.println("-----------------");
            System.out.println("Student not found");
            System.out.println("-----------------");
        }    
    }

    public void listStudentForDelete() throws IOException{
        //deletes a student
        if (students.isEmpty()) { // if students empty
            System.out.println("");
            System.out.println("Student File is empty, "
                             + "add students to the course first");
            System.out.println("Falling back to main menu");
            System.out.println("");
            return;
        }
       int i = 0;
       System.out.println("(\"x\") to quit");

       //render the output: id name
       for (Student student : students){
            System.out.println("Id: "+ i + "\t"+student.getName());
            i++;
        }

       //waiting for an id to initiate deletion or X to quit
       while(true){
           //ask user input
            System.out.print("Enter an id to delete a student:  ");
            String userChoice = Scan.nextLine();
            if (userChoice.equals("x")) { //quit
               System.out.println("--------------------------");
               System.out.println("Falling back to The Main Menu");
               System.out.println("--------------------------");
               break;
           }
             try{
                 //make an int from the input
                 int userInt = Integer.parseInt(userChoice);
                 deleteStudentAtIndex(userInt);
                 return;
             }
             catch(IndexOutOfBoundsException e){ //input > student.size()-1
                 System.out.println("Wrong Id");
             }
             catch(NumberFormatException e){ //if its cannot be casted to int
                 //fall back to the cycle, ask the input again
                 System.out.println("Input Must Be String");
             }
       }
    }

    public boolean deleteStudentAtIndex(int index) throws IOException, IndexOutOfBoundsException{
        //actually delete the student from the course by the given index
        // listStudentForDelete() check the student existance therefore, no needed
        //access the student for his/her name
         Student student = this.students.get(index);

         System.out.println("-----------------------------------------------");
         System.out.println("Student removed from the course: " + student.getName());
         System.out.println("-----------------------------------------------");
         students.remove(index); //remove the student
         this.totalStudents--;   //one student less

        //decrease the gendercounter as well
        if ("male".equals(student.getGender())) {
            this.maleCounter--;
        }else{
             this.femaleCounter--;
         }

        //update the percentage
        calculatePercent();
        //save
        saveStudents();
        return true;
    }
    
    public int getNumOfStudents(){
        return students.size();
    }

}
