package io.basav.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.basav.moviecatalogservice.models.Rating;
import io.basav.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by abhi on 1/15/2021.
 */
@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate ;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000")})
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://movie-rating-service/ratings/users/"+userId, UserRating.class );
    }

    public UserRating getFallbackUserRating(@PathVariable("userId") String userId) {

        return new UserRating(Arrays.asList(new Rating("No Movie Id", 4)));

    }
}


