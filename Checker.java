public class Checker {
    public static boolean numChecker(String s){
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))) return true;
        }
        return false;
    }
    public static boolean specialCharChecker(String s){
        for (int i = 0; i < s.length(); i++){
            if (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') return true;
        }
        return false;
    }
    public static boolean quit(String s){
        if (s.length() == 1 && s.toUpperCase().charAt(0) == 'X'){
            return true;
        }
        return false;
    }
    public static boolean quit(int i){
        if (i == -1){
            return true;
        }
        return false;
    }
    public static boolean onlyNumChecker(String s){
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
