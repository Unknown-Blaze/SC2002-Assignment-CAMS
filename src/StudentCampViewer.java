//package a2002Assignment;

import java.util.*;

public class StudentCampViewer implements CampViewerInterface{
    private Student student;

    public StudentCampViewer(Student student) {
        this.student = student;
    }

    public void viewCampDetails(Camp camp) {
        System.out.println("Camp Details for: " + camp.getName());
        System.out.println("Open Date: " + camp.getOpenDate());
        System.out.println("Close Date: " + camp.getCloseDate());
        System.out.println("Faculty: " + camp.getSchool());
        System.out.println("Location " + camp.getLocation());
        System.out.println("Total Slots: " + camp.getTotalSlots());
        System.out.println("Remaining Slots: " + camp.getAvailableSlots());
        System.out.println("Name of Staff: " + camp.getStaffName());
        System.out.println("Description: " + camp.getDesc());
        // More details can be added as needed
    }

    public void viewAllCamps() //Only able to view camps under his/her school. (Distinguishing it from the Staff View)
    {
        for(Camp camp: Camp.campList)
        {
            //If the student is under that particular school and visibility is on.
            if((camp.getSchool().equals(student.getFaculty()) || camp.getSchool().equals("NTU")) && camp.getVisibility() == true)
            {
                System.out.println("Camp Name: " + camp.getName());
                System.out.println("Remaining Slots: " + camp.getAvailableSlots());
            }
        }
    }

    public ArrayList<Camp> viewAvailableCamps(String school) //Returns list of camps associated with a particular school or NTU.
    {
        ArrayList<Camp> schoolCamps = new ArrayList<Camp>();
        for(Camp camp: Camp.campList)
        {
            if(camp.getSchool().equals(school) || camp.getSchool().equals("NTU"))
                schoolCamps.add(camp);
        }
        return schoolCamps;
    }

    public void viewYourCamps() {
        System.out.println("Registered Camps:");
        ArrayList<String> list = Camp.getNameFromCamps(student.getRegisteredCamps(), student);
        for (String s : list){
            System.out.println(s);
        }
    }
}
