package net.springjava.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

	
	@RequestMapping(value="/")
	public ModelAndView home()
	{
		ModelAndView model = new ModelAndView("home");
		return model;
	}
}
