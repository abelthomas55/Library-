package inventory;

public class Dvd extends Item {
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

    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf("  %-15s %-15s\n", director, movieGenre);

    }


}




