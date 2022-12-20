package me.ctrlmaniac.basicecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import me.ctrlmaniac.basicecommerce.models.Category;
import me.ctrlmaniac.basicecommerce.models.Product;
import me.ctrlmaniac.basicecommerce.services.CategoryService;
import me.ctrlmaniac.basicecommerce.services.ProductService;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application running!");

        // Dummy content

        // Categorie
        Category musica = new Category("Musica", "musica",
                "CD, Vinili e articoli inerenti la musica.");

        Category libri = new Category("Libri", "libri", "Libri, fumetti e graphic novels.");

        Category elettronica = new Category("Elettronica", "elettronica", "PC, Telefoni, Cellulari...");

        categoryService.save(musica);
        categoryService.save(libri);
        categoryService.save(elettronica);

        Product vinile = new Product("Vinile David Bowie", "vinile_david_bowie", "Vinile di David Bowie", 29.99,
                musica);

        productService.save(vinile);
    }

}
