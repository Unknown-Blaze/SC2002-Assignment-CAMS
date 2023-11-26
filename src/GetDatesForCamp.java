import java.text.ParseException;
import java.util.*;

public class GetDatesForCamp implements CheckQuit{
    Scanner sc = new Scanner(System.in);
    private Date openDate = null, closeDate = null, regClose = null;

    public GetDatesForCamp(){
        
    }
    public void setDates(){
        System.out.println("What's the opening date of the camp? (DD/MM/YYYY)");
        setOpenDate();
        if (openDate == null) return;
        System.out.println("What's the closing date of the camp? (DD/MM/YYYY)");
        setCloseDate();
        if (closeDate == null) return;
        System.out.println("When does registration for this camp close? (DD/MM/YYYY)");
        setRegCloseDate();
    }

    public boolean checkIfQuit(String s){
        if (Checker.quit(s)) {
            System.out.println("Returning to Main Menu...");
            Time.pause(1);
            return true;
        }
        return false;
    }
    public boolean checkIfQuit(int i){
        if (Checker.quit(i)) {
            System.out.println("Returning to Main Menu...");
            Time.pause(1);
            return true;
        }
        return false;
    }
    public void setOpenDate(){
        while (true) {
            try {
                
                String s_openDate = sc.nextLine();
                if (checkIfQuit(s_openDate)) return;
                openDate = DateConverter.convertStringToDate(s_openDate);
                System.out.println("Opening date: " + openDate);
                break; // Exit the loop if the date is successfully parsed
            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Kindly use the format: DD/MM/YYYY");
            }
        }
    }

    public void setCloseDate(){
        while (true) {
            try {
                
                String s_closeDate = sc.nextLine();
                if (checkIfQuit(s_closeDate)) return;
                closeDate = DateConverter.convertStringToDate(s_closeDate);

                while (closeDate.before(openDate)){
                    System.out.println("Closing date cannot be before opening date!");
                    s_closeDate = sc.nextLine();
                    if (checkIfQuit(s_closeDate)) return;
                    closeDate = DateConverter.convertStringToDate(s_closeDate);
                }
                System.out.println("Closing date: " + closeDate);
                break; // Exit the loop if the date is successfully parsed
            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Kindly use the format: DD/MM/YYYY");
            }
        }
    }
    public void setRegCloseDate(){
        while (true) {
            try {
                
                String s_regClose = sc.nextLine();
                if (checkIfQuit(s_regClose)) return;
                regClose = DateConverter.convertStringToDate(s_regClose);

                while (regClose.after(openDate)){
                    System.out.println("Registration cannot close after camp opens!");
                    s_regClose = sc.nextLine();
                    if (checkIfQuit(s_regClose)) return;
                    regClose = DateConverter.convertStringToDate(s_regClose);
                }

                System.out.println("Registration Closing date: " + regClose);
                break; // Exit the loop if the date is successfully parsed
            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Kindly use the format: DD/MM/YYYY");
            }
        }
    }
    
    public Date[] getDates(){
        return new Date[]{openDate, closeDate, regClose};
    }
}
