import java.util.*;

public class CampManager implements CampManagerInterface, CheckQuit
{
    public static Scanner sc = new Scanner(System.in);
    private Staff staff;
    GetDatesForCamp dateList = new GetDatesForCamp();
    public CampManager(Staff staff)
    {
       this.staff = staff;
    }
    public boolean checkIfQuit(String s){
        if (Checker.quit(s)) {
            System.out.println("Returning to Main Menu...");
            Time.pause(2);
            return true;
        }
        return false;
    }
    public boolean checkIfQuit(int i){
        if (Checker.quit(i)) {
            System.out.println("Returning to Menu...");
            Time.pause(2);
            return true;
        }
        return false;
    }
    public void createCamp()
    {

        System.out.println("What is the name of the camp? (Press x to quit and return to menu)");
        String campName;
        while (true){
            campName = sc.nextLine();
            if (checkIfQuit(campName)) return;
            if (!Checker.numChecker(campName)) break;
            System.out.println("Camp names cannot have numbers in them! Kindly input a valid camp name: ");
        }

        Date openDate, closeDate, regClose;
        
        dateList.setDates();
        for (Date d : dateList.getDates()){
            if (d == null) return;
        }
        openDate = dateList.getDates()[0];
        closeDate = dateList.getDates()[1];
        regClose = dateList.getDates()[2];

        System.out.println("Open to all or only your faculty? (0 - Open to all/1 - Only Faculty)");
        int facCheck;
        String facName = staff.getFaculty();

        facCheck = sc.nextInt();
        if (facCheck == 0) 
            facName = "NTU";            

        System.out.println("Where is the camp being held? (Press x to quit and return to menu)");
        String location;
        while (true){
            sc.nextLine();
            location = sc.nextLine();
            if (checkIfQuit(location)) return;
            if (!Checker.specialCharChecker(location)) break;
            System.out.println("Kindly input a valid location (No special characters)");
        }
        
        int totSlots;
        while (true) {
            try {
                System.out.println("What are the total number of slots available? (Enter -1 to exit)");
                while (true){
                    totSlots = sc.nextInt();
                    if (totSlots >= 1 || totSlots == -1){
                        break;
                    }
                    System.out.println("Error: Please enter a positive number. Total number of slots available: ");
                }
                if (checkIfQuit(totSlots)) return;
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.nextLine(); // Clear buffer
            }
        }
        
        int commSlots;
        while (true) {
            try {
                System.out.println("What are the total number of committee slots available? (Enter -1 to exit)");
                while (true){
                    commSlots = sc.nextInt();
                    if (commSlots <= totSlots && commSlots <= 10 && commSlots >= -1){
                        break;
                    }
                    if (totSlots >= 10) {
                        System.out.println("Error: Please enter a valid number (Between 0 and 10):");
                    }else{
                        System.out.println("Error: Please enter a valid number (Between 0 and " + totSlots + "):");
                    }
                    
                }
                if (checkIfQuit(commSlots)) return;
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.nextLine(); // Clear buffer
            }
        }
        
        System.out.println("What's the camp description?");
        sc.nextLine();
        String desc = sc.nextLine();
        
        Camp camp = new Camp(campName, openDate, closeDate, regClose, facName, location, totSlots, commSlots, desc, staff.getName());
        Camp.campList.add(camp);
        staff.getCreatedCamps().add(camp);
    }

    public void editCamp(Camp camp)
    {
        if(camp.getStaffName() != staff.getName())
        {
            System.out.println("This camp is not under your jurisdiction.");
            return;
        }
        else
        {
            int choice = 1;
            do
            {
                System.out.println("What characteristic of the camp would you like to edit?");
                System.out.println("(1) Camp Name");
                System.out.println("(2) Opening Date of Camp");
                System.out.println("(3) Closing Date of Camp");
                System.out.println("(4) Closing Date for Registration");
                System.out.println("(5) Number of Slots");
                System.out.println("(6) Number of Committee Slots");
                System.out.println("(7) Camp Description");
                System.out.println("(8) Camp Visibility");
                System.out.println("(9) Exit");
                choice = Input.getInt();
                switch(choice)
                {
                    case 1:
                    System.out.println("What should the new name of the camp be? (Press x to quit and return to menu)");
                    String campName;
                    while (true){
                        campName = sc.nextLine();
                        if (checkIfQuit(campName)) return;
                        if (!Checker.numChecker(campName)) {
                            camp.setName(campName);
                            break;
                        }
                        System.out.println("Camp names cannot have numbers in them! Kindly input a valid camp name: ");
                    }
                    break;

                    case 2:
                    System.out.println("What should the new opening date of camp be? (Press x to quit and return to menu)");
                    dateList.setOpenDate();
                    Date openDate = dateList.getDates()[0];
                    camp.setOpenDate(openDate);
                    break;

                    case 3:
                    System.out.println("What should the new closing date of camp be? (Press x to quit and return to menu)");
                    dateList.setCloseDate();
                    Date closeDate = dateList.getDates()[1];
                    camp.setCloseDate(closeDate);
                    break;

                    case 4:
                    System.out.println("What should the new closing date of registration be? (Press x to quit and return to menu)");
                    dateList.setRegCloseDate();
                    Date regClose = dateList.getDates()[2];
                    camp.setRegDate(regClose);
                    break;

                    case 5:
                    
                    int totSlots;
                    while (true) {
                        try {
                            System.out.println("How many total slots should there be? (Press -1 to quit and return to menu)");
                            while (true){
                                totSlots = Input.getInt();
                                if ((totSlots >= 1 && totSlots >= camp.getCommSlots()) || totSlots == -1){
                                    if (totSlots != -1)
                                        camp.setTotSlots(totSlots);
                                    break;
                                }
                                System.out.println("Error: Please enter a positive number. Total number of slots available: ");
                            }
                            if (checkIfQuit(totSlots)) return;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid integer.");
                            sc.nextLine(); // Clear buffer
                        }
                    }
                    break;

                    case 6:
                    
                    int commSlots;
                    while (true) {
                        try {
                            System.out.println("How many total committee slots should there be? (Press -1 to quit and return to menu)");
                            while (true){
                                commSlots = Input.getInt();
                                if (commSlots <= camp.getAvailableSlots() && commSlots <= 10 && commSlots >= -1){
                                    if (commSlots != -1)
                                        camp.setCommSlots(commSlots);
                                    break;
                                }
                                if (camp.getAvailableSlots() >= 10) {
                                    System.out.println("Error: Please enter a valid number (Between 0 and 10):");
                                }else{
                                    System.out.println("Error: Please enter a valid number (Between 0 and " + camp.getAvailableSlots() + "):");
                                }
                                
                            }
                            if (checkIfQuit(commSlots)) return;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid integer.");
                            sc.nextLine(); // Clear buffer
                        }
                    }
                    break;

                    case 7:
                    System.out.println("What should the new camp description be? (Press x to quit and return to menu)");
                    String desc = sc.nextLine();
                    if (checkIfQuit(desc)) return;
                    camp.setDesc(desc);
                    break;

                    case 8:
                    
                    while (true) {
                        try {
                            System.out.println("What should the camp's visibility be? (0/1)");
                            int visibility = Input.getInt();
                            if (visibility == 0 || visibility == 1){
                                camp.setVisibility(visibility);
                                break; 
                            }else{
                                System.out.println("You did not enter a valid visibility!");
                            }
                            
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid integer (0/1).");
                            sc.nextLine(); // Clear buffer
                        }
                    }

                    case 9:
                        System.out.println("Returning to menu...");
                        break;

                    default:
                    System.out.println("Please select a valid option next time.");
                }
            }while(choice != 9);
        }
    }

    public void deleteCamp(Camp camp)
    {

        Camp.campList.remove(camp); //Removes the camp from the list.
        staff.getCreatedCamps().remove(camp);
    }
}