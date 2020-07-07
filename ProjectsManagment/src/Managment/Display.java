package Managment;

import java.util.Scanner;

public class Display {

    private static boolean run = true;
    private static int selection;
    private static Scanner input;
    private static DBData dbData;

    public static void main(String[]args){
        input=new Scanner(System.in);
        dbData=DBData.getDBData();
        printMenu();
    }

    private static void printMenu() {
        String user;
        String pass;
        while (run) {
            System.out.println("1.Register:");
            System.out.println("2.Login:");
            System.out.println("3.exit");
            switch (selection = input.nextInt()) {
                case 1:
                    System.out.println("Managment.User Name:");
                    user = input.next();
                    System.out.println("Password:");
                    pass = input.next();
                    if (dbData.registerUsers(user, pass)) System.out.println("Successfully recorded");
                    else System.out.println("Fail recorded");
                    break;
                case 2:
                    System.out.println("Managment.User Name:");
                    user = input.next();
                    System.out.println("Password:");
                    pass = input.next();
                    if (dbData.checkRegisterUser(user,pass)) {
                        dbData.setLoginUsers(user, pass);
                        System.out.println("Connected");
                        // printOptions();
                    } else System.out.println("Registreation first!");
                    break;
                case 3: run=false; break;
            }
        }
    }
}
