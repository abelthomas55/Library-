import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Item {
    private static Integer counter = 0;

    private Integer Id;

    private String Title;

    private LocalDate Invdate;

    protected Item(){
        this.Id = 0;
        this.Title = "Unkown";
        this.Invdate = LocalDate.parse("MM-dd-yyyy");
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter. ofPattern("MM-dd-yyyy");

    public String getDateString(){
        return this.Invdate.format(Item.formatter);
    }

public void setDate(String Invdate) throws Exception {
    try {
        this.Invdate = LocalDate.parse(Invdate, Item.formatter);

    } catch(Exception e){
        throw new Exception("Invalid date! Must be MM-DD-YYYY");
    }
}

    protected int setID(){
        this.Id = counter++;
        return this.Id;
    }

    protected String Title(){
        return Title;
    }


    protected Item(){
        this.Id = 0;
        this.Title = "Unkown";
        this.InvDate = "yyyy,mm,dd";
    }

    protected Item(int ID, String Title, Date Invdate ) throws Exception{


    }

}
