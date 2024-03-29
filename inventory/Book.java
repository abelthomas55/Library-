
package inventory;

public class Book extends Item {

    private String author;
    private String bookgenre;

    public Book(String title, String invdate) throws Exception {
        super(title, invdate);
    }

    public Book(String title, String invdate, String author, String bookgenre) {
        super(title, invdate, author, bookgenre);
        this.author = author;
        this.bookgenre = bookgenre;
    }

    public String getAuthor() {
        return author;

    }

    public String getgenre() {
        return bookgenre;
    }

    public void setauthor(){
        this.author = author;
    }

    public void setgenre(String bookgenre){
        this.bookgenre =  bookgenre;
    }
    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf("%-15s %-10s\n", author, bookgenre);

    }

}

