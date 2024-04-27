package src.library.inventory;
/**
 * The Dvd class represents a DVD item in the library inventory.
 * It extends the Item class and implements the CheckInOut interface.
 */
public class Dvd extends Item implements CheckInOut{
    private String director;
    private DvdGenre genre;
    private boolean checkedOut;

    /**
     * Constructs a Dvd object with the given title, inventory date, and description.
     * @param title The title of the DVD.
     * @param invdate The inventory date of the DVD.
     * @param description The description of the DVD.
     * @throws Exception If an error occurs during construction.
     */
    public Dvd(String title, String invdate, String description) throws Exception {
        super(title, invdate, description);
        this.checkedOut = false;
    }
    /**
     * Constructs a Dvd object with the given title, inventory date, description, director, and movie genre.
     * @param title The title of the DVD.
     * @param invdate The inventory date of the DVD.
     * @param description The description of the DVD.
     * @param director The director of the DVD.
     * @param movieGenre The movie genre of the DVD.
     * @throws Exception If an error occurs during construction.
     */
    public Dvd(String title, String invdate, String description, String director, DvdGenre movieGenre) throws Exception {
        super(title,invdate, description);
        setDirector(director);
        setMovieGenre(movieGenre);
        this.checkedOut = false;
    }
    /**
     * Constructs a Dvd object with the given id, title, inventory date, description, director, and movie genre.
     * @param id The id of the DVD.
     * @param title The title of the DVD.
     * @param invdate The inventory date of the DVD.
     * @param description The description of the DVD.
     * @param director The director of the DVD.
     * @param movieGenre The movie genre of the DVD.
     * @throws Exception If an error occurs during construction.
     */
    public Dvd(int id, String title, String invdate, String description, String director, DvdGenre movieGenre) throws Exception {
        super(id, title,invdate, description);
        setDirector(director);
        setMovieGenre(movieGenre);
        this.checkedOut = false;
    }
    /**
     * Sets the director of the DVD.
     * @param director The director of the DVD.
     * @throws Exception If an error occurs during setting the director.
     */
    public void setDirector(String director) throws Exception{
        director = director.trim();
        director = director.substring(0,1).toUpperCase() + director.substring(1);
        this.director = director;
        this.checkedOut = false;
    }
    /**
     * Gets the director of the DVD.
     * @return The director of the DVD.
     */
    public String getDirector() {
        return director;

    }
    /**
     * Sets the movie genre of the DVD.
     * @param genre The movie genre of the DVD.
     * @throws Exception If an error occurs during setting the movie genre.
     */
    public void setMovieGenre(DvdGenre genre)throws Exception{
        this.genre = genre;
    }
    /**
     * Gets the movie genre of the DVD.
     * @return The movie genre of the DVD.
     */
    public DvdGenre getMovieGenre() {
        return this.genre;
    }

    /**
     * Checks if the DVD is checked out.
     * @return True if the DVD is checked out, false otherwise.
     */
    @Override
    public boolean isCheckedOut(){
        return checkedOut;
    }

    /**
     * Checks out the DVD.
     */

    @Override
    public void checkOut(){
        if (this.checkedOut)
            System.out.println("Cannot check out a DVD that is already checked out.");
        else
            System.out.println("The DVD has been checked out.");
        this.checkedOut = true;
    }
    /**
     * Checks in the DVD.
     */
    @Override
    public void checkIn(){
        if (!this.checkedOut)
            System.out.println("Cannot check in a DVD that isn't already checked out.");
        else
            System.out.println("The DVD has been checked in.");
        this.checkedOut = false;
    }

    /**
     * Displays the details of the DVD.
     */
    @Override
    public void displayItem(){
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("  %-15s %-15s\n", director, genre);

    }


}




