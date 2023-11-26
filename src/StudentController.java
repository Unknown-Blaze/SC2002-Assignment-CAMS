import java.util.*;
public class StudentController 
{
    private Student student;
    static Scanner sc = new Scanner(System.in);

    public StudentController(Student student)
    {
        this.student = student;
    }
    public static boolean justMadeComm = false;

    public void viewCamps()
    {
        Filter filter = new Filter();
        StudentCampViewer viewer = new StudentCampViewer(student);
        int campChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {

            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Specific Details of a Camp");
            System.out.println("2. View All Camps");
            System.out.println("3. View Your Registered Camps");
            System.out.println("4. Exit");
            choice = Input.getInt();
            

            switch(choice)
            {
                case 1: 
                    if (viewer.viewAvailableCamps(student.getFaculty()).size() == 0) {
                        System.out.println("There are no camps you can view!");
                        break;
                    }else if(viewer.viewAvailableCamps(student.getFaculty()).size() == 1){
                        System.out.println("You can only view one camp:");
                        Time.pause(1);
                        viewer.viewCampDetails(viewer.viewAvailableCamps(student.getFaculty()).get(0));
                        break;
                    }
                    System.out.println("Which camp's details would you like to view? (1 - " + viewer.viewAvailableCamps(student.getFaculty()).size() + ")");
                    viewer.viewAllCamps();
                    
                    campChoice = Input.getInt(viewer.viewAvailableCamps(student.getFaculty()).size());
                    if (campChoice == -1) break;
                    viewer.viewCampDetails(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1));
                    break;

                case 2: 
                filter.filterCamps(viewer.viewAvailableCamps(student.getFaculty()), false);
                break;

                case 3:
                filter.filterCamps(student.getRegisteredCamps(), false);
                break;
                
                case 4:
                System.out.println("Exiting to menu...");
                Time.pause(1);
                break;

                default:
                    System.out.println("Please input a valid option");
            }
        } while(choice != 4);
    }

    public void manageEnquiries()
    {
        StudentCampViewer viewer = new StudentCampViewer(student);
        StudentEnquiryManager enquiryManager = new StudentEnquiryManager(student);
        int campChoice = 0;
        int enquiryChoice = 0;
        String question = "";
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Enquiries");
            System.out.println("2. Submit Enquiries");
            System.out.println("3. Edit Enquiries");
            System.out.println("4. Delete Enquiries");
            System.out.println("5. Exit");
            choice = Input.getInt();

            switch(choice)
            {
                case 1: 
                    enquiryManager.viewEnquiries();
                    break;

                case 2: 
                    if(viewer.viewAvailableCamps(student.getFaculty()).size() == 0)
                    {
                        System.out.println("There aren't any camps under your purview to enquire.");
                        break;
                    }
                    System.out.println("To which camp would you like to submit an enquiry? (1 - " + viewer.viewAvailableCamps(student.getFaculty()).size() + ")");
                    viewer.viewAllCamps();
                    campChoice = Input.getInt(viewer.viewAvailableCamps(student.getFaculty()).size());
                    if (campChoice == -1) break;
                    System.out.println("What is your question?");
                    question = sc.nextLine();
                    enquiryManager.submitEnquiry(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1), question);
                    break;

                case 3: 
                    if(student.getEnquiries().size() == 0)
                    {
                        System.out.println("There aren't any enquiries to edit.");
                        break;
                    }
                    System.out.println("Which of your enquiries would you like to edit? (1 - " + student.getEnquiries().size() + ")");
                    enquiryManager.viewEnquiries();
                    enquiryChoice = Input.getInt(student.getEnquiries().size());
                    if (enquiryChoice == -1) break;
                    System.out.println("What is your updated question?");
                    question = sc.nextLine();
                    enquiryManager.editEnquiry(student.getEnquiries().get(enquiryChoice - 1), question);
                    break;

                case 4:
                    if(student.getEnquiries().size() == 0)
                    {
                        System.out.println("There aren't any enquiries to delete.");
                        break;
                    }
                    System.out.println("Which of your enquiries would you like to delete? (1 - " + student.getEnquiries().size() + ")");
                    enquiryManager.viewEnquiries();
                    enquiryChoice = Input.getInt(student.getEnquiries().size());
                    if (enquiryChoice == -1) break;
                    enquiryManager.deleteEnquiry(student.getEnquiries().get(enquiryChoice - 1));
                    break;
                
                case 5:
                    System.out.println("Exiting to menu...");
                    Time.pause(1);
                    break;

                default:
                    System.out.println("Please select an appropriate option");
            }
        } while(choice != 5);
    }

    public void viewProfile()
    {
        StudentProfile sp = new StudentProfile(student);
        sp.viewProfile();
    }

    public void manageRegistration()
    {
        StudentCampViewer viewer = new StudentCampViewer(student);
        CampRegistrationManager registrationManager = new CampRegistrationManager(student);
        int campChoice = 0;
        String role = "";
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Registered Camps");
            System.out.println("2. Register for Camp");
            System.out.println("3. Withdraw from Camp");
            System.out.println("4. Exit");
            choice = Input.getInt();

            switch(choice)
            {
                case 1: 
                    registrationManager.viewRegisteredCamps();
                    break;

                case 2:
                    System.out.println("Which camp would you like to register for? (1 - " + viewer.viewAvailableCamps(student.getFaculty()).size() + ")");
                    viewer.viewAllCamps();
                    campChoice = Input.getInt();
                    if (campChoice <= 0) {
                        System.out.println("Not valid");
                        break;
                    }else if (campChoice > viewer.viewAvailableCamps(student.getFaculty()).size()){
                        System.out.println("Not valid");
                        break;
                    }
                    if(registrationManager.isInCamp(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice-1))){
                        System.out.println("You have already registered for this camp!");
                        break;
                    }
                    System.out.println("What role do you want to register for?");
                    System.out.println("(1) Attendee");
                    System.out.println("(2) Committee Member");
                    int roleNum = Input.getInt();
                    if(roleNum == 1) {
                        if (viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1).getAvailableSlots() == 0){
                            System.out.println("No more students can join this camp!");
                            break;
                        }
                        role = "Attendee";
                    }
                    else if(roleNum == 2) {
                        if (student.getCommMember()) {
                            System.out.println("You are already a Committee member of another Camp!");
                            break;
                        }else{
                            if (viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1).getAvailableCommitteeSlots() == 0){
                                System.out.println("No more slots remaining to become a Camp Committee Member");
                                break;
                            }
                            role = "committee";
                            registrationManager.registerForCamp(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1), this.student, role);
                            if (!viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1).getList().contains(student)){
                                break;
                            }
                            student.setCommMember(true);
                            justMadeComm = true;
                            student.setCampCommMemberOf(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1));
                            return;
                        }
                    }
                    else {
                        System.out.println("Invalid input");
                        break;
                    }
                    registrationManager.registerForCamp(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1), this.student, role);
                    break;

                case 3:
                    if (student.getRegisteredCamps().size() == 0){
                        System.out.println("You have not registered in any camps!");
                        break;
                    }
                    System.out.println("Which camp would you like to Withdraw from? (1 - " + student.getRegisteredCamps().size() + ")");
                    viewer.viewYourCamps();
                    campChoice = Input.getInt(student.getRegisteredCamps().size());
                    if (campChoice == -1) break;
                    if (student.getCommMember() && student.getCampCommMemberOf().equals(student.getRegisteredCamps().get(campChoice - 1))){
                        System.out.println("You cannot withdraw as a Camp Committee member!");
                        break;
                    }
                    registrationManager.withdrawFromCamp(student.getRegisteredCamps().get(campChoice - 1), this.student);
                    break;

                case 4:
                    System.out.println("Exiting to Menu");
                    break;
                
                default:
                    System.out.println("Please enter a valid input");
            }

        } while(choice != 4);
    }
}

