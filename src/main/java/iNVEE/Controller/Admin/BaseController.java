package iNVEE.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Service.User.HomeServiceImpl;

public class BaseController {
	@Autowired
	HomeServiceImpl HomeService;
	public ModelAndView _mvShare = new ModelAndView();
	
}
