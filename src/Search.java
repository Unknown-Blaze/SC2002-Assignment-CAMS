public class Search extends Initialize{
    public static Student searchStudent(String username){
        for (int i = 0; i < studentDetails.size(); i++){
            if (Getter.getusername(studentDetails.get(i)).equalsIgnoreCase(username)) return studentDetails.get(i); 
        }
        return null;
    }
    public static Staff searchStaff(String username){
        for (int i = 0; i < staffDetails.size(); i++){
            if (Getter.getusername(staffDetails.get(i)).equalsIgnoreCase(username)) return staffDetails.get(i); 
        }
        return null;
    }
}
