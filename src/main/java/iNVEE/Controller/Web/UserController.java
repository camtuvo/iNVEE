package iNVEE.Controller.Web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import iNVEE.Entity.Users;
import iNVEE.Service.User.AccountServiceImpl;


@Controller
public class UserController extends BaseController {
	
	@Autowired
	private AccountServiceImpl userAccountService = new AccountServiceImpl();	
	@RequestMapping(value="account/register", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("web/register");
		_mvShare.addObject("user",new Users());
		return _mvShare;
	}
	
	@RequestMapping(value="account/register", method = RequestMethod.POST)
	public ModelAndView CreateAccount(HttpSession session,@ModelAttribute("user") Users user) throws Exception {
		int count = userAccountService.AddAccount(user);
		if (count != 0) {
			_mvShare.addObject("Status", "Đăng ký tài khoản thành công");
			_mvShare.setViewName("web/homePage");
			_mvShare.addObject("slides", HomeService.GetDataSlide());
			session.setAttribute("LoginInfor", user);
		} else {
			_mvShare.addObject("Status", "Đăng ký tài khoản không thành công");
			_mvShare.setViewName("web/register");
		}	
		return _mvShare;
	}
	
	
	@RequestMapping(value = "account/login", method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		_mvShare.setViewName("web/login");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "account/login", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users user) {
		user = userAccountService.CheckAccount(user);
		if (user != null) {
			_mvShare.setViewName("web/homePage");
			_mvShare.addObject("slides", HomeService.GetDataSlide());
			 session.setAttribute("LoginInfor", user);
			 
			
		} else if(user == null) {
			_mvShare.addObject("Statuslogin", "Đăng nhập không thành công");
			_mvShare.setViewName("web/login");
			
		}

		return _mvShare;
	}

	/*
	 * @RequestMapping(value = "account/logout", method = RequestMethod.GET) public
	 * ModelAndView Login(HttpSession session, HttpServletRequest request) {
	 * session.removeAttribute("LoginInfor"); _mvShare.setViewName("web/homePage");
	 * return _mvShare; }
	 */
	@RequestMapping(value = "account/logout", method = RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfor");
		session.removeAttribute("ShoppingCart");
		return "redirect:/homepage";
	}
}