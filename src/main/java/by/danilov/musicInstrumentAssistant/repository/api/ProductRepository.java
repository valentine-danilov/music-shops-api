package by.danilov.musicInstrumentAssistant.repository.api;

import by.danilov.musicInstrumentAssistant.domain.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository
        extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findAllByShopName(String name, PageRequest pageRequest);
}
