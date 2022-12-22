package me.ctrlmaniac.basicecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ctrlmaniac.basicecommerce.models.Address;
import me.ctrlmaniac.basicecommerce.repositories.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address save(Address reservation) {
        return addressRepository.save(reservation);
    }

    public Address getById(String id) {
        Optional<Address> productOpt = addressRepository.findById(id);

        if (productOpt.isPresent()) {
            return productOpt.get();
        }

        return null;
    }

    public void deleteById(String id) {
        addressRepository.deleteById(id);
    }

    public Address updateById(String id, Address newAddress) {

        Optional<Address> oldAddressType = addressRepository.findById(newAddress.getId());

        if (oldAddressType.isPresent()) {
            Address oldAddress = oldAddressType.get();

            oldAddress.setUser(newAddress.getUser());
            oldAddress.setRecipientName(newAddress.getRecipientName());
            oldAddress.setStreetAddress(newAddress.getStreetAddress());
            oldAddress.setSuiteNumber(newAddress.getSuiteNumber());
            oldAddress.setCity(newAddress.getCity());
            oldAddress.setZipCode(newAddress.getZipCode());
            oldAddress.setState(newAddress.getState());
            oldAddress.setCountry(newAddress.getCountry());

            return addressRepository.save(oldAddress);
        }
        return null;
    }
}
