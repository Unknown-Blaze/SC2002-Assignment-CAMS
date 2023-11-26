public class StaffSuggestionManager implements SuggestionManager {
    private Staff staff;

    public StaffSuggestionManager(Staff staff) {
        this.staff = staff;
    }

    public void viewSuggestions()
    {
        for(Camp camp: staff.getCreatedCamps())
        {
            for(Suggestion s: camp.getSuggestions())
            {
                System.out.println("\nSuggestion: " + s.getSuggestion());
                System.out.println("Camp Committee Member: " + s.getPostedBy().getName());
            }
        }
    }

    public void viewSuggestions(Camp camp)
    {
        for(Suggestion s: camp.getSuggestions())
        {
            System.out.println("\nSuggestion: " + s.getSuggestion());
            System.out.println("Camp Committee Member: " + s.getPostedBy().getName());
        }
    }

    public boolean hasSuggestions(){

        for (int i = 0; i < staff.getCreatedCamps().size(); i++){
            if (staff.getCreatedCamps().get(i).getSuggestions().size() > 0){
                return true;
            }
        }
        return false;
    }

    public boolean hasSuggestions(Camp camp){

        if (camp.getSuggestions().size() > 0){
                return true;
            }
        return false;
    }

    public void approveSuggestion(Suggestion s)
    {
        s.setApproval(1);
        staff.getApprovedSuggestions().add(s);
        s.getPostedBy().pointsManager.addPoint();
    }

    public boolean isApproved(Suggestion s)
    {
        if(s.getApproval())
            return true;
        else
            return false;
    }

    public void viewApprovedSuggestions()
    {
        for(Suggestion s: staff.getApprovedSuggestions())
        {
            System.out.println("\nSuggestion: " + s.getSuggestion());
            System.out.println("Camp Committee Member: " + s.getPostedBy().getName());
        }
    }
}