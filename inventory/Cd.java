package inventory;

public class Cd extends Item {

    private String artist;
    private String musicGenre;

    public Cd(String title, String invdate) throws Exception {
        super(title, invdate);
    }

    public Cd(String title, String invdate, String artist, Musicgenre musicGenre) throws Exception {
        super(title, invdate);
        setArtist(artist);
        setMusicGenre(musicGenre);
    }

    public void setArtist(String artist) throws Exception{
        artist = artist.trim();
        artist = artist.substring(0,1).toUpperCase() + artist.substring(1);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;

    }

    public void setMusicGenre(Musicgenre musicGenre) throws Exception{
        this.musicGenre = String.valueOf(musicGenre);
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf("  %-15s %-15s\n", artist, musicGenre);

    }


}




