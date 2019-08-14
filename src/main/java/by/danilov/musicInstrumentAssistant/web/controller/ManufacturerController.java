package by.danilov.musicInstrumentAssistant.web.controller;

import by.danilov.musicInstrumentAssistant.domain.entities.Manufacturer;
import by.danilov.musicInstrumentAssistant.repository.api.ManufacturerRepository;
import by.danilov.musicInstrumentAssistant.web.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private final ManufacturerRepository repository;

    public ManufacturerController(ManufacturerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/load/{manufacturer-id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable("manufacturer-id") Long id) {
        if (id != null && id >= 1) {
            Manufacturer manufacturer = repository.findById(id).orElseThrow(() ->
                    new EntityNotFoundException(Manufacturer.class.getSimpleName(), id));
            return new ResponseEntity<>(manufacturer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity createNew(@RequestBody Manufacturer manufacturer) {
        if (manufacturer != null) {
            repository.save(Manufacturer.builder()
                    .country(manufacturer.getCountry())
                    .name(manufacturer.getName())
                    .build()
            );
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
