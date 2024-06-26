package src.library.app;

import src.library.inventory.Book;
import src.library.inventory.BookGenre;
import src.library.inventory.Item;
import src.library.inventory.Cd;
import src.library.inventory.CdGenre;
import src.library.inventory.Dvd;
import src.library.inventory.DvdGenre;
import src.library.app.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * library.app.Library App that allows adding, deleting, displaying, saving, and loading
 * inventory for Books, CDs, and DVDs.
 * <a href="https://github.com/abelthomas55/Library-">GitHub Repository URL</a>
 *
 * @author Hunter Schoch Abel Thomas
 * @version 1.0 beta
 * @since 4/2/2024
 */
public class LibraryApp {
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
     * List to store all types of inventory items (library.inventory.Book, library.inventory.Cd, library.inventory.Dvd).
     */
    private List<Item> inventory;

    /**
     * Default constructor instantiates the ArrayList for storing items.
     */
    public LibraryApp() {
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
    private void deleteItem() {
        int id = 0;
        System.out.println("Delete Inventory");
        System.out.println(SINGLE_LINE);
        for (Item item : inventory) {
            System.out.println(item);
        }
        id = Input.getInt("Please enter the inventory id: ");
        for (Item item : inventory) {
            if (item.getId() == id) {
                inventory.remove(item);
                System.out.println("Successful Delete: " + item);
                Input.getLine("Press enter to continue...");
                return;
            }
        }
        System.out.println("ERROR: Inventory ID:" + id + " NOT found!");
    } // end of deleteItem method

    /**
     * Add a book to the library.app.Library's inventory. Allows the user to enter the book's
     * author and genre.
     *
     * @param title        The item's title.
     * @param dateReceived The item's date received into inventory.
     * @return The newly created book.
     * @throws Exception Any exception thrown to addBook will be back to the
     *                   calling method.
     */
    private Book addBook(String title, String dateReceived, String description) throws Exception {
        Book book;
        int userInput = 0;
        String author = null;
        BookGenre genre = null;

        author = Input.getString("Author: ");

        try {
            userInput = Input.getIntRange("Genre 1=Fiction, 2= Non-Fiction, 3=Mystery, 4= Romance, 5= Science Fiction: ", 1, 5);
                    genre = BookGenre.values()[userInput - 1];
        } catch (Exception e) {
            throw new Exception("Invalid data! Book Genre = " + genre);
        }
        book = new Book(title, dateReceived, description, author, genre);
        return book;

    } // end of addBook method

    /**
     * Add a book to the library.app.Library's inventory. Allows the user to enter the book's
     * author and genre.
     *
     * @param title        The item's title.
     * @param dateReceived The item's date received into inventory.
     * @return The newly created cd.
     * @throws Exception Any exception thrown to addCd will be back to the
     *                   calling method.
     */
    private Cd addCd(String title, String dateReceived, String description) throws Exception {
        Cd cd;
        int userInput = 0;
        String artist = null;
        CdGenre genre = null;

        artist = Input.getString("Artist: ");

        try {
            userInput = Input.getIntRange("Genre 1=Rock, 2=Pop, 3=Hip Hop, 4=Jazz, 5=Country: ", 1, 5);
            genre = CdGenre.values()[userInput - 1];
        } catch (Exception e) {
            throw new Exception("Invalid data! Music Genre = " + genre);
        }
        cd = new Cd(title, dateReceived, description, artist, genre);
        return cd;

    } // end of library.inventory.Cd method

    /**
     * Add a book to the library.app.Library's inventory. Allows the user to enter the book's
     * author and genre.
     *
     * @param title        The item's title.
     * @param dateReceived The item's date received into inventory.
     * @return The newly created dvd.
     * @throws Exception Any exception thrown to addDvd will be back to the
     *                   calling method.
     */

    private Dvd addDvd(String title, String dateReceived, String description) throws Exception {
        Dvd dvd;
        int userInput = 0;
        String director = null;
        DvdGenre genre = null;

        director = Input.getString("Director: ");

        try {
            userInput = Input.getIntRange("Genre 1=Action, 2=Comedy, 3=Drama, 4=Horror, 5=Romance: ", 1, 5);
            genre = DvdGenre.values()[userInput - 1];
        } catch (Exception e) {
            throw new Exception("Invalid data! Movie Genre = " + genre);
        }
        dvd = new Dvd(title, dateReceived, description, director, genre);
        return dvd;

    } // end of library.inventory.Dvd method

    /**
     * Add an item to inventory. Allow's the user to enter the item's title,
     * description,
     * date received into inventory and then will call the appropriate item's type
     * (library.inventory.Book, CD, DVD) for additional
     * user's input.
     *
     * @throws Exception All exceptions will be thrown back to the main menu for
     *                   handling.
     */
    private void addItem() throws Exception {
        String title = null;
        String dateReceived = null;
        String description = null;
        int inventoryType = 0;
        System.out.println("Add Inventory");
        System.out.println(SINGLE_LINE);
        System.out.println("Please enter the following inventory information:");
        title = Input.getString("Title: ");
        dateReceived = Input.getDate("Date Received (MM-DD-YYYY): ");
        description = Input.getDescription("Description (Optional): ");
        inventoryType = Input.getIntRange("Type 1=Book, 2=CD, 3=DVD: ", 1, 3);
        switch (inventoryType) {
            case 1:
                Book book = addBook(title, dateReceived, description);
                inventory.add(book);
                System.out.println("Successful Add: " + book);
                Input.getLine("Press enter to continue...");
                break;
            case 2:
                Cd cd = addCd(title, dateReceived, description);
                inventory.add(cd);
                System.out.println("Successful Add: " + cd);
                Input.getLine("Press enter to continue...");
                break;
            case 3:
                Dvd dvd = addDvd(title, dateReceived, description);
                inventory.add(dvd);
                System.out.println("Successful Add: " + dvd);
                Input.getLine("Press enter to continue...");
                break;
            default:
                throw new Exception("Invalid Input! Inventory Type = " +
                        inventoryType);
        } // end of switch
    } // end of addItem method
    private void checkIn() throws Exception {
        int id = 0;
        System.out.println("Check in Inventory");
        System.out.println(SINGLE_LINE);

        id = Input.getInt("Please enter the inventory id: ");
        for (Item item : inventory) {
            if (item.getId() == id) {
                if( item instanceof Book){
                    Book book = (Book) item;
                    book.checkIn();
                    Input.getLine("Please enter to continue...");
                }
                if( item instanceof Cd){
                    Cd cd = (Cd) item;
                    cd.checkIn();
                    Input.getLine("Please enter to continue...");
                }
                if( item instanceof Dvd){
                    Dvd dvd = (Dvd) item;
                    dvd.checkIn();
                    Input.getLine("Please enter to continue...");
                }

                return;
            }
        }
        System.out.println("ERROR: Inventory ID:" + id + " NOT found!");
    } // end of CheckIn method
    private void checkOut() throws Exception {
        int id = 0;
        System.out.println("Checkout Inventory");
        System.out.println(SINGLE_LINE);

        id = Input.getInt("Please enter the inventory id: ");
        for (Item item : inventory) {
            if (item.getId() == id) {
                if( item instanceof Book){
                    Book book = (Book) item;
                    book.checkOut();
                    Input.getLine("Please enter to continue...");

                }
                if( item instanceof Cd){
                    Cd cd = (Cd) item;
                    cd.checkOut();
                    Input.getLine("Please enter to continue...");
                }
                if( item instanceof Dvd){
                    Dvd dvd = (Dvd) item;
                    dvd.checkOut();
                    Input.getLine("Please enter to continue...");
                }

                return;
            }
        }
        System.out.println("ERROR: Inventory ID:" + id + " NOT found!");
    } // end of CheckOut method
    /**
     * Display the library.app.Library's inventory's detail group by inventory type.
     */
    private void displayInventory() {
        System.out.println("Book Inventory");
        System.out.println(SINGLE_LINE);
        System.out.println("ID  Title           Date Rec'd Author          Genre");
        System.out.println("--- --------------- ---------- --------------- ---------------");
        for (Item item : inventory) {
            if (item instanceof Book) {
                item.displayItem();
            }
        }
        System.out.println();
        System.out.println("CD Inventory");
        System.out.println(SINGLE_LINE);
        System.out.println("ID  Title           Date Rec'd Artist          Genre");
        System.out.println("--- --------------- ---------- --------------- ---------------");
        for (Item item : inventory) {
            if (item instanceof Cd) {
                item.displayItem();
            }
        }
        System.out.println();
        System.out.println("DVD Inventory");
        System.out.println(SINGLE_LINE);
        System.out.println("ID  Title           Date Rec'd Director        Genre");
        System.out.println("--- --------------- ---------- --------------- ---------------");
        for (Item item : inventory) {
            if (item instanceof Dvd) {
                item.displayItem();
            }
        }
        System.out.println();
        Input.getLine("Press enter to continue...");
    } // end of displayInventory

    /**
     * The main menu that allows the user to add, delete, display, load, and save
     * inventory.
     *
     * @throws Exception All exceptions will be displayed or thrown back to the
     *                   main method.
     */
    private void mainMenu() throws Exception {
        boolean keepRunning = true;
        int userInput = 0;
        while (keepRunning) {
            System.out.println(SINGLE_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_LINE);
            System.out.println("0 = End Application");
            System.out.println("1 = Add Item");
            System.out.println("2 = Delete Item");
            System.out.println("3 = Display Inventory");
            System.out.println("4 = Save Inventory");
            System.out.println("5 = Load Inventory");
            System.out.println("6 = Check in Inventory");
            System.out.println("7 = Check out Inventory");
            System.out.println(SINGLE_LINE);
            userInput = Input.getIntRange("Menu Choice: ", 0, 8);
            System.out.println(SINGLE_LINE);
            switch (userInput) {
                case 0:
                    keepRunning = false;
                    break;
                case 1:
                    try {
                        this.addItem();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        Input.getLine("Press enter to continue...");
                    }
                    break;
                case 2:
                    try {
                        this.deleteItem();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        Input.getLine("Press enter to continue...");
                    }
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    saveInventory();
                    break;
                case 5:
                    readInventoryData();
                    break;
                case 6:
                    checkIn();
                    break;
                case 7:
                    checkOut();
                    break;

                default:
                    throw new Exception("Invalid menu choice: " + userInput);
            } // end of switch
        } // end of while loop
    } // end of mainMenu

    private void saveInventory(){
        //write to file
        System.out.println("Please wait while we save the library.");
        try{
            FileOutputStream writeData = new FileOutputStream("libraryData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(inventory);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("library.app.Library has been saved.");
    }
    private void readInventoryData() throws Exception {
        System.out.println("Please wait while we grab the library information.");

        inventory.clear();

        try{
            FileInputStream readData = new FileInputStream("libraryData.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            inventory = (ArrayList<Item>) readStream.readObject();
            readStream.close();
            System.out.println(inventory.toString());
            Item.setCounter(inventory.get(inventory.size()- 1).getId());
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("library.app.Library has been uploaded.");
    }


    /**
     * library.inventory.Main method to keep the library.app.Library App running
     *
     * @param args Not used
     * @throws Exception Any type of exceptions thrown back to main will be
     *                   displayed and end the program.
     */
    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.displayAppHeading();
        try {
            app.mainMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please, contact Hunter Schoch or Abel Thomas!");
        }
        Input.sc.close();
    } // end of main method
} // end of LibraryApp class