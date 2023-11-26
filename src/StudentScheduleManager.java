import java.util.ArrayList;

public class StudentScheduleManager {
	
	ArrayList<Camp> registeredCamps;

	public StudentScheduleManager() {
		
	}
	
	void checkForScheduleConflicts(Camp camp) {
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
	}
	
	void getStudentSchedule() {
		for (Camp registeredCamp : registeredCamps) 
		{
			System.out.println("Camp " + registeredCamp.getName() + "  Open date: " + registeredCamp.getOpenDate() + "  Close date: " + registeredCamp.getCloseDate());
		}
	}
}
