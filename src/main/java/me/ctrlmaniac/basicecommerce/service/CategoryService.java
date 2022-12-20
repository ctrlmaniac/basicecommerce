package me.ctrlmaniac.basicecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ctrlmaniac.basicecommerce.models.Category;
import me.ctrlmaniac.basicecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository CategoryRepository;

    public Category saveCategory(Category Category){
        return CategoryRepository.save(Category);
    }
    public Category getCategoryBySlug(String slug){
        return CategoryRepository.findBySlug(slug);
    }
    public void deleteByID(String id){
        CategoryRepository.deleteById(id);
    }
    public Category updateByID(String id, Category newCategory){

        Optional<Category> oldCategoryType = CategoryRepository.findById(newCategory.getId());

        if(oldCategoryType.isPresent()){
            Category oldCategory = oldCategoryType.get();

            oldCategory.setName(newCategory.getName());
            oldCategory.setSlug(newCategory.getSlug());
            oldCategory.setDescription(newCategory.getDescription());

            return CategoryRepository.save(oldCategory);
        }
        return null;
    }
}
