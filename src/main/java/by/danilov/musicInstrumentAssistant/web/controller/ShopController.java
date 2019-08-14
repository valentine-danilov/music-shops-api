package by.danilov.musicInstrumentAssistant.web.controller;

import by.danilov.musicInstrumentAssistant.domain.entities.Shop;
import by.danilov.musicInstrumentAssistant.repository.api.ShopRepository;
import by.danilov.musicInstrumentAssistant.web.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shop")
public class ShopController {


    private final ShopRepository repository;

    public ShopController(ShopRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/load/by-id/{shop-id}")
    public ResponseEntity<Shop> getShopById(@PathVariable("shop-id") Long id) {
        if (id != null && id > 0) {
            Shop shop = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(
                            Shop.class.getSimpleName(), id
                    ));
            return new ResponseEntity<>(shop, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/load/by-name")
    public ResponseEntity<Shop> getShopByName(@RequestParam("name") String shopName) {
        if (shopName != null) {
            Shop shop = repository.findByName(shopName)
                    .orElseThrow(() -> new EntityNotFoundException(
                            Shop.class.getSimpleName()
                    ));
            return new ResponseEntity<>(shop, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
