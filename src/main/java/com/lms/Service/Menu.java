package LibMgmtSystem.src.main.java.com.lms.Service;

import java.util.Scanner;

import LibMgmtSystem.src.main.java.com.lms.Database.Data;

public class Menu
{

    public void displayFunctions(int role)
    {
        if(role == 1001)
        {
            System.out.println("Select what to you want to do :-\n1. Add Student\n2. Remove Student\n3. Add Book\n4. Remove Book\n5. View Students Database\n6. Fun with uploading file");
        }
        else if(role == 2002)
        {
            System.out.println("Select what to you want to do :-\n1. Search Book\n2. View Books Database\n3. Borrow Book\n4. Return Book");
        }
        else
            return;
    }

    public void displayMainMenu(Data db)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Library Management System");
        while(true)
        {
            System.out.print("Press :\n1 - New User\n2 - Login\n3 - Exit\nEnter choice : ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    Register.NewUserRegistration(db , sc);
                    System.out.println("\n--------------------- Returning to Main Menu ------------------\n");
                    break;                    
                case 2:
                    do
                    {
                        System.out.print("Enter UserID given to you at time of registration : ");
                        String id = sc.next();
                        int role = Login.ExistingUserLogin(db , id);
                        if(role == 1001)
                        {
                            System.out.println("Welcome Admin! Here are the list of functionalities you get : ");
                        }
                        else if(role == 2002)
                        {
                            System.out.println("Welcome Student! Here are the list of functionalities you get : ");
                        }
                        else
                        {
                            System.out.println("Invalid UserID");
                        }
                        displayFunctions(role);
                        if(role!=-1)    break;
                        System.out.println("\n\n");
                    }while(true); 
                    System.out.println("\n--------------------- Returning to Main Menu ------------------\n");
                    break;
                    case 3:
                    System.out.println("Bye! Visit Again!");
                    System.out.println("\n--------------------- Returning to Main Menu ------------------\n");
                    break;
                    default:
                    System.out.println("Wrong Inputs!");
                    System.out.println("\n--------------------- Returning to Main Menu ------------------\n");
                    continue;
            }
            if(choice == 3)
                break;
        }
        sc.close();
    }    
}
