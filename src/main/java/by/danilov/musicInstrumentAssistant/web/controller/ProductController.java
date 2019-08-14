package by.danilov.musicInstrumentAssistant.web.controller;

import by.danilov.musicInstrumentAssistant.domain.entities.Product;
import by.danilov.musicInstrumentAssistant.repository.api.ProductRepository;
import by.danilov.musicInstrumentAssistant.web.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/load/by-id/{product-id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product-id") Long id) {
        if (id != null && id >= 1) {
            Product product = repository.findById(id).orElseThrow(() ->
                    new EntityNotFoundException(Product.class.getSimpleName(), id));
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

//    @GetMapping("/load")
//    public ResponseEntity<Page<Product>> getProductByName(@RequestParam("shop-name") String shopName,
//                                                          @RequestParam("page") Integer page) {
//        if (shopName != null) {
//            PageRequest pageRequest = PageRequest.of(page, 6);
//            Page<Product> products = repository.findAllByShopName(shopName, pageRequest);
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

}
