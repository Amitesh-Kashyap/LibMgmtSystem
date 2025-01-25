package com.lms.Service;

import java.util.Scanner;

import com.lms.Database.Data;
import com.lms.Models.Admin;
import com.lms.Models.Student;
import com.lms.Security.Generate;
import com.lms.Security.Passwords;

public class Register
{
    public static void NewUserRegistration(Data db , Scanner sc)
    {
        System.out.print("Enter your name : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("\nEnter which role you want to apply for!\n\n**If registering as Admin - Keep Passkey handy!\n\n1 - Admin\nOther - Student\n\nYour choice : ");
        int role = sc.nextInt();
        if(role == 1)
        {
            // ID must be generated if he has the proper passkey
            do
            {
                System.out.print("\nEnter the passkey given only to admins : ");
                String passkey = sc.next();
                if(Passwords.check_Passkey(passkey))
                {
                    String generated_ID = Generate.generate_ID();
                    Admin ob = new Admin(name , generated_ID);
                    System.out.println("\nAdmin succesfully registered!\nRemember this ID for future all-time logins : " + generated_ID);
                    db.addUser(ob);
                    break;
                }
                else
                {
                    System.out.println("\n!!! Wrong Passkey! Are you really an admin? Try again.\n");
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
