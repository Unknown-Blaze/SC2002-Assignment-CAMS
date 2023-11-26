import java.util.*;
public class StaffEnquiryManager implements EnquiryManager {
    private Staff staff;

    public StaffEnquiryManager(Staff staff) {
        this.staff = staff;
    }

    public void viewEnquiries()
    {
        for(Camp camp: staff.getCreatedCamps())
        {
            for(Enquiry e: camp.getEnquiries())
            {
                System.out.println("\nQuestion: " + e.getQuestion());
                System.out.println("Response: " + e.getResponse());
                System.out.println("Student: " + e.getPostedBy().getName());
            }
        }
    }

    public void viewEnquiries(Camp camp)
    {
        for(Enquiry e: camp.getEnquiries())
        {
            System.out.println("\nQuestion: " + e.getQuestion());
            System.out.println("Response: " + e.getResponse());
            System.out.println("Student: " + e.getPostedBy().getName());
        }
    }

    public ArrayList<Enquiry> getEnquiries()
    {
        ArrayList<Enquiry> enquiries = new ArrayList<Enquiry>();
        for(Camp camp: staff.getCreatedCamps())
        {
            for(Enquiry e: camp.getEnquiries())
            {
                enquiries.add(e);
            }
        }
        return enquiries;
    }

    public boolean hasEnquires(){

        for (int i = 0; i < staff.getCreatedCamps().size(); i++){
            if (staff.getCreatedCamps().get(i).getEnquiries().size() > 0){
                return true;
            }
        }
        return false;
    }

    public boolean hasEnquires(Camp camp){

        if (camp.getEnquiries().size() > 0){
                return true;
            }
        return false;
    }

    public void editEnquiry(Enquiry enquiry, String response)
    {
        enquiry.setResponse(response);
    }
}
