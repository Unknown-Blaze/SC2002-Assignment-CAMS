import java.util.Scanner;

public class Password {
    static Scanner sc = new Scanner(System.in);
    public static boolean inputPassword(User user){

        System.out.println("Input Password: ");

        for (int i = 0; i < 3; i++){

            char[] passwordChars = System.console().readPassword(); // Masked input
            // Convert char array to a string
            String password = new String(passwordChars);
            if (password.equals(user.getPassword())) {
                return true;
            }
            System.out.println("Wrong Password!");
        }
        System.out.println("You have entered an incorrect password 3 times.");
        return false;
    }

    public static void changePassword(User user) {

        if (user.getFirstTimeLogin()){
            System.out.println("This is your first login! Kindly change your password to something more secure (Lowercase, Uppercase, Number and Special characters)");
        }else{
            System.out.println("Please enter your old password:");
            int count = 0;
            String oldPassword = sc.nextLine();
            while (!oldPassword.equals(user.getPassword())){
                count++;
                System.out.println("Incorrect Password");
                if (count == 3){
                    System.out.println("Too many attempts! Cannot change password");
                    return;
                }
                oldPassword = sc.nextLine();
            }
            System.out.println("Please enter your new password:");
        }
        

        String newPassword = sc.nextLine();

        // If new password meets the criteria
        while (!isValidPassword(newPassword, user.getFirstTimeLogin())){
            newPassword = sc.nextLine();
        }
        if (newPassword != "x"){
            user.setPassword(newPassword);
            user.setFirstTimeLogin(false);
            System.out.println("Password changed successfully.");
        }else{
            System.out.println("Returning to menu...");
            Time.pause(1);
        }
            

    }
   
    private static boolean isValidPassword(String password, boolean firstTime) {
        if (!firstTime && password == "x") return true;
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must have at least one uppercase letter.");
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must have at least one lowercase letter.");
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            System.out.println("Password must have at least one number.");
            return false;
        }
        
        if (!password.matches(".*[!@#$%^&*()].*")) { 
            System.out.println("Password must have at least one special character.");
            return false;
        }
    
        return true;
    }
}
