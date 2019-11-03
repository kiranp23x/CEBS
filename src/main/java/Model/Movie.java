package Model;

public class Movie {
    private String title;
    private String genre;
    private String rating;
    private String[] cast;
    private String director, producer;
    private String synopsis;
    private String[] reviews;
    private String trailerPicture; //URL or filepath?
    private String trailerVideo;
    //private int runtime; (get/set?)

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public String[] getCast() {
        return cast;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String[] getReviews() {
        return reviews;
    }

    public String getTrailerPicture() {
        return trailerPicture;
    }

    public String getTrailerVideo() {
        return trailerVideo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }

    public void setTrailerPicture(String trailerPicture) {
        this.trailerPicture = trailerPicture;
    }

    public void setTrailerVideo(String trailerVideo) {
        this.trailerVideo = trailerVideo;
    }
}
