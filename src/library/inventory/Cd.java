package src.library.inventory;

/**
 * The Cd class represents a CD item in the library inventory.
 * It extends the Item class and implements the CheckInOut interface.
 */
public class Cd extends Item implements CheckInOut {

    private String artist; // The Artist of the Cd
    private boolean checkedOut; // To check whether the Cd is checkout out or not
    private CdGenre genre; // The genre of the Cd

    /**
     * Constructs a Cd object with the given title, inventory date, and description.
     * @param title The title of the CD.
     * @param invdate The inventory date of the CD.
     * @param description The description of the CD.
     * @throws Exception If an error occurs during construction.
     */
    public Cd(String title, String invdate, String description) throws Exception {
        super(title, invdate, description);
        this.checkedOut = false;
    }
    /**
     * Constructs a Cd object with the given title, inventory date, description, artist, and music genre.
     * @param title The title of the CD.
     * @param invdate The inventory date of the CD.
     * @param description The description of the CD.
     * @param artist The artist of the CD.
     * @param musicGenre The music genre of the CD.
     * @throws Exception If an error occurs during construction.
     */
    public Cd(String title, String invdate, String description, String artist, CdGenre musicGenre) throws Exception {
        super(title, invdate, description);
        setArtist(artist);
        setMusicGenre(musicGenre);
        this.checkedOut = false;
    }
    /**
     * Constructs a Cd object with the given id, title, inventory date, description, artist, and music genre.
     * @param id The id of the CD.
     * @param title The title of the CD.
     * @param invdate The inventory date of the CD.
     * @param description The description of the CD.
     * @param artist The artist of the CD.
     * @param musicGenre The music genre of the CD.
     * @throws Exception If an error occurs during construction.
     */
    public Cd(int id, String title, String invdate, String description, String artist, CdGenre musicGenre) throws Exception {
        super(id, title, invdate, description);
        setArtist(artist);
        setMusicGenre(musicGenre);
        this.checkedOut = false;
    }
    /**
     * Sets the artist of the CD.
     * @param artist The artist of the CD.
     * @throws Exception If an error occurs during setting the artist.
     */
    public void setArtist(String artist) throws Exception {
        artist = artist.trim();
        artist = artist.substring(0, 1).toUpperCase() + artist.substring(1);
        this.artist = artist;
        this.checkedOut = false;
    }
    /**
     * Gets the artist of the CD.
     * @return The artist of the CD.
     */
    public String getArtist() {
        return artist;

    }
    /**
     * Sets the music genre of the CD.
     * @param genre The music genre of the CD.
     * @throws Exception If an error occurs during setting the music genre.
     */
    public void setMusicGenre(CdGenre genre) throws Exception {
        this.genre = genre;
    }
    /**
     * Gets the music genre of the CD.
     * @return The music genre of the CD.
     */
    public CdGenre getMusicGenre() {
        return this.genre;
    }

    /**
     * Checks if the CD is checked out.
     * @return True if the CD is checked out, false otherwise.
     */
    @Override
    public boolean isCheckedOut(){
        return checkedOut;
    }
    /**
     * Checks out the CD.
     */
    @Override
    public void checkOut(){
        if (this.checkedOut)
            System.out.println("Cannot check out a CD that is already checked out.");
        else
            System.out.println("The CD has been checked out.");
        this.checkedOut = true;
    }
    /**
     * Checks in the CD.
     */
    @Override
    public void checkIn(){
        if (!this.checkedOut)
            System.out.println("Cannot check in a CD that isn't already checked out.");
        else
            System.out.println("The CD has been checked in.");
        this.checkedOut = false;
    }
    /**
     * Displays the details of the CD.
     */
    @Override
    public void displayItem() {
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("  %-15s %-15s\n", artist, genre);

    }


}




