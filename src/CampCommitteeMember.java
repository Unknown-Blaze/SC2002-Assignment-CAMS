import java.util.ArrayList;

public class CampCommitteeMember extends Student {
    private Camp camp;
    //private ArrayList<Suggestion> suggestions;
    //private PointsManager pointsManager;
    //private ArrayList<Camp> registeredCamps;
    //private ArrayList<Enquiry> enquiries;
    public CampCommitteeMember(String name, String email, String faculty, Camp camp, ArrayList<Camp> registeredCamps, 
    ArrayList<Enquiry> enquiries, ArrayList<Suggestion> suggestions, String password, ArrayList<Camp> visitedCamps, PointsManager pointsManager) {
        super(name, email, faculty);
        this.pointsManager = pointsManager;
        this.camp = camp;
        this.registeredCamps = registeredCamps;
        this.enquiries = enquiries;
        this.suggestions = suggestions;
        this.password = password;
        this.campCommMemberOf = camp;
        this.committeeMember = true;
        this.visitedCamps  = visitedCamps;
        
    }

    /*public ArrayList<Suggestion> getSuggestions()
    {
        return this.suggestions;
    }*/

    public Camp getCamp()
    {
        return this.camp;
    }
}
