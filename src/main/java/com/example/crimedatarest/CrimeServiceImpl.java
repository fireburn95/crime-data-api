package com.example.crimedatarest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

// todo make abstract/interface parent
@Component
public class CrimeServiceImpl {
  public CategoriesDTO getCrimeCategories() {
    Category[] categories = getAPIRequestData("https://data.police.uk/api/crime-categories",
        Category[].class);

    String[] categoriesString = Arrays.copyOf(
        Arrays.stream(categories).map(Category::getUrl).toArray(), categories.length,
        String[].class
    );

    CategoriesDTO categoriesDTO = new CategoriesDTO();
    categoriesDTO.setCategories(categoriesString);

    return categoriesDTO;
  }

  public Crime[] getCrimesByPostcodeAndMonth(String postcode, String date) {
    LocationResponseWrapper response = getAPIRequestData(
        "https://api.postcodes.io/postcodes/" + postcode, LocationResponseWrapper.class);

    Location location = response.getResult();

    Crime[] crimes = getAPIRequestData(
        "https://data.police.uk/api/crimes-at-location?lat=" + location.getLatitude() + "&lng="
            + location.getLongitude() + "&date=" + date, Crime[].class);

    return crimes;
  }

  private <T> T getAPIRequestData(String url, Class<T> classType) {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, classType);
  }
}
