package LibMgmtSystem.src.main.java.com.lms.Service;

import java.util.Scanner;

import LibMgmtSystem.src.main.java.com.lms.Database.Data;
import LibMgmtSystem.src.main.java.com.lms.Models.Admin;
import LibMgmtSystem.src.main.java.com.lms.Models.Student;
import LibMgmtSystem.src.main.java.com.lms.Security.Generate;
import LibMgmtSystem.src.main.java.com.lms.Security.Passwords;

public class Register
{
    public static void NewUserRegistration(Data db , Scanner sc)
    {
        System.out.print("Enter your name : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter which role you want to apply for!\n\n**If registering as Admin - Keep Passkey handy!\n\n1 - Admin\nOther - Student\nYour choice : ");
        int role = sc.nextInt();
        if(role == 1)
        {
            // ID must be generated if he has the proper passkey
            do
            {
                System.out.print("Enter the passkey given only to admins : ");
                String passkey = sc.next();
                if(Passwords.check_Passkey(passkey))
                {
                    String generated_ID = Generate.generate_ID();
                    Admin ob = new Admin(name , generated_ID);
                    System.out.println("Admin succesfully registered!\nRemember this ID for future all-time logins : " + generated_ID);
                    db.addUser(ob);
                    break;
                }
                else
                {
                    System.out.println("Wrong Passkey! Are you really an admin? Try again.");
                }
            }
            while(true);
        }
        else
        {
            String generated_ID = Generate.generate_ID();
            Student ob = new Student(name, generated_ID);
            db.addUser(ob);
            System.out.println("Student succesfully registered!\nRemember this ID for future all-time logins : " + generated_ID);
        }
    }
    
    
}
