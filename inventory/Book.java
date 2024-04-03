
package inventory;

public class Book extends Item {

    private String author;
    private String bookGenre;

    public Book(String title, String invdate) throws Exception {
        super(title, invdate);
    }

    public Book(String title, String invdate, String author, BookGenre bookGenre) throws Exception {
        super(title, invdate);
        setAuthor(author);
        setBookGenre(bookGenre);
    }

    public void setAuthor(String author) throws Exception{
        author = author.trim();
        author = author.substring(0,1).toUpperCase() + author.substring(1);
        this.author = author;
    }

    public String getAuthor() {
        return author;

    }

    public void setBookGenre(BookGenre bookGenre) throws Exception{
        this.bookGenre = String.valueOf(bookGenre);
    }

    public String getBookgenre() {
        return bookGenre;
    }
    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf("%-15s %-15s\n", author, bookGenre);

    }

}

