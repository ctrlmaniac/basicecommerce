package me.ctrlmaniac.basicecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.ctrlmaniac.basicecommerce.models.Product;
import me.ctrlmaniac.basicecommerce.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id) {
        Product prodotto = productService.getById(id);
        return new ResponseEntity<>(prodotto, prodotto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product Product) {
        return new ResponseEntity<>(productService.updateById(id, Product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        productService.deleteById(id);
        return new ResponseEntity<>("Product modificato con successo!", HttpStatus.OK);
    }
}
