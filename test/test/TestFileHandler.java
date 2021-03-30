package test;

import group100.*;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Adam
 */
public class TestFileHandler {
    
    final String fileName = "course.txt";
    
    final FileHandler handler;
    
    final Student test  = new Student("Adam","x","address2","dob1");
    final Student test2 = new Student("Adam2","x","address3","dob2");
    final Student test3 = new Student("Adam3","x","address4","dob3");
    public ArrayList<Student> students = new ArrayList<>();
    

    public TestFileHandler() throws IOException {
        students.add(test);
        students.add(test2);
        students.add(test3);
        this.handler = new FileHandler(fileName);
    }
}
