
public class StudentEnquiryManager implements EnquiryManager {
    private Student student;

    public StudentEnquiryManager(Student student) {
        this.student = student;
    }

    public void viewEnquiries()
    {
        for(Enquiry e: student.getEnquiries())
        {
            System.out.println("\nQuestion: " + e.getQuestion());
            System.out.println("Response: " + e.getResponse());
            System.out.println("Student: " + e.getPostedBy().getName());
            System.out.println("Camp: " + e.getCampName());
        }
        
    }

    public void submitEnquiry(Camp camp, String question)
    {
        Enquiry e = new Enquiry(question, student, camp);
    	student.getEnquiries().add(e);
        camp.getEnquiries().add(e);
    }

    public void editEnquiry(Enquiry enquiry, String question)
    {
        enquiry.setQuestion(question);
    }

    public void deleteEnquiry(Enquiry enquiry)
    {
        student.getEnquiries().remove(enquiry);
        enquiry.getCamp().getEnquiries().remove(enquiry);
    }
}
