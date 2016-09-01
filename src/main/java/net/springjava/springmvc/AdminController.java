package net.springjava.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping(value="/admin")
	public ModelAndView admin()
	{
		ModelAndView model = new ModelAndView("admin");
		return model;
	}

}	
