package Managment;

import Managment.NotificationManagment.Student;
import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class DBData {

    private static HashMap<String,String>names;
    private static HashMap<Integer,Date> dates;
    private static ArrayList<String> studentIDs;
    private static ArrayList<User> users ;
    private static ArrayList<Student> students ;
    private static HashMap<String,String> loginUsers;
    private static HashMap<Integer, DBRegisteredProjectInfo> registeredProjectInfos;
    private static HashMap<Integer, DBSuggestedProjectInfo> suggestedProjectInfos ;
    private static int projectId;
    private static int webCode;
    private static Date date;


    public DBData(){
        names=new HashMap<>();
        studentIDs=new ArrayList<>();
        registeredProjectInfos=new HashMap<>();
        suggestedProjectInfos=new HashMap<>();
        dates=new HashMap<>();
        users=new ArrayList<>();
        students=new ArrayList<>();
        loginUsers=new HashMap<>();
        projectId=100;
        webCode=6842;
        date=new Date();
        initialize();
    }

    private void initialize() {
        copyValues(acptTests.auxiliary.DBData.names,1);
        copyValues(acptTests.auxiliary.DBData.users,2);
        copyValues(acptTests.auxiliary.DBData.students,3);
        Collections.addAll(this.studentIDs, acptTests.auxiliary.DBData.studentIDs);
        for (User user:users) setLoginUsers(user.getUserName(),user.password);
        for (Student st:students) setLoginUsers(st.getUserName(),st.getPassword());
    }

    private void copyValues(String[][]elements,int choise){
        int i=0;
        while (i<elements.length) {
            switch (choise){
                case 1: names.put(elements[i][0],elements[i][1]); break;
                case 2: users.add(new User(elements[i][0],elements[i][1])); break;
                case 3: students.add(new Student(elements[i][0],elements[i][1])); break;
            }
            i++;
        }
    }


    public void setLoginUsers(String user,String password){
        loginUsers.put(user,password);
    }

    public boolean checkRegisterUser(String user,String pass){
        User u=getUser(user,pass);
        Student st=getStudent(user,pass);
        return ((u!=null)||(st!=null));
    }

    private User getUser(String u,String p){
        for (User user :users) {
            if (user.userName.equals(u) && user.password.equals(p)) return user;
        }
        return null;
    }

    public Student getStudent(String u,String p){
        for (Student student :students) {
            if (student.getUserName().equals(u) && student.getPassword().equals(p)) return student;
        }
        return null;
    }

    public boolean checkLoginUser(String user,String pass){
        return (loginUsers.containsKey(user) && loginUsers.get(user).equals(pass));
    }

    public boolean registerUsers(String user,String password){
        if (getUser(user,password)==null){
            users.add(new User(user,password));
            return true;
        }
        return false;
    }

    public void registerNewTechnicalAdviser(String user, String password) {
        users.add(new User(user,password));
    }

    public void addNewStudent(String user, String password) {
        students.add(new Student(user,password));
    }

    public int addNewProject(DBSuggestedProjectInfo suggested){
    suggestedProjectInfos.put(++projectId,suggested);
    dates.put(projectId,date);
    return projectId;
    }

    public boolean differentNames(DBSuggestedProjectInfo suggested){
        if (suggestedProjectInfos.isEmpty()) return true;
        for (DBSuggestedProjectInfo projectInfo:suggestedProjectInfos.values()) {
            if (projectInfo.projectName.equals(suggested.projectName)) {
                if ((projectInfo.organization != "" && suggested.organization.equals(projectInfo.organization)) ||
                        (suggested.organization == "" && projectInfo.firstName.equals(suggested.firstName) && projectInfo.lastName.equals(suggested.lastName)))
                    return false;
            }
        }
            return true;
    }

    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        suggestedProjectInfos.remove(registeredProject.projectId);
        registeredProjectInfos.put(registeredProject.projectId,registeredProject);
        for (String id:registeredProject.studentList)
            studentIDs.add(id);
        return ++webCode;
    }

    public boolean existProject(int projectId) {
        return suggestedProjectInfos.containsKey(projectId);
    }

    public static DBData getDBData() {
        return new DBData();
    }
}
