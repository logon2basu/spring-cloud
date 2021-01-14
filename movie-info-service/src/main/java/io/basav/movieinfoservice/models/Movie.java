package io.basav.movieinfoservice.models;

/**
 * Created by abhi on 1/14/2021.
 */
public class Movie {

    private String movieName;
    private String movieId;

    public Movie(String movieName, String movieId) {
        this.movieName = movieName;
        this.movieId = movieId;
    }

    public Movie() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
