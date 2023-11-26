import java.util.ArrayList;


public class Student extends User
{
    private String role;
    protected boolean committeeMember;
    protected ArrayList<Camp> registeredCamps;
    protected ArrayList<Enquiry> enquiries;
	protected ArrayList<Suggestion> suggestions;
	protected PointsManager pointsManager;
	protected Camp campCommMemberOf = null;
	protected ArrayList<Camp> visitedCamps;

	public Student(String name, String email, String faculty) 
	{
		super(name, email, faculty);
		this.role = "Attendee"; // Default role is "Attendee"
		this.committeeMember = false; // Default is false
		this.registeredCamps = new ArrayList<Camp>();
		this.enquiries = new ArrayList<Enquiry>();
		this.suggestions = new ArrayList<Suggestion>();
		this.visitedCamps = new ArrayList<Camp>();
		this.pointsManager = new PointsManager();
	}
	public ArrayList<Camp> getVisitedCamps(){
		return this.visitedCamps;
	}
	
    public String getRole() 
    {
        return this.role;
    }

    public void setRole(String role) 
    {
        this.role = role;
    }

	public void setCommMember(boolean committeeMember)
	{
		this.committeeMember = committeeMember;
	}

	public boolean getCommMember()
	{
		return committeeMember;
	}
    
    public ArrayList<Camp> getRegisteredCamps()
    {
    	return this.registeredCamps;
    }
	public Camp getCampCommMemberOf() {
		return campCommMemberOf;
	}
	public void setCampCommMemberOf(Camp camp){
		this.campCommMemberOf = camp;
	}

	

	// Method to manage inquiries related to a camp
    public ArrayList<Enquiry> getEnquiries()
    {
    	return enquiries;
    }

	public ArrayList<Suggestion> getSuggestions()
	{
		return suggestions;
	}
	
    // Method to register for a camp
    public void registerForCamp(Camp camp, String role) 
    {
    	if (camp == null)//check for non-existent camp
    	{
    		System.out.println("Camp do not exist");
    		return;
    	}
    	
    	if (camp.getTotSlots() - camp.getCurrentSlots() == 0) //check for empty slots
    	{
            System.out.println("This camp is already full. Registration is closed.");
            return;
    	}
    	
    	if ((camp.getList()).contains(this)) //check for previous registration
    	{
    		System.out.println("Unable to register for a camp you withdrawn");
    		return;
    	}
    	
    	if (camp.isPastRegistrationDeadline()) //check if registration is passed the deadline
    	{
            System.out.println("Registration deadline for this camp has passed.");
            return;
        }
        
        for (Camp registeredCamp : registeredCamps)
        {
            if (camp.hasDateClash(registeredCamp)) //check for date clashes with other camps
            {
                System.out.println("You have a date clash with another camp.");
                return;
            }
            if (registeredCamp.equals(camp)) //check if registering for the same camp
            {
                System.out.println("You are already registered for this camp.");
                return;
            }
        }
    	if (role.equals("Attendee")) 
    	{
    		registeredCamps.add(camp);
    		camp.assignRole(this, role);
    	}
    	else if (role.equals("committee"))
    	{
    		if (!this.committeeMember)
    		{
    			registeredCamps.add(camp);
    			committeeMember = true;
    			camp.assignRole(this, role);
    		}
    		else
    		{
    			System.out.println("Every Student can only be a committee member of one camp");
    			return;
    		}
    	}
    	else // check for invalid roles
    	{
    		System.out.println("Enter a valid role");
    		return;
    	}
    	
        registeredCamps.add(camp);
        camp.addAttendee(this);
        System.out.println("Successfully registered for the '" + camp.getName() + "' camp.");
    }

    // Method to withdraw from a camp
    public void withdrawFromCamp(Camp camp) 
    {
        if (registeredCamps.contains(camp)) 
        {
            registeredCamps.remove(camp);
            camp.removeAttendee(this);
            System.out.println("Withdrew from the '" + camp.getName() + "' camp.");
        } else 
        {
            System.out.println("You are not registered for the '" + camp.getName() + "' camp.");
        }
    }
	
	public int getPoints() {
        return this.pointsManager.getPoints();
    }

}

