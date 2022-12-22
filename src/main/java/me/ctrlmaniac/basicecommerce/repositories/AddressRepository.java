package me.ctrlmaniac.basicecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ctrlmaniac.basicecommerce.models.Address;

public interface AddressRepository extends JpaRepository<Address, String> {
    
}
