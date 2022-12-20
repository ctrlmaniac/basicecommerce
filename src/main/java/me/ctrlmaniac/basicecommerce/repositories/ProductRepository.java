package me.ctrlmaniac.basicecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ctrlmaniac.basicecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    public Product findBySlug(String slug);

}
