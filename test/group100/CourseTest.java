//Mr. Adam Torok - B00798824 Mr. Mateusz Tynkiewicz - B00798825
package group100;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourseTest {
    
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of getName method, of class Course.
     */
    @Test
    public void testGetName() throws IOException {
        System.out.println("getName");
        Course instance = new Course("Course name","Lecturer");
        String expResult = "Course name";
        String result = instance.getName();
        assertEquals(expResult, result);
        instance = null;
    }

    /**
     * Test of getLecturer method, of class Course.
     */
    @Test
    public void testGetLecturer() throws IOException {
        System.out.println("getLecturer");
        Course instance = new Course("Course name","Lecturer");
        String expResult = "Lecturer";
        String result = instance.getLecturer();
        assertEquals(expResult, result);
        instance = null;
       
    }

    /**
     * Test of isMaxStudentEnrolled method, of class Course.
     * @throws java.io.IOException
     */
    @Test
    public void testIsMaxStudentEnrolled() throws IOException {
        System.out.println("isMaxStudentEnrolled");
        Course instance = new Course("Course name","Lecturer");
        boolean expResult = false;
        boolean result = instance.isMaxStudentEnrolled();
        assertEquals(expResult, result);
        instance = null;
    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        Course instance = new Course("Course name","Lecturer");
        String expResult = "Course name,Lecturer\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        instance = null;
    }
    
}
