package me.ctrlmaniac.basicecommerce.controllers.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import me.ctrlmaniac.basicecommerce.models.Category;
import me.ctrlmaniac.basicecommerce.models.Product;
import me.ctrlmaniac.basicecommerce.services.CategoryService;
import me.ctrlmaniac.basicecommerce.services.ProductService;

@Controller
public class ProductAdController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/admin/product")
    public ModelAndView showProduct() {

        ModelAndView view = new ModelAndView();
        view.setViewName("/admin/product");

        // nella Get ci vanno tutti gli oggetti per le varie richieste questa nel caso
        // specifico va per la post
        Product nuovoA = new Product();
        view.addObject("product", nuovoA);

        List<Product> listProd = productService.findAll();
        List<Category> listCat = categoryService.findAll();
        view.addObject("listProduct", listProd);
        view.addObject("categories", listCat);
        return view;
    }

    @PostMapping(path = "/admin/product/create", consumes = "application/x-www-form-urlencoded")
    public String insertProduct(@ModelAttribute Product product) {

        productService.save(product);
        return "redirect:/admin/product"; // avrei potuto usare anche il modelAndView come negli altri metodi.

    }
}
