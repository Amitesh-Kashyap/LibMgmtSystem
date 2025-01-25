package com.lms.Models;

public class Student extends User
{
    public void getRole()
    {
        System.out.println("User");
    }
    
    public Student(String name , String ID)
    {
        setName(name);
        setID(ID);
        setDeleted(false);
    }
}
