package net.springjava.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.springjava.springmvc.service.PubService;
import net.springjava.springmvc.service.UsersService;

@Controller
public class FavController {

	List<String> list;
	@Autowired
	private UsersService userService;
	@Autowired
	private PubService pubService;
	
	
	@RequestMapping(value="/fav")
	public ModelAndView getFav()
	{
		ModelAndView model = new ModelAndView("fav");
		try{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		list = (List<String>) userService.getFavorite(user.getUsername());
		//System.out.println(list.get(0)+"dupacontroller");
		
		model.addObject("pubList",pubService.favList(list));
		}catch(Exception e)
		{
			
			System.out.println(e);
			return new ModelAndView("home");
		}
		return model;
	}
	
}
