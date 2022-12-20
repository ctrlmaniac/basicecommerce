package me.ctrlmaniac.basicecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ctrlmaniac.basicecommerce.models.Product;
import me.ctrlmaniac.basicecommerce.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product reservation) {
        return productRepository.save(reservation);
    }

    public Product getBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    public Product getById(String id) {
        Optional<Product> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()) {
            return productOpt.get();
        }

        return null;
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    public Product updateById(String id, Product newProduct) {

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
