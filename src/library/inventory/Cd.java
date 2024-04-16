package src.library.inventory;

public class Cd extends Item implements CheckInOut {

    private String artist;
    private boolean checkedOut;


    private CdGenre genre;

    public Cd(String title, String invdate) throws Exception {
        super(title, invdate);
        this.checkedOut = false;
    }

    public Cd(String title, String invdate, String artist, CdGenre musicGenre) throws Exception {
        super(title, invdate);
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
    public boolean isCheckedOut() {
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
    public void displayItem() {
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("  %-15s %-15s\n", artist, genre);

    }


}




