import java.util.*;
public class CampCommControllerSwitch
{
    public static Scanner sc = new Scanner(System.in);
    private CampCommitteeMember commMember;
    public CampCommControllerSwitch(CampCommitteeMember commMember)
    {
        this.commMember = commMember;
    }

    public void main()
    {
        CampCommController control = new CampCommController(commMember);
        int choice = 8; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Camps");
            System.out.println("2. Manage Student Enquiries");
            System.out.println("3. View Profile");
            System.out.println("4. Manage Registration");
            System.out.println("5. Manage Committee Member Enquiries");
            System.out.println("6. Manage Committee Member Suggestions");
            System.out.println("7. Report Generation");
            System.out.println("8. Change Your Password");
            System.out.println("9. Exit");
            choice = Input.getInt();

            switch(choice)
            {
                case 1: 
                control.viewCamps();
                break;

                case 2: 
                control.manageEnquiries();
                break;

                case 3: 
                control.viewProfile();
                break;

                case 4: 
                control.manageRegistration();
                break;

                case 5:
                control.manageCampCommEnquiries();
                break;

                case 6:
                control.manageSuggestions();
                break;

                case 7:
                control.reportGeneration();
                break;
                
                case 8:
                Password.changePassword(commMember);
                break;

                case 9:
                System.out.println("You have exited the committee member interface.");
                break;

                default:
                System.out.println("Please enter a valid input.");
            }
        } while(choice != 9);
    }
}

