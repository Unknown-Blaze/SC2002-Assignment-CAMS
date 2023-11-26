import java.util.Scanner;

public class Main extends Login{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Login.createAllData(); //Uses the function in Initialize.java to invoke everything within the function
        boolean systemRunning = true;

        while(systemRunning)
        {
            if (!StudentController.justMadeComm){
                User user = login();
                while (!Password.inputPassword(user)){
                    login();
                }
            }else{
                System.out.println("You have been promoted to a Camp Committee Member!");
                StudentController.justMadeComm = false;
            }

            if(getType() == "student")
            {     
                Student student = (Student) LoginSuccess();
                if (!student.getCommMember()){
                    UserLoginManager.loginUser((User)student);
                    StudentControllerSwitch control = new StudentControllerSwitch(student);
                    System.out.println("Welcome "+ student.getName()+ "!");
                    control.main();
                }else{
                    CampCommitteeMember commMember = convertToCommitteeMember(student);
                    CampCommControllerSwitch control = new CampCommControllerSwitch(commMember);
                    System.out.println("Welcome "+ commMember.getName() + "!");
                    control.main();
                }
                
            }
            else if(getType() == "staff")
            {
                Staff staff = (Staff) LoginSuccess();
                UserLoginManager.loginUser((User)staff);
                StaffControllerSwitch control = new StaffControllerSwitch(staff);
                System.out.println("Welcome "+ staff.getName()+ "!");
                control.main();
            }
            if (!StudentController.justMadeComm){
                System.out.println("Do you want the system to continue running? (Y/N)");
                char choice = sc.next().toUpperCase().charAt(0);
                if(choice == 'N')
                    systemRunning = false;
            }
            
        }
    }
    static CampCommitteeMember convertToCommitteeMember(Student student){
        return new CampCommitteeMember(student.getName(), student.getEmail(),
                        student.getFaculty(), student.getCampCommMemberOf(), student.getRegisteredCamps(), student.getEnquiries(), student.getSuggestions(),
                        student.getPassword(), student.getVisitedCamps(), student.pointsManager);
    }
}