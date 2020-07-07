import org.junit.Test;

public class ProjectRegistrationTest extends ProjectsStoryTests {
    public ProjectRegistrationTest(){
        super();
        try {
            SetUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testRegisterProject(){ // All fields must be filled properly
        assertTrue(registerProject(111111111, 222222222, 333333333, 444444444, "Oren"));
        assertFalse(registerProject(111111111, 777777777, 888888888, 999999999, "Oren"));
    }
    public void testChooseProject(){ //assuming that project 'Project1' is available, and 'Project2' not(other students already signed to it).
        assertTrue(chooseProject("Project1"));
        assertFalse(chooseProject("Project2"));
    }
    public void testStudentLogin(){ //assuming that "Anna" is a student and "Eden" isn't
        assertTrue(login("Anna", "12345678"));
        assertFalse(login("Eden", "87654321"));
    }
}
