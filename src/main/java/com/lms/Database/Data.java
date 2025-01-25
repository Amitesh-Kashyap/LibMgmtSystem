package com.lms.Database;

import java.util.ArrayList;

import com.lms.Models.Admin;
import com.lms.Models.Book;
import com.lms.Models.Student;


public class Data
{
    private ArrayList<Admin> admins;
    private ArrayList<Student> students;
    private ArrayList<Book> books;

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Data()
    {
        admins = new ArrayList<Admin>();
        students = new ArrayList<Student>();
        books = new ArrayList<Book>();
    }

    public int searchUser(String ID)
    {
        for(int i = 0 ; i<admins.size() ; i++)
        {
            if(admins.get(i).getID().equals(ID) && admins.get(i).getDeleted() == false)
            {
                return i;
            }
        }
        for(int i = 0 ; i < students.size() ; i++)
        {
            if(students.get(i).getID().equals(ID) && students.get(i).getDeleted() == false)
            {
                return i;
            }
        }
        return -1;
    }

    public void addUser(Object user)
    {
        if(user instanceof Admin)
        {
            getAdmins().add((Admin)user);
        }
        else if(user instanceof Student)
        {
            getStudents().add((Student)user);
        }
    }

    public void removeUser(String ID)
    {
        int does_exist = searchUser(ID);
        if(does_exist == -1)
            System.out.println("User does not exist");
        else if(does_exist >= 0)
        {
            // Might be admin or student
            // How to know which one?
            if(does_exist < admins.size() && admins.get(does_exist).getID().equals(ID))
                admins.get(does_exist).setDeleted(false);
            else
                students.get(does_exist).setDeleted(false);
        }
    }

    public void addBook(Book b , String User_ID)
    {
        // Feature of Admins only
        int index = searchUser(User_ID);
        if(index < admins.size() && admins.get(index).getID().equals(User_ID) )
            books.add(b);
        else
            System.out.println("Entered ID : "+User_ID+" does not belong to an admin");

    }

    @SuppressWarnings("unlikely-arg-type")
    public int searchBook(String bookID)
    {
        int index = books.indexOf(bookID);
        if(index != -1 && books.get(index).isAvailable() == true)
            return index;
        return -1;
    }
    
    public void deleteBook(String User_ID , String bookID)
    {
        // Features of Admins only
        int index = searchUser(User_ID);
        if(index < admins.size() && admins.get(index).getID().equals(User_ID) )
        {
            // Search for the book
            int book_index = searchBook(bookID);
            if(book_index != -1)
                books.get(book_index).setAvailability(false);
            else
                System.out.println("Book not available");
        }
        else
            System.out.println("Entered ID : "+User_ID+" does not belong to an admin");

    }
    
}
