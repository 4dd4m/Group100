package group100;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

//Mr. Adam Torok - B00798824 Mr. Mateusz Tynkiewicz - B00798825
public class StudentTest {
    
    public StudentTest() {
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
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Student instance = new Student("Adam","male","Newry","25/10/2000");
        String expResult = "Adam,male,Newry,25/10/2000\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        instance = null;
        
    }

    /**
     * Test of prettifyStudent method, of class Student.
     */
    @Test
    public void testPrettifyStudent() {
        System.out.println("prettifyStudent");
        Student instance = new Student("Adam","male","Newry","25/10/2000");
        String expResult = "Name:		Adam\n" +
                            "Gender:		male\n" +
                            "Address:	Newry\n" +
                            "Date:		25/10/2000\n";
        String result = instance.prettifyStudent();
        assertEquals(expResult, result);
        instance = null;
       
    }

    /**
     * Test of getNumOfStudent method, of class Student.
     */
    @Test
    public void testGetNumOfStudent() {
        System.out.println("getNumOfStudent");
        Student instance = new Student("Adam","male","Newry","25/10/2000");
        int expResult = 3;
        int result = Student.getNumOfStudent();
        assertEquals(expResult, result);
        instance = null;
      
    }

    /**
     * Test of getName method, of class Student.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Student instance = new Student("Adam","male","Newry","25/10/2000");
        String expResult = "Adam";
        String result = instance.getName();
        assertEquals(expResult, result);
        instance = null;
    }

    /**
     * Test of getGender method, of class Student.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Student instance = new Student("Adam","male","Newry","25/10/2000");
        String expResult = "male";
        String result = instance.getGender();
        assertEquals(expResult, result);
        instance = null;
    }
    
     /**
     * Test of render method, of class Student.
     */
    
    @Test
    public void rename() {
        System.out.println("rename");
        Student instance = new Student("Adam","male","Newry","25/10/2000");
        String expResult = "New Name";
        instance.rename("New Name");
        String result = instance.getName();
        assertEquals(expResult, result);
        instance = null;
    }
    
}
