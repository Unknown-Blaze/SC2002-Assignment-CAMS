import java.util.*;

public class Input {
    static Scanner sc = new Scanner(System.in);
    public static int getInt(){
        int choice;
        while (true){
            try {
            choice = sc.nextInt();
            if (choice <= 0) {
                System.out.println("Error: Please enter a positive integer.");
            } else {
                break; 
            }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.nextLine(); // clear buffer
            }
        }
        return choice;
    }
    public static int getInt(int n){
        int choice;
        if (n == 0){
            System.out.println("Empty!");
            return -1;
        }
        while (true){
            try {
            choice = sc.nextInt();
            if (choice <= 0) {
                System.out.println("Error: Please enter a positive integer.");
            } else if (choice > n){
                System.out.println("Error: value out of bounds");
            }else{
                break;
            }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.nextLine(); // clear buffer
            }
        }
        return choice;
    }
}
