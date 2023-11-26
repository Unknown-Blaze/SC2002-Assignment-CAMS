import java.util.Scanner;

public class Login extends Initialize{
    static Scanner sc = new Scanner(System.in);
    static String username = "";
    static String type;

    public static User login() {
        System.out.println("Input Username: ");
        while (true) {
            username = sc.next();
            if (contains_special(username)) {
                System.out.println("Please Input a valid username!");
            } else {
                if (Search.searchStudent(username) != null) {
                    type = "student";
                    break;
                } else if (Search.searchStaff(username) != null) {
                    type = "staff";
                    break;
                } else {
                    System.out.println("User not found, please try again: ");
                }
            }
        }
        return LoginSuccess();
    }

    public static User LoginSuccess(){
        User user = null;
        if (type == "staff"){
            user = (Staff) Search.searchStaff(username);
        }else if (type == "student"){
            user = (Student) Search.searchStudent(username);
        }
        return user;
    }

    public static boolean contains_special(String s){
        for (int i = 0; i < s.length(); i++){

            if (!(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
                return true;
            }
        }
        return false;
    }

    public static String getType(){
        return type;
    }
}