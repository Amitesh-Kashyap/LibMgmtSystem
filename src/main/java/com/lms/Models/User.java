package LibMgmtSystem.src.main.java.com.lms.Models;

public abstract class User
{
    private String name;
    private String ID;
    private boolean isdeleted;
    // private boolean password; // Future implementation
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDeleted(boolean value)
    {
        isdeleted = value;
    }

    public boolean getDeleted()
    {
        return isdeleted;
    }

    public void displayInfo()
    {
        System.out.println("User Info Display");
    }

    public abstract void getRole(); // This is the method that will be implemented by the subclasses
}