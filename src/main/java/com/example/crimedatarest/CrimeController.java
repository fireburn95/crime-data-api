package com.example.crimedatarest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CrimeController {

  @Autowired
  private CrimeServiceImpl crimeService;

  @GetMapping("/crime/categories")
  public CategoriesDTO getCategories() {
    try {
      return crimeService.getCrimeCategories();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/crimes")
  public Crime[] getCrimes(
      @RequestParam(value = "postcode") String postcode,
      @RequestParam(value = "date") String date
  ) {
    try {
      Crime[] crimes = crimeService.getCrimesByPostcodeAndMonth(postcode, date);

      if (crimes.length == 0) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }

      return crimes;
    } catch (HttpClientErrorException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
  }

}
