import group100.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class TestStudent {
    private Student dummy = new Student("Troy Munoz","male","New York","25/10/2004");
    
    @Test
    public void createStudent(){
        assertEquals("Create Student (Basic Constructor)","Troy Munoz",dummy.getName());
    }
    
    @Test
    public void renameStudentWithString(){
        dummy = new Student("Troy Munoz","male","New York","25/10/2004");
        dummy.rename("Castor Troy"); //with String
        assertEquals("Rename Student","Castor Troy",dummy.getName());
    }
    
    
    
}
