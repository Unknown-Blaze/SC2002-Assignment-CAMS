public class Suggestion 
{
    private String suggestion;
    private CampCommitteeMember postedBy;
    private String campName;
    private Camp camp;
    private boolean isApproved;

    public Suggestion(String suggestion, CampCommitteeMember postedBy, Camp camp)
    {
        this.suggestion = suggestion;
        this.postedBy = postedBy;
        this.campName = camp.getName();
        this.camp = camp;
    }

    // Getter and Setter methods
    public String getCampName() {
        return campName;
    }

    public String getSuggestion() {
        return this.suggestion;
    }

    public CampCommitteeMember getPostedBy() {
        return postedBy;
    }

    // If you need to get the Camp object directly, add this method
    public Camp getCamp() {
        return this.camp;
    }

    public boolean getApproval()
    {
        return this.isApproved;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public void setApproval(int approval)
    {
        if(approval == 1) 
            this.isApproved = true;
        else 
            this.isApproved = false;
    }
}
