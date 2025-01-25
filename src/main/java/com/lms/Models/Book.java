package com.lms.Models;

public class Book
{
    private String bookId;
    private String title;
    private String author;
    private boolean available_or_not;
    private boolean isborrowed;
    private String Borrowed_by;


    // private String publisher;
    // private String publicationDate;
    // private String isbn;
    // private String edition;
    // private String category;

    public Book(String bookId, String title, String author, String publisher, String publicationDate, String isbn, String edition, String category){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        available_or_not = true;
        isborrowed = false;
        Borrowed_by = null;
    }

    public void setAvailability(boolean availability)
    {
        available_or_not = availability;
    }

    public boolean isAvailable()
    {
        return available_or_not;
    }

    public boolean Isborrowed() {
        return this.isborrowed;
    }

    public void setIsborrowed(boolean isborrowed) {
        this.isborrowed = isborrowed;
    }

    public String getBorrowed_by() {
        return this.Borrowed_by;
    }

    public void setBorrowed_by(String Borrowed_by) {
        this.Borrowed_by = Borrowed_by;
    }
}
