package by.danilov.musicInstrumentAssistant.repository.api;

import by.danilov.musicInstrumentAssistant.domain.entities.Manufacturer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManufacturerRepository
        extends PagingAndSortingRepository<Manufacturer, Long> {
}
