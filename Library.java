//import inventory.Book;
//import inventory.Cd;
import inventory.*;

public class Library {
    public static void main(String[] args) throws Exception {
        Item myItem = new Item("abc", "05-29-2024");
        System.out.println(myItem);
        Dvd myDvd = new Dvd("Testtitle", "01-01-2024", "testDir",Moviegenre.ACTION);
        myDvd.displayDvd();
        Dvd myDvd2 = new Dvd("test2", "01-02-2024", "TestDir2", Moviegenre.COMEDY);
        myDvd2.displayDvd();
        Cd myCd = new Cd("testCd", "01-03-2024", "TestArtist", Musicgenre.RAP);
        myCd.displayCd();
        Book myBook = new Book("TetsBtitle", "01-04-2024", "TestAuthor", Bookgenre.FICTION);
        myBook.displayBook();
    }
}
