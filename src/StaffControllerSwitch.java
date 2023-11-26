
public class StaffControllerSwitch
{
    private Staff staff;
    public StaffControllerSwitch(Staff staff)
    {
        this.staff = staff;
    }

    public void main()
    {

        StaffController control = new StaffController(staff);
        int choice = 7; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. Manage Camps");
            System.out.println("2. View Camps");
            System.out.println("3. Manage Enquiries");
            System.out.println("4. Manage Suggestions");
            System.out.println("5. Report Generation");
            System.out.println("6. Change Your Password");
            System.out.println("7. Exit");
            choice = Input.getInt();

            switch(choice)
            {
                case 1: 
                control.manageCamps();
                break;

                case 2: 
                control.viewCamps();
                break;

                case 3:
                control.manageEnquiries();
                break;

                case 4:
                control.manageSuggestions();
                break;

                case 5:
                control.reportGeneration();
                break;
                
                case 6:
                Password.changePassword(staff);
                break;

                case 7:
                System.out.println("You have exited the Staff Interface.");
                Time.pause(1);
                break;

                default:
                System.out.println("Please enter a valid input.");
            }
        } while(choice != 7);
    }
}
