package iNVEE.Controller.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Dao.SlidesDao;
import iNVEE.Service.User.HomeServiceImpl;

@Controller(value="homeOfWebController")
public class HomeController {
	@Autowired
	HomeServiceImpl HomeService;
	
	@RequestMapping(value = { "/", "/homepage" })
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("web/homePage");
		mv.addObject("slides", HomeService.GetDataSlide());
		
		return mv;
	}
	@RequestMapping(value = "/about-us")
	public ModelAndView AboutUs() {
		ModelAndView mv = new ModelAndView("web/aboutUs");
		return mv;
	}
	@RequestMapping(value = "/contact")
	public ModelAndView Contact() {
		ModelAndView mv = new ModelAndView("web/contact");
		return mv;
	}
	@RequestMapping(value = "/account/login")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView("web/login");
		return mv;
	}
	

	
	
}
