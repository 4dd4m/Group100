package group100;

/**
 *
 * @author group100
 * This is a single student
 */
class Student {

    //variables for testing, can be deleted
    private String one;
    private String two;
    private String three;

    //Test Constructor to test the file saving, can be deleted
    Student(String one, String two, String three){
        this.one = one;
        this.two = two;
        this.three = three;
    }
    
    public void rename(String newName){
        //rename the student
    }

    //This method simply returns comma separated values, it is important to keep
    //This generates the one line String which goes into to file
    //Variables needs to be replaced for the real one obviously
    public String toString(){
        return ""+this.one+","+this.two+","+this.three+"\n";
    }
}
