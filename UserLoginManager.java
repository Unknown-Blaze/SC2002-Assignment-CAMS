public class UserLoginManager {

    public static void loginUser(User user) {

        if (user != null) {


            if (user.getFirstTimeLogin()) {
                // Prompt new user to change password
                Password.changePassword(user);
            }

            // Continue with the regular process after password change or if not a new user        
        }
    }
}
