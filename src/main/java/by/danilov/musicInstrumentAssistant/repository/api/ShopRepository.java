package by.danilov.musicInstrumentAssistant.repository.api;

import by.danilov.musicInstrumentAssistant.domain.entities.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ShopRepository
        extends PagingAndSortingRepository<Shop, Long> {

    Optional<Shop> findByName(String shopName);
}
