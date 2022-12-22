package me.ctrlmaniac.basicecommerce.controllers.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import me.ctrlmaniac.basicecommerce.models.Category;
import me.ctrlmaniac.basicecommerce.services.CategoryService;

@Controller
public class CategoryAdController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/admin/category")
    public ModelAndView showCategory() {

        ModelAndView view = new ModelAndView();
        view.setViewName("/admin/category");

        // nella Get ci vanno tutti gli oggetti per le varie richieste questa nel caso
        // specifico va per la post
        Category nuovoA = new Category();
        view.addObject("category", nuovoA);

        List<Category> listCat = categoryService.findAll();
        view.addObject("listCategory", listCat);
        return view;
    }

    @PostMapping(path = "/admin/category/create", consumes = "application/x-www-form-urlencoded")
    public String insertCategory(@ModelAttribute Category category) {

        categoryService.save(category);
        return "redirect:/admin/category"; // avrei potuto usare anche il modelAndView come negli altri metodi.

    }
}
