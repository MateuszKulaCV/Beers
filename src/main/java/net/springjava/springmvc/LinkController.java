package net.springjava.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.springjava.springmvc.service.BeerService;
import net.springjava.springmvc.service.PubService;

@Controller
public class LinkController {

	@Autowired
	private BeerService beerService;
	@Autowired
	private PubService pubService;
	
	//default controller
	@RequestMapping(value="/")
	public ModelAndView home()
	{
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	
	@RequestMapping(value="/find")
	@ResponseBody
	public ModelAndView find()
	{
		ModelAndView model = new ModelAndView("find");
		model.addObject("beerList",beerService.list());
		model.addObject("pubList",pubService.list());
		return model;
	}
}
