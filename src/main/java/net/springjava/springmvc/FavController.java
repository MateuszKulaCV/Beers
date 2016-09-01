package net.springjava.springmvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.springjava.springmvc.model.Beers;
import net.springjava.springmvc.model.Pubs;
import net.springjava.springmvc.service.BeerService;
import net.springjava.springmvc.service.PubService;
import net.springjava.springmvc.service.UsersService;

@Controller
public class FavController {

	List<String> list;
	@Autowired
	private UsersService userService;
	@Autowired
	private PubService pubService;
	@Autowired
	private BeerService beerService;
	
	
	
	@RequestMapping(value="/fav")
	public ModelAndView getFav()
	{
		ModelAndView model = new ModelAndView("fav");
		try{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Map<Pubs,List<Beers>> out = new HashMap<Pubs,List<Beers>>();		
		
		
		list = (List<String>) userService.getFavorite(user.getUsername());
		List<Pubs> pubs = pubService.favList(list);
		for(Pubs p:pubs)
		{
			out.put(p, beerService.listFromPub(p));
		}
		
		
		model.addObject("out",out);
		}catch(Exception e)
		{
			
			System.out.println(e);
			return new ModelAndView("home");
		}
		return model;
	}
	
}
