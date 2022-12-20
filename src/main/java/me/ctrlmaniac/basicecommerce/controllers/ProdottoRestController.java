package me.ctrlmaniac.basicecommerce.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.ctrlmaniac.basicecommerce.Model.Prodotto;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoRestController {
    @GetMapping("")
    public ResponseEntity<List<Prodotto>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prodotto> getById() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prodotto> update(@PathVariable String id, @RequestBody Prodotto prodotto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        return new ResponseEntity<>("Prodotto modificato con successo!", HttpStatus.OK);
    }
}
