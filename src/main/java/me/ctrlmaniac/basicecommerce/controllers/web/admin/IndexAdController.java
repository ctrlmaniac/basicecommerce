package me.ctrlmaniac.basicecommerce.controllers.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexAdController {
    @RequestMapping(value = { "/admin"})
    public ModelAndView getWelcomePage() {

        ModelAndView view = new ModelAndView();
        view.setViewName("admin/index"); // Carica la pagina html che si chiama index.html pagina benvenuto

        return view;
    }
}
