package io.basav.movieinfoservice.models;

/**
 * Created by abhi on 1/15/2021.
 */
public class MovieSummary {

    private String overview;
    private String title;

    public MovieSummary() {
    }

    public MovieSummary(String overview, String title) {
        this.overview = overview;
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
