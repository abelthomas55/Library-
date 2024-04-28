package src.library.inventory;

import src.library.app.Input;
/**
 * The Book class represents a book item in the library inventory.
 * It extends the Item class and implements the CheckInOut interface.
 */
public class Book extends Item implements CheckInOut {

    private String author; // The Author of the book
    private BookGenre genre; // The genre of the book
    private boolean checkedOut;// To check whether the book is checked out of not

    /**
     * Constructs a Book object with the given title, inventory date, and description.
     * @param title The title of the book.
     * @param invdate The inventory date of the book.
     * @param description The description of the book.
     * @throws Exception If an error occurs during construction.
     */
    public Book(String title, String invdate, String description) throws Exception {
        super(title, invdate, description);
    }
    /**
     * Constructs a Book object with the given title, inventory date, description, author, and genre.
     * @param title The title of the book.
     * @param invdate The inventory date of the book.
     * @param description The description of the book.
     * @param author The author of the book.
     * @param bookGenre The genre of the book.
     * @throws Exception If an error occurs during construction.
     */
    public Book(String title, String invdate, String description, String author, BookGenre bookGenre) throws Exception {
        super(title, invdate, description);
        setAuthor(author);
        setBookGenre(bookGenre);
        this.checkedOut = false;
    }
    /**
     * Constructs a Book object with the given id, title, inventory date, description, author, and genre.
     * @param id The id of the book.
     * @param title The title of the book.
     * @param invdate The inventory date of the book.
     * @param description The description of the book.
     * @param author The author of the book.
     * @param bookGenre The genre of the book.
     * @throws Exception If an error occurs during construction.
     */
    public Book(int id,String title, String invdate, String description, String author, BookGenre bookGenre) throws Exception {
        super(id, title, invdate, description);
        setAuthor(author);
        setBookGenre(bookGenre);
        this.checkedOut = false;
    }
    /**
     * Gets the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;

    }
    /**
     * Sets the author of the book.
     * @param author The author of the book.
     * @throws Exception If an error occurs during setting the author.
     */
    public void setAuthor(String author) throws Exception{
        author = author.trim();
        author = author.substring(0,1).toUpperCase() + author.substring(1);
        this.author = author;
    }
    /**
     * Sets the genre of the book.
     * @param genre The genre of the book.
     * @throws Exception If an error occurs during setting the genre.
     */
    public void setBookGenre(BookGenre genre) throws Exception{
        this.genre = genre;
    }
    /**
     * Gets the genre of the book.
     * @return The genre of the book.
     */
    public BookGenre getBookgenre() {
        return this.genre;
    }

    /**
     * Checks if the book is checked out.
     * @return True if the book is checked out, false otherwise.
     */
    @Override
    public boolean isCheckedOut(){
        return checkedOut;
    }

    /**
     * Checks out the book.
     */
    @Override
    public void checkOut(){
        if (this.checkedOut)
            System.out.println("Cannot check out a book that is already checked out.");
        else
            System.out.println("The Book has been checked out.");
            this.checkedOut = true;
    }
    /**
     * Checks in the book.
     */
    @Override
    public void checkIn(){
        if (!this.checkedOut)
            System.out.println("Cannot check in a book that isn't already checked out.");
        else
            System.out.println("The Book has been checked in.");
            this.checkedOut = false;
    }
    /**
     * Displays the details of the book.
     */
    @Override
    public void displayItem(){
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("%-15s %-15s\n", author, genre);

    }

}

