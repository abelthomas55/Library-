package inventory;

public class Dvd extends Item {
    private String director;
    private String movieGenre;

    public Dvd(String title, String invdate) throws Exception {
        super(title, invdate);
    }

    public Dvd(String title, String invdate, String author, String bookgenre) {
        super(title, invdate, author, bookgenre);
        this.director = author;
        this.movieGenre = bookgenre;
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

    public void setMovieGenre(String MovieGenre){
        this.movieGenre =  movieGenre;
    }

    public enum MovieGenre {
        ACTION,
        COMEDY,
        DRAMA,
        HORROR,
        ROMANCE,
        SCIENCE_FICTION,
        THRILLER,
        ANIMATION,
        DOCUMENTARY,
        FANTASY
    }

}




