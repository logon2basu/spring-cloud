package io.basav.moviecatalogservice.resources;

import io.basav.moviecatalogservice.models.CatalogItem;

import io.basav.moviecatalogservice.models.Movie;
import io.basav.moviecatalogservice.models.Rating;
import io.basav.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogService {

    @Autowired
    private RestTemplate restTemplate ;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {


     UserRating userRating = restTemplate.getForObject("http://movie-rating-service/ratings/users/"+userId, UserRating.class );

        return userRating.getRating().stream().map(rating -> {

            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getMovieName(), "A", rating.getRating());
          }
          ).collect(Collectors.toList());
    }
}
