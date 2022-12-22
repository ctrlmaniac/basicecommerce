package me.ctrlmaniac.basicecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ctrlmaniac.basicecommerce.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
