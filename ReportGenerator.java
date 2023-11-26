//package a2002Assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReportGenerator {
    public void generateCampReport(Camp camp) {
        try (FileWriter writer = new FileWriter(camp.getName() + "_report.txt")) {
            writer.write("Camp Report for: " + camp.getName() + "\n");
            writer.write("Open Date: " + camp.getOpenDate() + "\n");
            writer.write("Close Date: " + camp.getCloseDate() + "\n");
            writer.write("Faculty: " + camp.getSchool() + "\n");
            writer.write("Location " + camp.getLocation() + "\n");
            writer.write("Total Slots: " + camp.getTotSlots() + "\n");
            writer.write("Remaining Slots: " + camp.getAvailableSlots() + "\n");
            writer.write("Committee Slots: " + camp.getCommSlots() + "\n");
            writer.write("Description: " + camp.getDesc() + "\n\n");
            for(int i = 0; i < camp.getList().size(); i++)
            {
                writer.write("Student " + i+1 + ": " + camp.getList().get(i).getName() + ", ");
                writer.write("Role: " + camp.getList().get(i).getRole() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generatePerformanceReport(List<Student> members) {
        try (FileWriter writer = new FileWriter("Camp_Committee_Performance_Report.txt")) {
            for(int i = 0; i < members.size(); i++)
            {
                writer.write("Performance Report for: " + members.get(i).getName() + "\n");
                writer.write("Committee Member of Camp: " + members.get(i).getCampCommMemberOf().getName() + "\n");
                writer.write("Points: " + members.get(i).getPoints() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateEnquiryReport(List<Enquiry> enquiries) //Added this feature.
    {
        try (FileWriter writer = new FileWriter("Enquiry_Report.txt")) {
            for(Enquiry e: enquiries)
            {
                writer.write("Question: " + e.getQuestion() + "\n");
                writer.write("Response: " + e.getResponse() + "\n");
                writer.write("Student: " + e.getPostedBy().getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
