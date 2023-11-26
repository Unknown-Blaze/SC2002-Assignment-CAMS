
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.List;


public class Camp
{
    public static ArrayList<Camp> campList;
    private String name;
    private Date openDate;
    private Date closeDate;
    private Date regClose;
    private String school;
    private String location;
    private int totSlots;
    private int commSlots;
    private String desc;
    private String nameOfStaff;
    private boolean visibility;
    private ArrayList<Student> studentList;
    private int currentSlots;
    private Date now = new Date();
    private HashMap<Student, String> rolesMap = new HashMap<>();
    private int numCommitteeMembers; 
    private ArrayList<Enquiry> enquiries;
    private ArrayList<Suggestion> suggestions;

    public Camp(String name, Date openDate, Date closeDate, Date regClose, String school, String location, int totSlots, int commSlots, String desc, String nameOfStaff)
    {
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.regClose = regClose;
        this.school = school;
        this.location = location;
        this.totSlots = totSlots;
        this.commSlots = commSlots;
        this.desc = desc;
        this.nameOfStaff = nameOfStaff;
        this.visibility = true;
        studentList = new ArrayList<Student>();
        this.currentSlots = 0;
        this.numCommitteeMembers = 0;
        this.enquiries = new ArrayList<>();
        this.suggestions = new ArrayList<>();
    }

    public static ArrayList<String> getNameFromCamps(ArrayList<Camp> registeredCamps, Student student){
		ArrayList<String> stringCampList = new ArrayList<String>();

		for (Camp c : student.getRegisteredCamps()){
			for (Student s : c.getRolesMap().keySet()){
                if (student.getName() == s.getName())
				    stringCampList.add(c.getName() + ": " + c.getRolesMap().get(s));
			}
		}
		return stringCampList;
	}

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOpenDate(Date openDate)
    {
        this.openDate = openDate;
    }

    public void setCloseDate(Date closeDate)
    {
        this.closeDate = closeDate;
    }

    public void setRegDate(Date regClose)
    {
        this.regClose = regClose;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setTotSlots(int totSlots)
    {
        this.totSlots = totSlots;
    }

    public void setCommSlots(int commSlots)
    {
        this.commSlots = commSlots;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setVisibility(int visibility)
    {
        if(visibility == 1) 
            this.visibility = true;
        else 
            this.visibility = false;
    }

    public String getName()
    {
        return this.name;
    }
    
    public Date getOpenDate()
    {
        return this.openDate;
    }
    
    public Date getCloseDate()
    {
        return this.closeDate;
    }
    
    public Date getRegDate()
    {
        return this.regClose;
    }

    public String getSchool()
    {
        return this.school;
    }

    public String getLocation()
    {
        return this.location;
    }

    public int getTotSlots()
    {
        return this.totSlots;
    }

    public int getCommSlots()
    {
        return this.commSlots;
    }

    public String getStaffName()
    {
        return this.nameOfStaff;
    }
    
    public String getDesc()
    {
        return this.desc;
    }

    public ArrayList<Student> getList()
    {
        return this.studentList;
    }

    public int getCurrentSlots() //Returns # of occupied slots by all members.
    {
    	return this.currentSlots;
    }

    public int getCommMembers()
    {
        return this.numCommitteeMembers;
    }

    public void addAttendee(Student student) 
	{
        if (this.hasAvailableSlots()) { // Only add if there's an available slot.
            this.getList().add(student);
            this.currentSlots++;
        }
        else {
            // Handle the case when there are no available slots.
            System.out.println("Cannot add member: no available slots."); 
        }
    }

    public void removeAttendee(Student student) 
	{
		this.getList().remove(student);
		this.currentSlots--;
	}

	public boolean isPastRegistrationDeadline() 
	{
		if (now.after(this.getCloseDate())) return true;
		return false;
	}

	public boolean hasDateClash(Camp camp) 
	{
		if(!(this.getOpenDate().after(camp.getCloseDate())||camp.getOpenDate().after(this.getCloseDate()))) return true;// have date clash
		else return false;
	}
	
	// Method to assign roles to students within the camp
    public void assignRole(Student student, String role) 
    {
        rolesMap.put(student, role);
    }
    
    // Method to retrieve the role of a specific student in the camp
    public String getRoleOfStudent(Student student) 
    {
        return rolesMap.get(student);
    }

    public HashMap<Student, String> getRolesMap(){
        return rolesMap;
    }

    public boolean hasAvailableSlots() {
        // Check if the current slots filled (including committee members) are less than the total available slots.
        return this.getCurrentSlots() + this.getCommMembers() < this.getTotSlots();
    }
    
    // Method to add a committee member to the camp
    public void addCommitteeMember(Student committeeMember) {
        if (this.getAvailableCommitteeSlots() > 0) { // Only add if there's an available slot.
            this.studentList.add(committeeMember);
            this.numCommitteeMembers++; // Increase the number of committee members.
        } else {
            // Handle the case when there are no available slots.
            System.out.println("Cannot add committee member: no available slots."); // 
        }
    }
    
    // Method to get the number of slots available for committee members.
    public int getAvailableCommitteeSlots() {
        return this.commSlots - this.numCommitteeMembers;
    }

    public int getTotalSlots() {
        return this.totSlots;
    }

    public int getAvailableSlots() {
        return this.totSlots - (this.currentSlots + this.numCommitteeMembers);
    }

    public int getOccupiedSlots() {
        return this.currentSlots + this.numCommitteeMembers;
    }

    // Method to add an enquiry
    public void addEnquiry(Enquiry enquiry) {
        this.enquiries.add(enquiry);
    }

    // Method to get all enquiries
    public List<Enquiry> getEnquiries() {
        return this.enquiries;
    }

    public ArrayList<Suggestion> getSuggestions()
    {
        return this.suggestions;
    }

	public boolean getVisibility() {
		return visibility;
	}

    // Method to get all committee members from all camps
    public static List<Student> getAllCommitteeMembers() {
        List<Student> committeeMembers = new ArrayList<>();

        for (Camp camp : Camp.campList) {
            for (Student student : camp.getList()) {
                if(student.getCommMember() && student.getCampCommMemberOf().getName() == camp.getName())
                {
                    committeeMembers.add(student);
                }
            }
        }
        return committeeMembers;
    }
}