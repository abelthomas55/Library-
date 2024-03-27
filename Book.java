import java.time.LocalDate;
public class Book extends Item {

    private  String author;
    private String Bookgenre;
public Book(String title, String Invdate) {
    super(title, Invdate);
}
public Book(String title, String Invdate, String author, String Bookgenre){
    super(title, Invdate);
    this.author= author;
    this.Bookgenre= Bookgenre;

}
public String getAuthor(){
    return author;

}
public String getgenre{}
    return Bookgenre;
}
public void setauthor{
    this.author =author;
}
public void setgenre{
    this.Bookgenre = new Bookgenre;
        }
Public enum Bookgenre{
    FICTION,
    NON_FICTION,
    MYSTERY,
    ROMANCE,
    SCIENCE_FICTION,
    FANTASY,
    HORROR,
    THRILLER,
    BIOGRAPHY,
    HISTORY,
    POETRY
}

