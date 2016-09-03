package net.springjava.springmvc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import net.springjava.springmvc.service.BeerService;
import net.springjava.springmvc.service.PubService;


 
/**
 * Handles requests for the application home page.
 */
@Controller
public class PubController {
     
    @Autowired
    private PubService pubService;
    @Autowired
    private BeerService beerService;
    
    
    @RequestMapping(value="/pubs")
    public ModelAndView pubList() {
       
        ModelAndView model = new ModelAndView("pubs");
       pubs(model);
        return model;
    }
    
    
    @RequestMapping(value="/pubs/createpub")
    public ModelAndView createpubpage()
    {
    	ModelAndView model = new ModelAndView("createpub");
    	model.addObject("pub", new Pubs());
    	return model;
    }
    
    @RequestMapping(value="/pubs/createpub/process")
    public ModelAndView creatingpubs(@ModelAttribute("pub") Pubs pub)
    {
    	ModelAndView model = new ModelAndView("pubs");
    	pubService.createPub(pub);
    	pubs(model);
    	return model;
    }
    
    
    
    @RequestMapping(value="pubs/deletepub/{id}", method= RequestMethod.GET)
    public ModelAndView deletepub(@PathVariable Integer id)
    {
    ModelAndView model = new ModelAndView("pubs");
    pubService.deletePub(id);
    pubs(model);
    return model;	
    }
    
    
    //Return Json for android app 
    @RequestMapping(value="/pubs/json" ,method= RequestMethod.GET)
    public @ResponseBody List<Pubs> getListPubsInJson()
    {
    	return (List<Pubs>) pubService.list();
    }
    
    
    
    @RequestMapping(value="pubs/json/{id}", method = RequestMethod.GET)
    public @ResponseBody Pubs getPubInJson(@PathVariable Integer id)
    {
    	return (Pubs) pubService.getPub(id);
    }
    
    
    private void pubs(ModelAndView model)
    {
    	Map<Pubs,List<Beers>> out = new HashMap<Pubs,List<Beers>>();
    	 List<Pubs> listPubs = pubService.list();
    	for(Pubs p:listPubs)
    	{
    		out.put(p, beerService.listFromPub(p));
    	}
    	 model.addObject("out", out);
    }
     
}
