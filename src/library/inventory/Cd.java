package src.library.inventory;

public class Cd extends Item implements CheckInOut {

    private String artist;
    private boolean checkedOut;


    private CdGenre genre;

    public Cd(String title, String invdate, String description) throws Exception {
        super(title, invdate, description);
        this.checkedOut = false;
    }

    public Cd(String title, String invdate, String description, String artist, CdGenre musicGenre) throws Exception {
        super(title, invdate, description);
        setArtist(artist);
        setMusicGenre(musicGenre);
        this.checkedOut = false;
    }

    public Cd(int id, String title, String invdate, String description, String artist, CdGenre musicGenre) throws Exception {
        super(id, title, invdate, description);
        setArtist(artist);
        setMusicGenre(musicGenre);
        this.checkedOut = false;
    }

    public void setArtist(String artist) throws Exception {
        artist = artist.trim();
        artist = artist.substring(0, 1).toUpperCase() + artist.substring(1);
        this.artist = artist;
        this.checkedOut = false;
    }

    public String getArtist() {
        return artist;

    }

    public void setMusicGenre(CdGenre genre) throws Exception {
        this.genre = genre;
    }

    public CdGenre getMusicGenre() {
        return this.genre;
    }


    @Override
    public boolean isCheckedOut(){
        return checkedOut;
    }

    @Override
    public void checkOut(){
        if (this.checkedOut)
            System.out.println("Cannot check out a CD that is already checked out.");
        else
            System.out.println("The CD has been checked out.");
        this.checkedOut = true;
    }

    @Override
    public void checkIn(){
        if (!this.checkedOut)
            System.out.println("Cannot check in a CD that isn't already checked out.");
        else
            System.out.println("The CD has been checked in.");
        this.checkedOut = false;
    }

    @Override
    public void displayItem() {
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("  %-15s %-15s\n", artist, genre);

    }


}




