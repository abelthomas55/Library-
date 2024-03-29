//import inventory.Book;
//import inventory.Cd;
import inventory.Dvd;
import inventory.Item;
import inventory.Moviegenre;

public class Library {
    public static void main(String[] args) throws Exception {
        Item myItem = new Item("abc", "05-29-2024");
        System.out.println(myItem);
        Dvd myDvd = new Dvd("Lol" , "05-02-2024" , "Testdir", Moviegenre.ACTION);
        System.out.println(myItem);
    }
}
