import java.util.*;
public class StaffController 
{
    private Staff staff;
    public static Scanner sc = new Scanner(System.in);

    public StaffController(Staff staff)
    {
        this.staff = staff;
    }

    public void manageCamps()
    {

        CampManager manager = new CampManager(staff);
        StaffCampViewer viewer = new StaffCampViewer(staff);
        int campChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. Create Camp");
            System.out.println("2. Edit Camp");
            System.out.println("3. Delete Camp");
            System.out.println("4. Exit");
            choice = Input.getInt();

            switch(choice)
            {
                case 1: 
                    manager.createCamp();
                    break;

                case 2: 
                    System.out.println("Which camp's details would you like to edit? (1 - " + staff.getCreatedCamps().size() + ")");
                    viewer.viewYourCamps();
                    campChoice = Input.getInt(staff.getCreatedCamps().size());
                    if (campChoice == -1) break;
                    manager.editCamp(staff.getCreatedCamps().get(campChoice - 1));
                    break;

                case 3:
                    System.out.println("Which camp's details would you like to delete? (1 - " + staff.getCreatedCamps().size() + ")");
                    viewer.viewYourCamps();
                    campChoice = Input.getInt(staff.getCreatedCamps().size());
                    if (campChoice == -1) break;
                    manager.deleteCamp(staff.getCreatedCamps().get(campChoice - 1));
                    break;
                
                case 4:
                    System.out.println("Returning to Menu");
                    Time.pause(2);
                    break;

                default:
                    System.out.println("Please enter a valid input");
            }
        } while(choice != 4);
    }

    public void viewCamps()
    {
        Filter filter = new Filter();
        StaffCampViewer viewer = new StaffCampViewer(staff);
        int campChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Specific Details of a Camp");
            System.out.println("2. View All Camps");
            System.out.println("3. View Your Created Camps");
            System.out.println("4. Exit");
            choice = Input.getInt();

            switch(choice)
            {
                case 1: 
                if (staff.getCreatedCamps().size() <= 0) {
                    System.out.println("You haven't created any camps yet");
                    break;
                }
                    System.out.println("Which camp's details would you like to view? (1 - " + staff.getCreatedCamps().size() + ")");
                    viewer.viewYourCamps();
                    campChoice = Input.getInt(staff.getCreatedCamps().size());
                    if (campChoice == -1) break;
                    viewer.viewCampDetails(staff.getCreatedCamps().get(campChoice - 1));
                    break;

                    case 2: 
                	filter.filterCamps(Camp.campList, true);
//                    viewer.viewAllCamps();
                    break;

                case 3:
                	filter.filterCamps(staff.getCreatedCamps(), true);
//                    viewer.viewYourCamps();
                    break;

                case 4:
                    System.out.println("Returning to Menu");
                    Time.pause(2);
                    break;

                default:
                    System.out.println("Please enter a valid input");
            }
        } while(choice != 4);
    }

    public void manageEnquiries()
    {

        StaffCampViewer viewer = new StaffCampViewer(staff);
        StaffEnquiryManager enquiryManager = new StaffEnquiryManager(staff);
        int campChoice = 0;
        int enquiryChoice = 0;
        int choice = 3; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Enquiries");
            System.out.println("2. Submit Response/Edit Response");
            System.out.println("3. Exit");
            choice = Input.getInt();

            switch(choice)
            {
                case 1: 
                    enquiryManager.viewEnquiries();
                    break;

                case 2: 
                    if(staff.getCreatedCamps().size() == 0)
                    {
                        System.out.println("There aren't any camps under your purview.");
                        break;
                    }
                    if (!enquiryManager.hasEnquires()){
                        System.out.println("None of your camps have any enquiries!");
                        break;
                    }
                    System.out.println("To which camp would you like to submit an enquiry response? (1 - " + staff.getCreatedCamps().size() + ")");
                    viewer.viewYourCamps();
                    campChoice = Input.getInt(staff.getCreatedCamps().size());
                    if (campChoice == -1) break;
                    System.out.println("Which enquiry would you like to respond to? (1 - " + staff.getCreatedCamps().get(campChoice - 1).getEnquiries().size() + ")");
                    enquiryManager.viewEnquiries(staff.getCreatedCamps().get(campChoice - 1));
                    enquiryChoice = Input.getInt(staff.getCreatedCamps().get(campChoice - 1).getEnquiries().size());
                    if (enquiryChoice == -1) break;
                    System.out.println("What is your response?");
                    String response = sc.nextLine();
                    enquiryManager.editEnquiry(staff.getCreatedCamps().get(campChoice - 1).getEnquiries().get(enquiryChoice - 1), response);
                    break;

                case 3:
                    System.out.println("Returning to Menu");
                    Time.pause(2);
                    break;

                default:
                    System.out.println("Please enter a valid input");
            }
        } while(choice != 3);
    }

    public void manageSuggestions()
    {

        StaffCampViewer viewer = new StaffCampViewer(staff);
        StaffSuggestionManager suggestionManager = new StaffSuggestionManager(staff);
        int campChoice = 0;
        int suggestionChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View All Suggestions");
            System.out.println("2. Approve Suggestions");
            System.out.println("3. View Approved Suggestions");
            //Possible Delete Suggestion Mechanism to be Implemented if they have approved and proceeded with the suggestion.
            System.out.println("4. Exit");
            choice = Input.getInt();

            switch(choice)
            {
                case 1: 
                    suggestionManager.viewSuggestions();
                    break;

                case 2: 
                    if(staff.getCreatedCamps().size() == 0)
                    {
                        System.out.println("There aren't any camps under your purview.");
                        break;
                    }
                    if (!suggestionManager.hasSuggestions()){
                        System.out.println("None of your camps have any suggestions!");
                        break;
                    }
                    System.out.println("Which camp's suggestions would you like to look at? (1 - " + staff.getCreatedCamps().size() + ")");
                    viewer.viewYourCamps();
                    campChoice = Input.getInt(staff.getCreatedCamps().size());
                    if (campChoice == -1) break;
                    System.out.println("Which suggestion would you like to approve? (1 - " + staff.getCreatedCamps().get(campChoice - 1).getSuggestions().size() + ")");
                    suggestionManager.viewSuggestions(staff.getCreatedCamps().get(campChoice - 1));
                    suggestionChoice = Input.getInt(staff.getCreatedCamps().get(campChoice - 1).getSuggestions().size());
                    if (suggestionChoice == -1) break;
                    if(suggestionManager.isApproved(staff.getCreatedCamps().get(campChoice - 1).getSuggestions().get(suggestionChoice - 1)))
                    {
                        System.out.println("This suggestion has already been approved.");
                        break;
                    }
                    suggestionManager.approveSuggestion(staff.getCreatedCamps().get(campChoice - 1).getSuggestions().get(suggestionChoice - 1));
                    break;

                case 3:
                    suggestionManager.viewApprovedSuggestions();
                    break;

                case 4:
                    System.out.println("Returning to Menu...");
                    Time.pause(2);
                    break;

                default:
                    System.out.println("Please enter a valid input");

            }
        } while(choice != 4);
    }

    public void reportGeneration() {
        StaffCampViewer viewer = new StaffCampViewer(staff); // Assuming 'staff' is the current Staff object
        StaffEnquiryManager enquiryManager = new StaffEnquiryManager(staff);
        ReportGenerator reportGenerator = new ReportGenerator(); // Assuming this is how you instantiate ReportGenerator
        int choice = 4;
        do {
            System.out.println("\nSelect the report you want to generate:");
            System.out.println("1. Generate Camp Report");
            System.out.println("2. Generate Performance Report for Committee Member");
            System.out.println("3. Generate Enquiry Report");
            System.out.println("4. Exit");
            choice = Input.getInt();
    
            switch (choice) {
                case 1:
                    // Display the list of camps
                    System.out.println("Select a camp to generate its report:");
                    viewer.viewYourCamps();
                    ArrayList<Camp> createdCamps = staff.getCreatedCamps();

                    // Check if there are any created camps
                    if (createdCamps.isEmpty()) {
                        System.out.println("No camps have been created.");
                        break;
                    }
        
                    // Taking user input for camp selection
                    int campIndex = Input.getInt();
                    // Adjusting campIndex to match array indexing (if necessary)
                    
                    // Check if the campIndex is valid
                    if (campIndex < 1 || campIndex > createdCamps.size()) {
                        System.out.println("Invalid camp selection.");
                        break;
                    }
        
                    // Retrieving the selected camp
                    Camp selectedCamp = createdCamps.get(campIndex - 1);

                    // Generate the camp report
                    reportGenerator.generateCampReport(selectedCamp);
                    break;

                case 2:
                    List<Student> committeeMembers = Camp.getAllCommitteeMembers();
                        // Check if there are any committee members
                    if (committeeMembers.isEmpty()) {
                        System.out.println("There are no committee members.");
                        break;
                    }
                    reportGenerator.generatePerformanceReport(committeeMembers);
                    break;

                case 3:
                    if (!enquiryManager.hasEnquires()) {
                        System.out.println("No enquiries have been created.");
                        break;
                    }
                    else
                    {
                        reportGenerator.generateEnquiryReport(enquiryManager.getEnquiries());
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting report generation module.");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (choice != 4);
    }
}
