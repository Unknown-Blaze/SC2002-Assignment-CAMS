public class Getter extends Initialize{
    private Getter(){}

    public static String getusername(String s) {
        // From a line in buffered reader
        String[] parts = s.split("\t");
        if (parts.length == 3) {
            String email = parts[1];
            int index = email.indexOf('@');
            if (index != -1) {
                String username = email.substring(0, index);
                return username;
            }
        // From email
        }else if (parts.length == 1){
            String email = s;
            int index = email.indexOf('@');
            if (index != -1) {
                String username = email.substring(0, index);
                return username;
            }
        }
    
        System.out.println("Something wrong here getUsername...");
        return ""; // Return an empty string 
    }

    public static String getusername(User user) {
        // From a line in buffered reader
        String email = user.getEmail();
        return getusername(email);
    }
}
