package io.basav.movieinfoservice.resources;

import io.basav.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by abhi on 1/14/2021.
 */

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable ("movieId") String movieId){
        //Make a call to db to get the details for the movieId but we are hardcoding here.
        return  new Movie("123", "Titanic");

    }
}
