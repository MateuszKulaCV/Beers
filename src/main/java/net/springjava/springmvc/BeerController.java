package net.springjava.springmvc;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.springjava.springmvc.dao.BeersDAO;
import net.springjava.springmvc.model.Beers;


 
/**
 * Handles requests for the application home page.
 */
@Controller
public class BeerController {
     
    @Autowired
    private BeersDAO beersDAO;
     
    @RequestMapping(value="/beerlist")
    public ModelAndView beerList() {
        List<Beers> listBeers = beersDAO.list();
        ModelAndView model = new ModelAndView("beerList2");
        model.addObject("beerList", listBeers);
        return model;
    }
     
}