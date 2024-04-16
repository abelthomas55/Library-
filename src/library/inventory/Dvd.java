package library.inventory;

public class Dvd extends Item implements CheckInOut{
    private String director;
    private DvdGenre genre;
    private boolean checkedOut;

    public Dvd(String title, String invdate) throws Exception {
        super(title, invdate);
        this.checkedOut = false;
    }

    public Dvd(String title, String invdate, String director, DvdGenre movieGenre) throws Exception {
        super(title,invdate);
        setDirector(director);
        setMovieGenre(movieGenre);
        this.checkedOut = false;
    }

    public void setDirector(String director) throws Exception{
        director = director.trim();
        director = director.substring(0,1).toUpperCase() + director.substring(1);
        this.director = director;
        this.checkedOut = false;
    }

    public String getDirector() {
        return director;

    }

    public void setMovieGenre(DvdGenre genre)throws Exception{
        this.genre = genre;
    }

    public DvdGenre getMovieGenre() {
        return this.genre;
    }

    @Override
    public boolean isCheckedOut(){
        return checkedOut;
    }

    @Override
    public void checkOut() throws Exception {
        if (this.checkedOut)
            throw new Exception("Already checked out!");
        else
            this.checkedOut = true;
    }

    @Override
    public void checkIn() throws Exception {
        if (!this.checkedOut)
            throw new Exception("Not checked out!");
        else
            this.checkedOut = false;
    }


    @Override
    public void displayItem(){
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("  %-15s %-15s\n", director, genre);

    }


}




