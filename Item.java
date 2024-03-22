import java.time.LocalDate;
import java.util.Date;

public class Item {
    private static Integer counter = 0;

    private Integer Id;

    private String Title;

    protected Date Invdate;


    protected int setID(){
        this.Id = counter++;
        return this.Id;
    }

    protected String Title(){
        return Title;
    }

    protected Date InvDate(){
        return Invdate;
    }

    protected Item(){
        this.Id = 0;
        this.Title = "Unkown";
        this.InvDate = "yyyy,mm,dd";
    }

    protected Item(int ID, String Title, Date Invdate ) throws Exception{


    }

}
