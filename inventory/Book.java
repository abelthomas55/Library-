
package inventory;

public class Book extends Item {

    private String author;
    private String bookGenre;

    public Book(String title, String invdate) throws Exception {
        super(title, invdate);
    }

    public Book(String title, String invdate, String author, Bookgenre bookGenre) throws Exception {
        super(title, invdate);
        setAuthor(author);
        setBookGenre(bookGenre);
    }

    public void setAuthor(String author) throws Exception{
        this.author = author;
    }

    public String getAuthor() {
        return author;

    }

    public void setBookGenre(Bookgenre bookGenre) throws Exception{
        this.bookGenre = String.valueOf(bookGenre);
    }

    public String getBookgenre() {
        return bookGenre;
    }

    public void displayBook(){
        super.displayItem();
        System.out.printf("  %-15s %-10s\n", author, bookGenre);

    }

}

