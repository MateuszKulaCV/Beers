package net.springjava.springmvc;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
     
    
    @RequestMapping(value="/beers")
    public ModelAndView beerList() {
        List<Beers> listBeers = beerService.list();
        ModelAndView model = new ModelAndView("beers");
        model.addObject("beerList", listBeers);
        return model;
    }
    
    @RequestMapping(value="/beers/createbeer")
    public ModelAndView createbeerpage()
    {
    	ModelAndView model = new ModelAndView("beers/createbeer");
    	model.addObject("beer", new Beers());
    	return model;
    }
    
    @RequestMapping(value="/beers/createbeer/process")
    public ModelAndView creatingbeers(@ModelAttribute("beer") Beers beer)
    {
    	ModelAndView model = new ModelAndView("redirect:/beers");
    	beerService.createBeer(beer);
    	return model;
    }
    
    
    @RequestMapping(value="beers/deletebeer/{id}", method= RequestMethod.GET)
    public ModelAndView deletebeer(@PathVariable Integer id)
    {
    ModelAndView model = new ModelAndView("redirect:/beers");
    beerService.deleteBeer(id);
    return model;	
    }
    
    @RequestMapping(value="beers/json")
    public @ResponseBody List<Beers> getListBeerInJson()
    {
    	return (List<Beers>) beerService.list();
    }
    
    @RequestMapping(value="beers/json/{id}", method = RequestMethod.GET)
    public @ResponseBody Beers getBeerInJson(@PathVariable Integer id)
    {
    	return (Beers) beerService.getById(id);
    }
    
   

     
}
