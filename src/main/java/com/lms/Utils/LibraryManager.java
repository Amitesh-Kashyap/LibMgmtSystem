package LibMgmtSystem.src.main.java.com.lms.Utils;

import LibMgmtSystem.src.main.java.com.lms.Database.Data;
import LibMgmtSystem.src.main.java.com.lms.Service.Menu;

public class LibraryManager
{
    private static Data db;

    public void borrow_book(String bookID , String UserID)
    {
        int index = db.searchBook(bookID);
        if(index > -1)
        {
            if(db.getBooks().get(index).Isborrowed() == true)
            {
                System.out.println("Book is already borrowed");
            }
            else
            {
                db.getBooks().get(index).setIsborrowed(true);
                db.getBooks().get(index).setBorrowed_by(UserID);
                System.out.println("Book with ID : "+bookID+" is borrowed successfully by UserID : "+UserID);
            }
        }
        else
            System.out.println("Book not available");
        
    }

    public void return_book(String bookID , String UserID)
    {
        int index = db.searchBook(bookID);
        if(index > -1)
        {
            if(db.getBooks().get(index).Isborrowed() == true && db.getBooks().get(index).getBorrowed_by().equals(UserID))
            {
                System.out.println("Book successfully returned");
                db.getBooks().get(index).setIsborrowed(false);
                db.getBooks().get(index).setBorrowed_by("");
            }
            else if(db.getBooks().get(index).Isborrowed() == false)
            {
                System.out.println("Book with ID : "+bookID+" was never issued!");
            }
            else
            {
                System.out.println("Book with ID : "+bookID+" was never borrowed by UserID : "+UserID);
            }
            
        }

    }

    public static void main(String[] args)
    {
        db = new Data(/* Initialize krne ke liye data pass karna hoga through script*/);
        // Here call all the functions required
        // Menu throw

        LibraryManager manager = new LibraryManager();
        // Implement the upload function
        Menu menu = new Menu();
        menu.displayMainMenu(db);
    }
}