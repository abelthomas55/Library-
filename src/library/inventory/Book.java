package src.library.inventory;

import src.library.app.Input;

public class Book extends Item implements CheckInOut {

    private String author;
    private BookGenre genre;
    private boolean checkedOut;


    public Book(String title, String invdate) throws Exception {
        super(title,
                invdate,
                description);
    }
    public Book(String title, String invdate, String author, BookGenre bookGenre) throws Exception {
        super(title, invdate);
        setAuthor(author);
        setBookGenre(bookGenre);
        this.checkedOut = false;
    }

    public Book(int id,String title, String invdate, String author, BookGenre bookGenre) throws Exception {
        super(title, invdate);
        setAuthor(author);
        setBookGenre(bookGenre);
        this.checkedOut = false;
    }

    public String getAuthor() {
        return author;

    }

    public void setAuthor(String author) throws Exception{
        author = author.trim();
        author = author.substring(0,1).toUpperCase() + author.substring(1);
        this.author = author;
    }

    public void setBookGenre(BookGenre genre) throws Exception{
        this.genre = genre;
    }

    public BookGenre getBookgenre() {
        return this.genre;
    }

    @Override
    public boolean isCheckedOut(){
        return checkedOut;
    }

    @Override
    public void checkOut(){
        if (this.checkedOut)
            System.out.println("Cannot check out a book that is already checked out.");
        else
            System.out.println("The Book has been checked out.");
            this.checkedOut = true;
    }

    @Override
    public void checkIn(){
        if (!this.checkedOut)
            System.out.println("Cannot check in a book that isn't already checked out.");
        else
            System.out.println("The Book has been checked in.");
            this.checkedOut = false;
    }

    @Override
    public void displayItem(){
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("%-15s %-15s\n", author, genre);

    }

}

