import java.util.*;

public class Staff extends User
{
    Scanner sc = new Scanner(System.in);

    private ArrayList<Camp> createdCamps;
    private ArrayList<Suggestion> approvedSuggestions;

    public Staff(String name, String email, String faculty)
    {
        super(name, email, faculty);
        createdCamps = new ArrayList<Camp>();
        approvedSuggestions = new ArrayList<Suggestion>();
    }

    public ArrayList<Camp> getCreatedCamps()
    {
        return createdCamps;
    }

    public ArrayList<Suggestion> getApprovedSuggestions()
    {
        return approvedSuggestions;
    }

    
}
