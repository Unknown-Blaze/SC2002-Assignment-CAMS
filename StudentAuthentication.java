import java.util.Scanner;

public class StudentAuthentication {
	
	Scanner sc = new Scanner(System.in);

	Student student;

	public StudentAuthentication(Student student) {
		this.student = student;
	}
	
	public void login() 
	{
		if ((student.getPassword()).equals("password")) 
		{
			System.out.println("Please reset your password");
			System.out.println("Enter new password");
			student.setPassword(sc.next());	
		}
		
		System.out.println("Welcome " + student.getName());
		System.out.println("Select your options");
		System.out.println("(1) Reset Password");
		System.out.println("(2) Change Password");
		System.out.println("(3) View Available Camps");
		System.out.println("(4) Register For Camp");
		System.out.println("(5) Withdraw From Camp");
		System.out.println("(6) View Enquiry");
		System.out.println("(7) Submit Enquiry");
		System.out.println("(8) Withdraw Enquriy");
		System.out.println("Enter your choice");
	}
	
	public void changePassword(String password) {
		student.setPassword(password);
	}
	
	public void resetPassword() {
		student.setPassword("password");
	}
}
