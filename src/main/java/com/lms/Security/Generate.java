package LibMgmtSystem.src.main.java.com.lms.Security;

import java.util.Random;

public class Generate
{
    public static String generate_ID()
    {
        Random random = new Random();
        StringBuilder hexID = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int hexNumber = random.nextInt(16);
            hexID.append(Integer.toHexString(hexNumber));
        }

        return hexID.toString().toUpperCase();
    }
    
}
