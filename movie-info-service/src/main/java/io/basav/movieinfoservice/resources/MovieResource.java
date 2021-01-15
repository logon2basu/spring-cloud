package io.basav.movieinfoservice.resources;

import io.basav.movieinfoservice.models.Movie;
import io.basav.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by abhi on 1/14/2021.
 */

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String myApiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable ("movieId") String movieId){
        //Make a call to db to get the details for the movieId but we are hardcoding here.
        //Making call to the external api - moviedb

        MovieSummary movieSummary =
                restTemplate.getForObject
                        ("https://api.themoviedb.org/3/movie/"+ movieId + "?api_key=" +myApiKey,
                                MovieSummary.class);
        return  new Movie(movieSummary.getTitle(), movieSummary.getOverview());

    }
}
