package me.ctrlmaniac.basicecommerce.controllers.rest;

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

import me.ctrlmaniac.basicecommerce.models.Address;
import me.ctrlmaniac.basicecommerce.services.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    
    @Autowired
    AddressService addressService;

    @GetMapping("")
    public ResponseEntity<List<Address>> findAll() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable String id) {
        Address address = addressService.getById(id);
        // punto di domanda è uguale a if i due punti corrispondono a else
        return new ResponseEntity<>(address, address == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable String id, @RequestBody Address Address) {
        return new ResponseEntity<>(addressService.updateById(id, Address), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        addressService.deleteById(id);
        return new ResponseEntity<>("Address modificato con successo!", HttpStatus.OK);
    }
}
