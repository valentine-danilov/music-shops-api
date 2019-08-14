package by.danilov.musicInstrumentAssistant.web.controller;

import by.danilov.musicInstrumentAssistant.domain.entities.Instrument;
import by.danilov.musicInstrumentAssistant.repository.api.InstrumentRepository;
import by.danilov.musicInstrumentAssistant.web.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;

@RestController
@RequestMapping("/instrument")
public class InstrumentController {

    private final InstrumentRepository instrumentRepository;

    public InstrumentController(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @GetMapping("/load/{instrument-id}")
    public ResponseEntity<Instrument> getById(@PathVariable("instrument-id") Long id) {
        if (id != null && id >= 1) {
            Instrument instrument = instrumentRepository.findById(id).orElseThrow(() ->
                    new EntityNotFoundException(Instrument.class.getSimpleName(), id));
            return new ResponseEntity<>(instrument, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
