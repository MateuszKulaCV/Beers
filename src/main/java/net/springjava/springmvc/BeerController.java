package net.springjava.springmvc;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.springjava.springmvc.model.Beers;
import net.springjava.springmvc.service.BeerService;


 
/**
 * Handles requests for the application home page.
 */
@Controller
public class BeerController {
     
    @Autowired
    private BeerService beerService;
     
    @RequestMapping(value="/")
    public ModelAndView home()
    {
    	ModelAndView model = new ModelAndView("home");
    	return model;
    }
    
    @RequestMapping(value={"/beers/beerlist","/beers"})
    public ModelAndView beerList() {
        List<Beers> listBeers = beerService.list();
        ModelAndView model = new ModelAndView("beerList2");
        model.addObject("beerList", listBeers);
        return model;
    }
    
    @RequestMapping(value="/beers/createbeer")
    public ModelAndView createbeerpage()
    {
    	ModelAndView model = new ModelAndView("createbeer");
    	model.addObject("beer", new Beers());
    	return model;
    }
    
    @RequestMapping(value="beers/createbeer/process")
    public ModelAndView creatingbeers(@ModelAttribute("beer") Beers beer)
    {
    	ModelAndView model = new ModelAndView("redirect:/beers/beerlist");
    	beerService.createBeer(beer);
    	return model;
    }
    
    
    @RequestMapping(value="beers/deletebeer/{id}", method= RequestMethod.GET)
    public ModelAndView deletebeer(@PathVariable Integer id)
    {
    ModelAndView model = new ModelAndView("redirect:/beers/beerlist");
    beerService.deleteBeer(id);
    return model;	
    }
    
   

     
}
