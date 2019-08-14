package by.danilov.musicInstrumentAssistant.repository.api;

import by.danilov.musicInstrumentAssistant.domain.entities.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface CountryRepository
        extends PagingAndSortingRepository<Country, Long> {
    boolean existsByName(String countryName);
}
