package inventory;

public class Cd extends Item implements CheckInOut{

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

    public boolean setCheckedOut(boolean b){
        this.checkOut();
        return false;
    }


    @Override
    public void checkIn() {
        if(!isCheckedOut()){
            System.out.println("This CD is available to be Checked Out");
        }
        else {
            setCheckedOut(false);
        }

    }



    @Override
    public boolean checkOut(){
        if (isCheckedOut()) {
            System.out.println("This CD has been checked out.");
        }
        else {
            setCheckedOut();
        }
        return false;
    }
    @Override
    public boolean isCheckedOut(){
        return isCheckedOut();
    }


    @Override
    public void displayItem(){
        System.out.printf("%-3d %-15s %-10s ", id, title, getInvDate());
        System.out.printf("  %-15s %-15s\n", artist, musicGenre);

    }


}




