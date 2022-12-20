package me.ctrlmaniac.basicecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ctrlmaniac.basicecommerce.models.Category;
import me.ctrlmaniac.basicecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category Category) {
        return categoryRepository.save(Category);
    }

    public Category getBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }

    public Category getById(String id) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);

        if (categoryOpt.isPresent()) {
            return categoryOpt.get();
        }

        return null;
    }

    public void deleteByID(String id) {
        categoryRepository.deleteById(id);
    }

    public Category updateByID(String id, Category newCategory) {

        Optional<Category> oldCategoryType = categoryRepository.findById(newCategory.getId());

        if (oldCategoryType.isPresent()) {
            Category oldCategory = oldCategoryType.get();

            oldCategory.setName(newCategory.getName());
            oldCategory.setSlug(newCategory.getSlug());
            oldCategory.setDescription(newCategory.getDescription());

            return categoryRepository.save(oldCategory);
        }
        return null;
    }
}
