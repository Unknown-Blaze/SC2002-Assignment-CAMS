public class Enquiry {
    private String question;
    private String response; // This field holds the reply from the committee member/staff member.
    private Student postedBy; // Assuming 'Student' is a class representing students.
    private String campName;
    private Camp camp;

    public Enquiry(String question, Student postedBy, Camp camp) {
        this.question = question;
        this.postedBy = postedBy;
        this.campName = camp.getName();
        this.camp = camp;
        this.response = "N/A"; // Initially, there's no response until a committee member/staff member replies.
    }

    // Getter and Setter methods
    public String getCampName() {
        return campName;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getResponse() {
        return response;
    }

    public Student getPostedBy() {
        return postedBy;
    }

    // If you need to get the Camp object directly, add this method
    public Camp getCamp() {
        return this.camp;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
