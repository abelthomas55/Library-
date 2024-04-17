package src.library.inventory;

public class Dvd extends Item implements CheckInOut{
    private String director;
    private DvdGenre genre;
    private boolean checkedOut;

    public Dvd(String title, String invdate, String description) throws Exception {
        super(title, invdate, description);
        this.checkedOut = false;
    }

    public Dvd(String title, String invdate, String description, String director, DvdGenre movieGenre) throws Exception {
        super(title,invdate, description);
        setDirector(director);
        setMovieGenre(movieGenre);
        this.checkedOut = false;
    }
    public Dvd(int id, String title, String invdate, String description, String director, DvdGenre movieGenre) throws Exception {
        super(id, title,invdate, description);
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
    public void checkOut(){
        if (this.checkedOut)
            System.out.println("Cannot check out a DVD that is already checked out.");
        else
            System.out.println("The DVD has been checked out.");
        this.checkedOut = true;
    }

    @Override
    public void checkIn(){
        if (!this.checkedOut)
            System.out.println("Cannot check in a DVD that isn't already checked out.");
        else
            System.out.println("The DVD has been checked in.");
        this.checkedOut = false;
    }


    @Override
    public void displayItem(){
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("  %-15s %-15s\n", director, genre);

    }


}




