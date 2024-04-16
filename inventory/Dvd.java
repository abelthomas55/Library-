package inventory;

public class Dvd extends Item implements CheckInOut{
    private String director;
    private String movieGenre;

    public Dvd(String title, String invdate) throws Exception {
        super(title, invdate);
    }

    public Dvd(String title, String invdate, String director, Moviegenre movieGenre) throws Exception {
        super(title,invdate);
        setDirector(director);
        setMovieGenre(movieGenre);
    }

    public void setDirector(String director) throws Exception{
        director = director.trim();
        director = director.substring(0,1).toUpperCase() + director.substring(1);
        this.director = director;
    }

    public String getDirector() {
        return director;

    }

    public void setMovieGenre(Moviegenre movieGenre)throws Exception{
        this.movieGenre = String.valueOf(movieGenre);
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public boolean setCheckedOut(boolean b){
        this.checkOut();
        return false;
    }


    @Override
    public void checkIn() {
        if(!isCheckedOut()){
            System.out.println("This DVD is available to be Checked Out");
        }
        else {
            setCheckedOut(false);
        }

    }



    @Override
    public boolean checkOut(){
        if (isCheckedOut()) {
            System.out.println("This DVD has been checked out.");
        }
        else {
            setCheckedOut(true);
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
        System.out.printf("  %-15s %-15s\n", director, movieGenre);

    }


}




