package LibMgmtSystem.src.main.java.com.lms.Security;

public class Passwords
{
    // Implement more security in here

    public static boolean check_Passkey(String passkey)
    {
        
        if(passkey.equals("$admin$"))
            return true;
        return false;
    }
    
}
