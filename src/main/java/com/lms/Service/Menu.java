package com.lms.Service;

import java.util.Scanner;

import com.lms.Database.Data;

public class Menu
{

    public void displayFunctions(int role)
    {
        if(role == 1001)
        {
            while(true)
            {
                System.out.println("Select what to you want to do :-\n1. Add Student\n2. Remove Student\n3. Add Book\n4. Remove Book\n5. View Students Database\n6. Fun with uploading file");
                int choice = new Scanner(System.in).nextInt();
                if(choice > 6 || choice < 1)
                {
                    System.out.println("\n Wrong Inputs! Try again!");
                    continue;
                }
                else if(choice == 1)
                {

                }
                else if(choice == 2)
                {

                }
                else if(choice == 3)
                {

                }
                else if(choice == 4)
                {

                }
                else if(choice == 5)
                {

                }
                else
                {

                }
            }

            
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
        System.out.println("\n---------------- Welcome to Library Management System ---------------------\n");
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
                            System.out.println("\nWelcome Admin! Here are the list of functionalities you get : ");
                        }
                        else if(role == 2002)
                        {
                            System.out.println("\nWelcome Student! Here are the list of functionalities you get : ");
                        }
                        else
                        {
                            System.out.println("\nInvalid UserID\n");
                        }
                        displayFunctions(role);
                        if(role!=-1)    break;
                    }while(true); 
                    System.out.println("\n--------------------- Returning to Main Menu ------------------\n");
                    break;
                    case 3:
                    System.out.println("\nBye! Visit Again!");
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
