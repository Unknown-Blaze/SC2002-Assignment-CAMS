public interface EnquiryManager
{
    //Student - View their Own Enquiries
    //Staff - View Enquiries for their Camps
    public void viewEnquiries();

    //Student - Submit their Question (can be used for editing)
    //Staff - Submit their Response (can be used for editing)
    public void editEnquiry(Enquiry enquiry, String response);
}