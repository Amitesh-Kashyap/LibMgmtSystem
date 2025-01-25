package com.lms.Service;

import com.lms.Database.Data;

public class Login
{
    public static int ExistingUserLogin(Data db , String ID)
    {
        int index = db.searchUser(ID);
        if(index != -1)
        {
            if(index<db.getAdmins().size() && db.getAdmins().get(index).getID().equals(ID))
            {
                System.out.println("Wecome "+db.getAdmins().get(index).getName());
                return 1001;// For admins
            }
            else
            {
                System.out.println("Wecome "+db.getStudents().get(index).getName());
                System.out.println("Wecome "+"Whosoever" +db.getStudents().get(index).getID()+db.getStudents().get(index).getName());
                return 2002;// For students
            }
        }
        return -1;
    } 
    
}