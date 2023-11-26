
import java.util.Scanner;
public class StudentProfile {

	Scanner sc = new Scanner(System.in);
	private Student student;
	
	public StudentProfile(Student student) {
		this.student = student;
	}
	
	void updateProfile() {
		System.out.println("\nUpdate Profile:");
		System.out.println("(1) Update Name");
		System.out.println("(2) Update Faculty");
		System.out.println("(3) Update Registered Camps");
		System.out.println("Enter your options");
		
		int choice = Input.getInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("Update Name: ");
			System.out.println("Enter New Name:");
			student.setName(sc.next());
			break;
			
		case 2:
			System.out.println("Update Faculty: ");
			System.out.println("Enter New Faculty:");
			student.setFaculty(sc.next());
			break;
			
		case 3:
			System.out.println("Update Registered Camps");
			System.out.println("(1) Add Camps");
			System.out.println("(2) Remove Camps");
			System.out.println("Enter your choice:");
			break;
			//Dont know if needed
			
		default:
			break;
			}
		}
				
	
	
	void viewProfile() {
		
		System.out.println("\nProfile:");
		if (student.getCommMember()){
			System.out.println("Camp Committee Member of " + student.getCampCommMemberOf().getName());
		}
		System.out.println("Name: " + student.getName());
		System.out.println("Faculty: " + student.getFaculty());
		System.out.println("Registered Camps: " + Camp.getNameFromCamps(student.getRegisteredCamps(), student));
		System.out.println("End of Profile");
	}
}
