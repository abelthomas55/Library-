import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Item {
    private static Integer counter = 0;

    private Integer Id;

    private String title;

    private LocalDate invDate;

    private static final DateTimeFormatter formatter = DateTimeFormatter. ofPattern("MM-dd-yyyy");

    protected Item(String title, String invDate) throws Exception {
        this.Id = Item.counter++;
        setTitle(title);
        setDate(String.valueOf(invDate));
    }

    public void setDate(String invDate) throws Exception {
        try {
            this.invDate = LocalDate.parse(invDate, Item.formatter);

        } catch(Exception e){
            throw new Exception("Invalid date! Must be MM-DD-YYYY");
        }
    }
    public String getDate(){
        return this.invDate.format(Item.formatter);
    }

    public Integer getId(){
        return Id;
    }


    public void setTitle(String title) throws Exception {
        title = title.trim();
        if(title.isEmpty())
            throw new Exception("Title cannot be blank.");

        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString(){
        return "Id: " + this.Id + ", Title: " + this.title + ", Date: " + this.invDate;
    }

}
