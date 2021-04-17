/*
 * This file just create the 19 Dummy Student
 */
import group100.*;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Adam
 */
public class TestCreateStudentDetails {
    
    private FileHandler studentHandler;
    final String studentFileName = "StudentDetails.txt";
    private ArrayList<Student> student = new ArrayList<Student>();

    @Test
    public void create19Student() throws IOException{
        /* It will create the student file and fills up with 19 dummy */
        studentHandler = new FileHandler(studentFileName);  
        student.add(new Student("Adam","male","Newry","25/10/2000"));
        student.add(new Student("Troy Munoz","male","New York","25/10/2004"));
        student.add(new Student("Israel Mcghee","male","New York","5/7/1998"));
        student.add(new Student("Eduard Sellers","male","New York","10/4/1994"));
        student.add(new Student("Osman Thorne","male","New York","5/10/2006"));
        student.add(new Student("Rico Edmonds","male","New York","11/1/1990"));
        student.add(new Student("Vicky Blaese","female","New York","25/10/2008"));
        student.add(new Student("Gruffydd Dixon","male","New York","25/10/2000"));
        student.add(new Student("Geraldine Powell","female","New York","2/10/1970"));
        student.add(new Student("Shelby Caldwell","male","New York","2/1/1960"));
        student.add(new Student("Gordon Key","male","New York","6/8/2000"));
        student.add(new Student("Ajwa Shaw","female","New York","25/11/1998"));
        student.add(new Student("Bilal Connor","male","New York","25/12/1999"));
        student.add(new Student("Jasleen Mccann","female","New York","25/3/1992"));
        student.add(new Student("Jamal Prosser","male","New York","1/1/1994"));
        student.add(new Student("Giorgia Southern","female","New York","5/10/1998"));
        student.add(new Student("Umer Guest","male","New York","5/1/2007"));
        student.add(new Student("Franklin Casey","male","New York","25/6/2002"));
        student.add(new Student("Jena Nicholson","female","New York","11/09/2009"));
        student.add(new Student("20th Student","female","New York","11/09/2009"));
        studentHandler.saveStudents(student);
        
        student.forEach((stud) -> {
            System.out.println(stud.getName());
        });
        
        assertEquals(0,studentHandler.saveStudents(student));
    }
}
