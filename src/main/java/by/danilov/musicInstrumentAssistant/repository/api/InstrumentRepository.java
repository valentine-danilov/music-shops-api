package by.danilov.musicInstrumentAssistant.repository.api;

import by.danilov.musicInstrumentAssistant.domain.entities.Instrument;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InstrumentRepository
        extends PagingAndSortingRepository<Instrument, Long> {
}
