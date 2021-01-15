package io.basav.moviecatalogservice.models;

import java.util.List;

/**
 * Created by abhi on 1/14/2021.
 */
public class UserRating {

    private List<Rating> rating ;

    public UserRating(List<Rating> rating) {
        this.rating = rating;
    }

    public UserRating() {
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }
}
