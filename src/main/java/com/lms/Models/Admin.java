package com.lms.Models;

public class Admin extends User
{
    public Admin(String name , String ID)
    {
        setName(name);
        setID(ID);
        setDeleted(false);
    }
    @Override
    public void getRole()
    {
        System.out.println("Admin");
    }  
        
}
