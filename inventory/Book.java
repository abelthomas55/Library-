
package inventory;

public class Book extends Item implements CheckInOut {

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

    public Book(int id,String title, String invdate, String author, BookGenre bookGenre) throws Exception {
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

   public boolean setCheckedOut(boolean b){
        this.checkOut();
       return false;
    }


    @Override
    public void checkIn() {
        if(!isCheckedOut()){
            System.out.println("This book is available to be Checked Out");
        }
        else {
            isCheckedOut();
        }

        }



    @Override
    public boolean checkOut(){
        if (isCheckedOut()) {
            System.out.println("This book has been checked out.");
        }
        else {
            isCheckedOut();
        }
        return false;
    }
    @Override
    public boolean isCheckedOut(){
        boolean bookCheckout = true;
        return bookCheckout;
    }

    @Override
    public void displayItem(){
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("%-15s %-15s\n", author, bookGenre);

    }

}

