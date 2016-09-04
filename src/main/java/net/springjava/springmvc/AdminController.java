package net.springjava.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.springjava.springmvc.model.Beers;
import net.springjava.springmvc.model.Pubs;
import net.springjava.springmvc.service.BeerService;

@Controller
public class AdminController {

	@Autowired
	private BeerService beerService;
	
	
	@RequestMapping(value="/admin")
	public ModelAndView admin()
	{
		ModelAndView model = new ModelAndView("admin");
		return model;
	}
	
	@RequestMapping(value="/admin/beers")
	public ModelAndView adminBeers()
	{
		ModelAndView model = new ModelAndView("adminbeers");
		beerList(model);
		return model;
	}
	
	
	@RequestMapping(value="/admin/beers/edit/{id}")
	public ModelAndView editBeer(@PathVariable("id") int id)
	{
		
		ModelAndView model = new ModelAndView("adminbeersedit");
		model.addObject("beer",beerService.getById(id));
		return model;
	}
	
	@RequestMapping(value="/admin/beers/edit/{id}/process")
	public ModelAndView editingBeer(@ModelAttribute("beer") Beers beer)
	{
		ModelAndView model = new ModelAndView("adminbeers");
		beerService.updateBeer(beer);
		beerList(model);
		return model;
	}
	
	
	
	@RequestMapping(value="/admin/beers/add")
	public ModelAndView addBeer()
	{
		ModelAndView model = new ModelAndView("adminbeersadd");
		model.addObject("beer",new Beers());
		return model;
	}
	
	@RequestMapping(value= "/admin/beers/add/process")
	public ModelAndView addinBeer(@ModelAttribute("beer") Beers beer)
	{
		ModelAndView model = new ModelAndView("adminbeers");
		
		beerService.createBeer(beer);
	
		beerList(model);
		return model;
	}
	
	
	
	
	@RequestMapping(value="/admin/beers/delete/{id}")
	public ModelAndView adminDelete(@PathVariable Integer id)
	{
		ModelAndView model = new ModelAndView("adminbeers");
		beerService.deleteBeer(id);
		beerList(model);
		return model;
	}
	
	
	
	@RequestMapping(value="/admin/info")
	public ModelAndView adminInfo()
	{
		ModelAndView model = new ModelAndView("admininfo");
		return model;
	}
	
	
	
	//updating beerList
	private void beerList(ModelAndView model)
	{
		model.addObject("beerList",beerService.list());
	
	}


}	
