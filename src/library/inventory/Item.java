package src.library.inventory;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Item implements Serializable {
    private static Integer counter = 0;

    protected Integer id;

    protected String title;

    protected LocalDate invDate;

    protected String description;

    private static final DateTimeFormatter formatter = DateTimeFormatter. ofPattern("MM-dd-yyyy");

    public Item(String title, String invDate , String description) throws Exception {
        this.id = ++Item.counter;
        setTitle(title);
        setInvDate(String.valueOf(invDate));
        setDescription(description);
    }
    public Item(int id, String title, String invDate , String description) throws Exception {
        this.id = id;
        setTitle(title);
        setInvDate(String.valueOf(invDate));
        setDescription(description);
    }


    public void setInvDate(String invDate) throws Exception {
        try {
            this.invDate = LocalDate.parse(invDate, Item.formatter);

        } catch(Exception e){
            throw new Exception("Invalid date! Must be MM-DD-YYYY");
        }
    }
    public String getInvDate(){
        return this.invDate.format(Item.formatter);
    }

    public static void setCounter (int id){
        Item.counter = id;
    }
    public Integer getId(){
        return id;
    }

    public void setDescription(String description){
       this.description = description;
    }


    public void setTitle(String title) throws Exception {
        title = title.trim();
        title = title.substring(0,1).toUpperCase() + title.substring(1);
        if(title.isEmpty())
            throw new Exception("Title cannot be blank.");

        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }
    @Override
    public String toString(){
        return "Id: " + this.id + ", Title: " + this.title + ", Date: " + this.invDate;
    }


    public abstract void displayItem();

}
