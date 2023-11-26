import java.util.*;
public class CampCommEnquiryManager implements EnquiryManager {
    private CampCommitteeMember commMember;

    public CampCommEnquiryManager(CampCommitteeMember commMember) {
        this.commMember = commMember;
    }

    public void viewEnquiries()
    {
        if (commMember.getCamp().getEnquiries().size() == 0){
            System.out.println("No enquiries!");
            return;
        }
        for(Enquiry e: commMember.getCamp().getEnquiries())
        {
            if(!e.getPostedBy().getName().equals(commMember.getName()))
            {
                System.out.println("\nQuestion: " + e.getQuestion());
                System.out.println("Response: " + e.getResponse());
                System.out.println("Student: " + e.getPostedBy().getName());
            }
        }
    }

    public ArrayList<Enquiry> getEnquiries() //Added this feature.
    {
        ArrayList<Enquiry> enquiries = new ArrayList<Enquiry>();
        for(Enquiry e: commMember.getEnquiries())
        {
            enquiries.add(e);
        }
        return enquiries;
    }

    public void editEnquiry(Enquiry enquiry, String response)
    {
        enquiry.setResponse(response);
        commMember.pointsManager.addPoint();
    }
}
