import org.junit.Test;

public class AddingProjectTest extends ProjectsStoryTests {
    public AddingProjectTest(){
        super();
        try {
            SetUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLogin(){
        assertTrue(login("dudi","password"));
        assertFalse(login("david","not_password"));
        assertFalse(login("1000000","password"));
    }

    @Test
    public void testAddProject(){ // All fields must be filled properly
        assertTrue(addProjectDetails("Pacuman","game",450,"Dor","Ohayon","dor343@gmail.com",0524543444,"Microsoft"));
        assertFalse(addProjectDetails("Pacuman","",1000000000,"Doron","levi","doron43@gmail.com",0524554545,"Microsoft"));
        assertFalse(addProjectDetails("Chat-Room","chat",0,"Dor","Ohayon","or456@@@gmail.com",000,"Facebook"));
    }
    @Test
    public void testProjectStatusCheck(){ //Assumption: code include 7 chars - 2 (Uppercase) , 1 (Lowercase) and 4 numbers
        assertTrue(projectStatusCheck("ABs1234"));
        assertFalse(projectStatusCheck("111111111111111"));
        assertTrue(projectStatusCheck("12ErT89"));
        assertFalse(projectStatusCheck("999aaaaDDDD"));
    }
    @Test
    public void testLimitedTime(){ // below 600 hours
        assertTrue(limitedTime(580));
        assertTrue(limitedTime(400));
        assertFalse(limitedTime(1000));
        assertFalse(limitedTime(800));
    }
}