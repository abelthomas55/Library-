import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Item {
    private static Integer counter = 0;

    private Integer Id;

    private String title;

    private LocalDate Invdate;

    private static final DateTimeFormatter formatter = DateTimeFormatter. ofPattern("MM-dd-yyyy");

    protected Item(){
        this.Id = 0;
        this.title = "Unkown";
        this.Invdate = LocalDate.parse("MM-dd-yyyy");
    }

    public void setDate(String Invdate) throws Exception {
        try {
            this.Invdate = LocalDate.parse(Invdate, Item.formatter);

        } catch(Exception e){
            throw new Exception("Invalid date! Must be MM-DD-YYYY");
        }
    }
    public String getDateString(){
        return this.Invdate.format(Item.formatter);
    }

    protected int setID(){
        this.Id = counter++;
        return this.Id;
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


}
