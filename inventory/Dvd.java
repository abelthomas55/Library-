package inventory;

public class Dvd extends Item {
    private String director;
    private String movieGenre;

    public Dvd(String title, String invdate) throws Exception {
        super(title, invdate);
    }

    public Dvd(String title, String invdate, String director, Moviegenre movieGenre) throws Exception {
        super(title,invdate);
        this.director = director;
        this.movieGenre = getMovieGenre();
    }

    public String getDirector() {
        return director;

    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setDirector(){
        this.director = director;
    }

    public void setMovieGenre(){
        this.movieGenre =  movieGenre;
    }



}




