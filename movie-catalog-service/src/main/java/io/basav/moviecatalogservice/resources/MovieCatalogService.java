package io.basav.moviecatalogservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.basav.moviecatalogservice.models.CatalogItem;

import io.basav.moviecatalogservice.models.Movie;
import io.basav.moviecatalogservice.models.Rating;
import io.basav.moviecatalogservice.models.UserRating;
import io.basav.moviecatalogservice.services.MovieInfo;
import io.basav.moviecatalogservice.services.UserRatingInfo;
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

    @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = userRatingInfo.getUserRating(userId);
        return userRating.getRating().stream().map(rating ->
                movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
    }
}
