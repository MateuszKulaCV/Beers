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
import net.springjava.springmvc.model.Pubs;
import net.springjava.springmvc.service.PubService;


 
/**
 * Handles requests for the application home page.
 */
@Controller
public class PubController {
     
    @Autowired
    private PubService pubService;
     
    
    @RequestMapping(value="/pubs")
    public ModelAndView pubList() {
        List<Pubs> listPubs = pubService.list();
        ModelAndView model = new ModelAndView("pubs");
        model.addObject("pubList", listPubs);
        return model;
    }
    
    @RequestMapping(value="/pubs/createpub")
    public ModelAndView createpubpage()
    {
    	ModelAndView model = new ModelAndView("pubs/createpub");
    	model.addObject("pub", new Pubs());
    	return model;
    }
    
    @RequestMapping(value="/pubs/createpub/process")
    public ModelAndView creatingpubs(@ModelAttribute("pub") Pubs pub)
    {
    	ModelAndView model = new ModelAndView("redirect:/pubs");
    	pubService.createPub(pub);
    	return model;
    }
    
    
    @RequestMapping(value="pubs/deletepub/{id}", method= RequestMethod.GET)
    public ModelAndView deletepub(@PathVariable Integer id)
    {
    ModelAndView model = new ModelAndView("redirect:/pubs");
    pubService.deletePub(id);
    return model;	
    }
    
    @RequestMapping(value="pubs/json")
    public @ResponseBody List<Pubs> getListPubsInJson()
    {
    	return (List<Pubs>) pubService.list();
    }
    
    @RequestMapping(value="pubs/json/{id}", method = RequestMethod.GET)
    public @ResponseBody Pubs getPubInJson(@PathVariable Integer id)
    {
    	return (Pubs) pubService.getPub(id);
    }

     
}
