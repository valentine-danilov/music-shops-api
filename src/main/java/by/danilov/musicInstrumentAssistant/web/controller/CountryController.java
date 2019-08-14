package by.danilov.musicInstrumentAssistant.web.controller;

import by.danilov.musicInstrumentAssistant.domain.entities.Country;
import by.danilov.musicInstrumentAssistant.repository.api.CountryRepository;
import by.danilov.musicInstrumentAssistant.web.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryRepository service;

    public CountryController(CountryRepository service) {
        this.service = service;
    }


    @GetMapping("/load/{country-id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("country-id") Long countryId) {
        if (countryId != null && countryId >= 1) {
            Country country = service.findById(countryId).orElseThrow(() ->
                    new EntityNotFoundException(Country.class.getSimpleName(), countryId));
            return new ResponseEntity<>(country, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /*@GetMapping("/load/all")
    public ResponseEntity<List<Country>> getAllCountries(Integer page, Integer size) {

    }*/

}
