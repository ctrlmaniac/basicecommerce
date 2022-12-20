package me.ctrlmaniac.basicecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ctrlmaniac.basicecommerce.models.Product;
import me.ctrlmaniac.basicecommerce.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product reservation) {
        return productRepository.save(reservation);
    }
    
    public Product getProductBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    public void deleteByID(String id) {
        productRepository.deleteById(id);
    }

    public Product updateByID(String id, Product newProduct) {

        Optional<Product> oldProductType = productRepository.findById(newProduct.getId());

        if (oldProductType.isPresent()) {
            Product oldProduct = oldProductType.get();

            oldProduct.setName(newProduct.getName());
            oldProduct.setSlug(newProduct.getSlug());
            oldProduct.setDescription(newProduct.getDescription());
            oldProduct.setPrice(newProduct.getPrice());
        

            return productRepository.save(oldProduct);
        }
        return null;
    }
}
