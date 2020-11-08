package hu.webvalto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CountryController {

    @Autowired
    public CountryRepository countryRepository;

    @GetMapping("/countries")
    public Collection<Country> getCountries() {
        return countryRepository.getAllCountry();
    }

    @PostMapping("/country")
    public String saveCountry(@RequestBody Country country) {
         countryRepository.addNewCounty(country);
         return "OK";
    }

    @GetMapping("/")
    public String home() {
        return "Bejelentkezve";
    }
}
