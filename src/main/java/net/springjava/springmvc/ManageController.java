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

/**
 * Pub manage controller
 * Add/Edit Beers/Info 
 *
 */
@Controller
public class ManageController {

	@Autowired
	private BeerService beerService;
	
	
	@RequestMapping(value="/manage")
	public ModelAndView manage()
	{
		ModelAndView model = new ModelAndView("manage");
		return model;
	}
	
	
	@RequestMapping(value="/manage/beers")
	public ModelAndView manageBeers()
	{
		ModelAndView model = new ModelAndView("managebeers");
		beerList(model);
		return model;
	}
	
	
	@RequestMapping(value="/manage/beers/edit/{id}")
	public ModelAndView editBeer(@PathVariable("id") int id)
	{
		
		ModelAndView model = new ModelAndView("managebeersedit");
		model.addObject("beer",beerService.getById(id));
		return model;
	}
	
	@RequestMapping(value="/manage/beers/edit/{id}/process")
	public ModelAndView editingBeer(@ModelAttribute("beer") Beers beer)
	{
		ModelAndView model = new ModelAndView("managebeers");
		try
		{
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			beer.setPub(user.getUsername());
			beerService.updateBeer(beer);
		}catch(Exception e)
		{
			System.out.println(e);
			
		}
		beerList(model);
		return model;
	}
	
	
	
	@RequestMapping(value="/manage/beers/add")
	public ModelAndView addBeer()
	{
		ModelAndView model = new ModelAndView("managebeersadd");
		model.addObject("beer",new Beers());
		return model;
	}
	
	@RequestMapping(value= "/manage/beers/add/process")
	public ModelAndView addinBeer(@ModelAttribute("beer") Beers beer)
	{
		ModelAndView model = new ModelAndView("managebeers");
		try
		{
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			beer.setPub(user.getUsername());
			beerService.createBeer(beer);
		}catch(Exception e)
		{
			System.out.println(e);
			return new ModelAndView("managebeers");
		}
		beerList(model);
		return model;
	}
	
	
	
	
	@RequestMapping(value="/manage/beers/delete/{id}")
	public ModelAndView manageDelete(@PathVariable Integer id)
	{
		ModelAndView model = new ModelAndView("managebeers");
		beerService.deleteBeer(id);
		beerList(model);
		return model;
	}
	
	
	
	@RequestMapping(value="/manage/info")
	public ModelAndView manageInfo()
	{
		ModelAndView model = new ModelAndView("manageinfo");
		return model;
	}
	
	
	
	//updating beerList
	private void beerList(ModelAndView model)
	{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Pubs pub = new Pubs();
		pub.setPub(user.getUsername());
		model.addObject("beerList",beerService.listFromPub(pub));
	
	}


}
