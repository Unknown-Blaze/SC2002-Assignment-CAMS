import java.util.ArrayList;

abstract public class User {
	private String name;
	private String email;
    protected String password = "password";
    private String faculty;
    private boolean firstTimeLogin;
    
    public User(String name, String email, String faculty) 
    {
    	this.name = name;
    	this.email = email;
    	this.faculty = faculty;
        this.firstTimeLogin = true;
    } 
    
    public String getName() 
    {
        return this.name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public String getPassword()
    {
    	return this.password;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getFaculty() 
    {
        return this.faculty;
    }

    public void setFaculty(String faculty) 
    {
        this.faculty = faculty;
    }

    public boolean getFirstTimeLogin(){
        return this.firstTimeLogin;
    }

    public void setFirstTimeLogin(boolean isFirst){
        this.firstTimeLogin = isFirst;
    }
    
    public void viewCamps(ArrayList<Camp> campList)
    {
        for(int i = 0; i < campList.size(); i++)
        {
            System.out.println(campList.get(i));
        }
    }
}
