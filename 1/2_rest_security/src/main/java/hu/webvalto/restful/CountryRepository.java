package hu.webvalto.restful;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    void init() {
        Country country = new Country("GB", "England", "GBP", "London", "10000000");
        countries.put(country.getId(), country);
    }

    public Collection<Country> getAllCountry() {
        return countries.values();
    }

    public void addNewCounty(Country country) {
        countries.put(country.getId(), country);
    }
}
