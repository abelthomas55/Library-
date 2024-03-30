//import inventory.Book;
//import inventory.Cd;
//import inventory.*;

//public class Library {
//    public static void main(String[] args) throws Exception {
//        Item myItem = new Item("abc", "05-29-2024");
//        System.out.println(myItem);
//        Dvd myDvd = new Dvd("Testtitle", "01-01-2024", "testDir",Moviegenre.ACTION);
//        myDvd.displayDvd();
//        Dvd myDvd2 = new Dvd("test2", "01-02-2024", "TestDir2", Moviegenre.COMEDY);
//        myDvd2.displayDvd();
//        Cd myCd = new Cd("testCd", "01-03-2024", "TestArtist", Musicgenre.RAP);
//        myCd.displayCd();
//        Book myBook = new Book("TetsBtitle", "01-04-2024", "TestAuthor", Bookgenre.FICTION);
//        myBook.displayBook();
//    }

package library.app;
import inventory.Book;
import inventory.BookGenre;
import inventory.Item;
import java.util.ArrayList;
import java.util.List;
/**
 * Library App that allows adding, deleting, displaying, saving, and loading
 inventory for Books, CDs, and DVDs.
 * <a href="PUT_YOUR_URL_HERE">GitHub Repository URL</a>
 *
 * @author PUT_YOUR_NAMES_HERE
 * @since PUT_THE_CURRENT_DATE_HERE
 * @version 1.0 beta
 *
 */
public class Library {
    /**
     * Standard double dash line.
     */
    private final static String DOUBLE_LINE =
            "==========================================================";
    /**
     * Standard single dash line.
     */
    private final static String SINGLE_LINE =
            "---------------------------------------------------------";
    /**
     * List to store all types of inventory items (Book, Cd, Dvd).
     */
    private List<Item> inventory;
    /**
     * Default constructor instantiates the ArrayList for storing items.
     */
    public Library(){
        this.inventory = new ArrayList<Item>();
    } // end of constructor
    /**
     * Display the program's title.
     */
    private void displayAppHeading() {
        System.out.println(DOUBLE_LINE);
        System.out.println("Welcome to the Library App");
        System.out.println(DOUBLE_LINE);
    } // end of displayAppHeading method
    /**
     * Allows the user to enter an inventory id to be deleted.
     */
    private void deleteItem(){
        int id = 0;
        System.out.println("Delete Inventory");
        System.out.println(SINGLE_LINE);
        id = Input.getInt("Please enter the inventory id: ");
        for (Item item : inventory){
            System.out.println(id);
            if (item.getId() == id){
                inventory.remove(item);
                System.out.println("Successful Delete: " + item);
                Input.getLine("Press enter to continue...");
                return;
            }
        }
        System.out.println("ERROR: Inventory ID:" + id + " NOT found!");
    } // end of deleteItem method
    /**
     * Add a book to the Library's inventory. Allows the user to enter the book's
     author and genre.
     *
     * @param title The item's title.
     * @param dateReceived The item's date received into inventory.
     * @param description The item's description which is not a required field.
     * @return The newly created book.
     * @throws Exception Any exception thrown to addBook will be back to the
    calling method.
     */
    private Book addBook(String title, String dateReceived, String description)
            throws Exception {
        Book book;
        int userInput = 0;
        String author = null;
        BookGenre genre = null;
        author = Input.getString("Author: ");
        try {
            userInput = Input.getIntRange("Genre 1=Fiction, 2= Non-Fiction, 3=Mystery, 4= Romance, 5= Science Fiction:
                    ", 1, 5);
                    genre = BookGenre.values()[userInput - 1];
        } catch (Exception e){
            throw new Exception("Invalid data! Book Genre = " + genre);
        }
        book = new Book(title, dateReceived, author, genre);
        return book;
    } // end of addBook method
    /**
     * Add an item to inventory. Allow's the user to enter the item's title,
     description,
     * date received into inventory and then will call the appropriate item's type
     (Book, CD, DVD) for additional
     * user's input.
     * @throws Exception All exceptions will be thrown back to the main menu for
    handling.
     */
    private void addItem() throws Exception {
        String title = null;
        String dateReceived = null;
        int inventoryType = 0;
        System.out.println("Add Inventory");
        System.out.println(SINGLE_LINE);
        System.out.println("Please enter the following inventory information:");
        title = Input.getString("Title: ");
        dateReceived = Input.getDate("Date Received (MM-DD-YYYY): ");
        inventoryType = Input.getIntRange("Type 1=Book, 2=CD, 3=DVD: ", 1, 3);
        switch(inventoryType){
            case 1:
                Book book = addBook(title, dateReceived,);
                inventory.add(book);
                System.out.println("Successful Add: " + book);
                Input.getLine("Press enter to continue...");
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                throw new Exception("Invalid Input! Inventory Type = " +
                        inventoryType);
        } // end of switch
    } // end of addItem method
    /**
     * Display the Library's inventory's detail group by inventory type.
     */
    private void displayInventory(){
        System.out.println("Book Inventory");
        System.out.println(SINGLE_LINE);
        System.out.println("ID Title Date Rec'd Author Genre");
        System.out.println("--- --------------- ---------- ---------------
                ----------");
        for (Item item : inventory) {
            if (item instanceof Book){
                item.displayItem();
            }
        }
        System.out.println();
//TO-DO: ADD LOGIC FOR DISPLAYING OTHER INVENTORY TYPES
        Input.getLine("Press enter to continue...");
    } // end of displayInventory
    /**
     * The main menu that allows the user to add, delete, display, load, and save
     inventory.
     * @throws Exception All exceptions will be displayed or thrown back to the
    main method.
     */
    private void mainMenu() throws Exception {
        boolean keepRunning = true;
        int userInput = 0;
        while (keepRunning) {
            System.out.println(SINGLE_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_LINE);
            System.out.println("0 = End Game");
            System.out.println("1 = Add Item");
            System.out.println("2 = Delete Item");
            System.out.println("3 = Display Inventory");
            System.out.println("4 = Save Inventory");
            System.out.println("5 = Load Inventory");
            System.out.println(SINGLE_LINE);
            userInput = Input.getIntRange("Menu Choice: ", 0, 6);
            System.out.println(SINGLE_LINE);
            switch (userInput) {
                case 0:
                    keepRunning = false;
                    break;
                case 1:
                    try {
                        this.addItem();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        Input.getLine("Press enter to continue...");
                    }
                    break;
                case 2:
                    try {
                        this.deleteItem();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        Input.getLine("Press enter to continue...");
                    }
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    throw new Exception("Invalid menu choice: " + userInput);
            } // end of switch
        } // end of while loop
    } // end of mainMenu
    /**
     * Main method to keep the Library App running
     * @param args Not used
     * @throws Exception Any type of exceptions thrown back to main will be
    displayed and end the program.
     */
    public static void main(String[] args) throws Exception {
        library.app.Library app = new library.app.Library();
        app.displayAppHeading();
        try {
            app.mainMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please
                    contact Princess Debbie!");
        }
        Input.sc.close();
    } // end of main method
} // end of LibraryApp class