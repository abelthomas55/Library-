package src.library.inventory;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Item class represents an abstract item in the library inventory.
 * It implements the Serializable interface for serialization purposes.
 */
public abstract class Item implements Serializable {
    /**
     * The counter for generating unique IDs.
     */
    private static Integer counter = 0;
    /**
     * The unique ID of the item.
     */
    protected Integer id;
    /**
     * The title of the item.
     */
    protected String title;

    /**
     * The inventory date of the item.
     */
    protected LocalDate invDate;

    /**
     * The description of the item.
     */
    protected String description;
    /**
     * The formatter for parsing and formatting dates.
     */
    private static final DateTimeFormatter formatter = DateTimeFormatter. ofPattern("MM-dd-yyyy");

    /**
     * Constructs an Item object with the given title, inventory date, and description.
     * @param title The title of the item.
     * @param invDate The inventory date of the item.
     * @param description The description of the item.
     * @throws Exception If an error occurs during construction.
     */

    public Item(String title, String invDate , String description) throws Exception {
        this.id = ++Item.counter;
        setTitle(title);
        setInvDate(String.valueOf(invDate));
        setDescription(description);
    }
    /**
     * Constructs an Item object with the given id, title, inventory date, and description.
     * @param id The id of the item.
     * @param title The title of the item.
     * @param invDate The inventory date of the item.
     * @param description The description of the item.
     * @throws Exception If an error occurs during construction.
     */

    public Item(int id, String title, String invDate , String description) throws Exception {
        this.id = id;
        setTitle(title);
        setInvDate(String.valueOf(invDate));
        setDescription(description);
    }

    /**
     * Sets the inventory date of the item.
     * @param invDate The inventory date of the item in the format "MM-DD-YYYY".
     * @throws Exception If the date format is invalid.
     */
    public void setInvDate(String invDate) throws Exception {
        try {
            this.invDate = LocalDate.parse(invDate, Item.formatter);

        } catch(Exception e){
            throw new Exception("Invalid date! Must be MM-DD-YYYY");
        }
    }
    /**
     * Gets the inventory date of the item.
     * @return The inventory date of the item formatted as "MM-DD-YYYY".
     */
    public String getInvDate(){
        return this.invDate.format(Item.formatter);
    }

    public static void setCounter (int id){
        Item.counter = id;
    }
    public Integer getId(){
        return id;
    }

    /**
     * Sets the description of the item.
     * @param description The description of the item.
     */
    public void setDescription(String description){
       this.description = description;
    }

    /**
     * Sets the title of the item.
     * @param title The title of the item.
     * @throws Exception If the title is blank.
     */
    public void setTitle(String title) throws Exception {
        title = title.trim();
        title = title.substring(0,1).toUpperCase() + title.substring(1);
        if(title.isEmpty())
            throw new Exception("Title cannot be blank.");

        this.title = title;
    }
    /**
     * Gets the title of the item.
     * @return The title of the item.
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Gets the description of the item.
     * @return The description of the item.
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Returns a string representation of the item.
     * @return A string representation of the item.
     */
    @Override
    public String toString(){
        return "Id: " + this.id + ", Title: " + this.title + ", Date: " + this.invDate;
    }

    /**
     * Abstract method to display details of the item.
     */
    public abstract void displayItem();

}
