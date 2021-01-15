package io.basav.movieratingservice.resources;

import io.basav.movieratingservice.models.Rating;
import io.basav.movieratingservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abhi on 1/14/2021.
 */
@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating("123", 4);

    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> list = Arrays.asList(
                new Rating("100", 4),
                new Rating("200", 5));

        UserRating userRating = new UserRating();
        userRating.setRating(list);
        return userRating;
    }
}
