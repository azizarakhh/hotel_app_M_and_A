package uz.app.hotel.classServices;

import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Role;
import uz.app.hotel.entity.User;

import java.util.ArrayList;
import java.util.Objects;

import static uz.app.hotel.util.Utils.*;

public class AuthClass {

    static final String YELLOW = "\u001B[33m";
    static DB db = DB.getInstance();
    static User currentUser;
    static AdminClass adminClass = AdminClass.getInstance();
    static UserClass userClass = UserClass.getInstance();

    public void method() {
        while (true){
            switch (menu()){
                case 0 -> {
                    System.out.println("See you soon!");
                    return;
                }
                case 1 -> signIn();
                case 2 -> signUp();
            }
        }
    }

    private void signIn() {
        System.out.println("Enter username: ");
        String username = strScanner.nextLine();
        if (username.equals("")){
            System.out.println(RED + "Invalid username!" + RESET);
            return;
        }
        System.out.println("Enter password: ");
        String password = strScanner.nextLine();
        if (password.equals("")){
            System.out.println(RED + "Invalid password!" + RESET);
            return;
        }
        boolean isFound = false;
        for (User user : db.users) {
            if (Objects.equals(user.getUsername(), username) && Objects.equals(user.getPassword(), password)) {
                currentUser = user;
                isFound = true;
                break;
            }
        }
        if (isFound) {
            if (Objects.equals(currentUser.getRole(), Role.ADMIN))
                adminClass.service();
            else if (Objects.equals(currentUser.getRole(), Role.USER))
                userClass.reserve();
            else {
                System.err.println("ERROR");
            }
        } else
            System.out.println(YELLOW + "Such user not found!" + RESET);
    }

    private void signUp() {
        System.out.println("Enter username: ");
        String username = strScanner.nextLine();
        if (username.equals("")){
            System.out.println(RED + "Username is invalid!" + RESET);
            return;
        }
        for(User user : db.users){
            if (Objects.equals(user.getUsername(), username)) {
                System.out.println(YELLOW + "This username is exists!" + RESET);
                return;
            }
        }
        System.out.println("Enter password: ");
        String password = strScanner.nextLine();
        System.out.println("Enter balance: ");
        Double balance = nextDouble();
        if (password.equals("") || balance < 0 || balance.equals("")){
            System.out.println(RED + "Username is invalid!" + RESET);
            return;
        }
    }

    private int menu(){
        System.out.println("""
                
                0 -> Exit
                1 -> Sign in
                2 -> Sign up
                """);
        return nextInteger();
    }

    private static AuthClass authClass ;
    public static AuthClass getInstance(){
        if (authClass == null)
            authClass=new AuthClass();
        return authClass;
    }
}
