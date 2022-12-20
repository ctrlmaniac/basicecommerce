package me.ctrlmaniac.basicecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ctrlmaniac.basicecommerce.models.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

    public Category findBySlug(String slug);

}
