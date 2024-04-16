package src.library.inventory;

public class Book extends Item implements CheckInOut {

    private String author;
    private BookGenre genre;
    private boolean checkedOut;

    public Book(String title, String invdate) throws Exception {
        super(title, invdate);
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
    public void checkOut() throws Exception {
        if (this.checkedOut)
            throw new Exception("Already checked out!");
        else
            this.checkedOut = true;
    }

    @Override
    public void checkIn() throws Exception {
        if (!this.checkedOut)
            throw new Exception("Not checked out!");
        else
            this.checkedOut = false;
    }

    @Override
    public void displayItem(){
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("%-15s %-15s\n", author, genre);

    }

}

