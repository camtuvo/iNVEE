package iNVEE.Controller.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Entity.Categories;
import iNVEE.Entity.Slides;
import iNVEE.Entity.Users;
import iNVEE.Service.Admin.HomeServiceOfAdminImpl;
import iNVEE.Service.Admin.UserServiceOfAdminImpl;
import iNVEE.Service.User.HomeServiceImpl;

@Controller(value = "homeOfAdminController")
public class HomeController extends BaseController {
	@Autowired
	private HomeServiceOfAdminImpl homeServiceOfAdmin;
	@Autowired
	private HomeServiceImpl homeServiceOfWeb;
	@Autowired
	private UserServiceOfAdminImpl userServiceOfAdmin;

	@RequestMapping(value = { "/admin/homepage" })
	public ModelAndView Home() {
		_mvShare.setViewName("admin/homePage");
		_mvShare.addObject("QuantityNewOrders", homeServiceOfAdmin.getQuantityNewOrders());
		_mvShare.addObject("QuantityProducts", homeServiceOfAdmin.getQuantityProducts());
		_mvShare.addObject("QuantityCustomers", homeServiceOfAdmin.getQuantityCustomers());
		_mvShare.addObject("QuantityEmployees", homeServiceOfAdmin.getQuantityEmployees());
		return _mvShare;

	}

	@RequestMapping(value = { "/admin/register" })
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView("admin/register");
		return mv;
	}

	@RequestMapping(value = { "/admin/profile" }, method = RequestMethod.GET)
	public ModelAndView Profile(HttpSession session) {
		_mvShare.setViewName("admin/profile");
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		_mvShare.addObject("currentEmployee", userServiceOfAdmin.FindEmployeeByID(loginInfo.getID()));
		_mvShare.addObject("employee", new Users());
		return _mvShare;

	}

	@RequestMapping(value = { "/admin/profile/edit" }, method = RequestMethod.POST)
	public String PProfile(@ModelAttribute("employee") Users user, HttpSession session) {
		_mvShare.setViewName("admin/profile");
		int check = userServiceOfAdmin.UpdateProfileEmployee(user, session);
		if (check > 0) {
			_mvShare.addObject("Status", "Cập nhật thành công!");
			return "redirect:/admin/profile";
		} else {
			_mvShare.addObject("Status", "Cập nhật không thành công!");
			return "redirect:/admin/profle";
		}

	}

	@RequestMapping(value = { "/admin/404" })
	public ModelAndView Error() {
		ModelAndView mv = new ModelAndView("admin/404");
		return mv;
	}

	@RequestMapping(value = { "/admin/slider" })
	public ModelAndView Sliders() {
		_mvShare.setViewName("admin/slider");
		_mvShare.addObject("Slides", homeServiceOfWeb.GetDataSlide());
		return _mvShare;
	}

	@RequestMapping(value = { "/admin/slider/add" }, method = RequestMethod.GET)
	public ModelAndView AddSlider() {
		_mvShare.setViewName("admin/addNewSlider");
		_mvShare.addObject("slide", new Slides());
		return _mvShare;
	}

	@RequestMapping(value = { "/admin/slider/add" }, method = RequestMethod.POST)
	public String RAddSlider(@ModelAttribute("slide") Slides slide, HttpSession session) {
		_mvShare.setViewName("admin/addNewSlider");

		/*
		 * if (photo.isEmpty()) { model.addAttribute("message", "chosse img"); } else {
		 * try { String path = context.getRealPath("/template/web/img/bg-img/" +
		 * photo.getOriginalFilename()); photo.transferTo(new File(path));
		 * 
		 * } catch (Exception e) { model.addAttribute("message", "error save file!"); }
		 * }
		 */
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		if (loginInfo == null || loginInfo.getIsadmin() != 2) {
			return "redirect:/admin/login";
		}
		int check = homeServiceOfAdmin.addNewSlide(slide, session);
		if (check > 0) {
			_mvShare.addObject("Status", "Thêm mới thành công!");
			return "redirect:/admin/slider";
		} else {
			_mvShare.addObject("Status", "Thêm thất bại!");
			return "redirect:/admin/slider";
		}

	}

	@RequestMapping(value = { "/admin/slide/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView EditSlider(@PathVariable String id) {
		_mvShare.setViewName("admin/editSlider");
		_mvShare.addObject("currentSlider", homeServiceOfAdmin.FindSlideByID(id));
		_mvShare.addObject("slider", new Slides());
		return _mvShare;

	}

	@RequestMapping(value = { "/admin/slide/edit/{id}" }, method = RequestMethod.POST)
	public String ReEditSlider(@PathVariable String id, @ModelAttribute("slider") Slides slider,
			HttpSession session) {
		_mvShare.setViewName("admin/editSlider");
		
		int check = homeServiceOfAdmin.UpdateSlide(slider, id, session);
		if (check > 0) {
			_mvShare.addObject("Status", "Cập nhật thành công!");
			return "redirect:/admin/slider";
		} else {
			_mvShare.addObject("Status", "Cập nhật không thành công!");
			return "redirect:/admin/slider";
		}

	}

	@RequestMapping(value = { "/admin/slide/delete/{id}" }, method = RequestMethod.GET)
	public String DeleteSlide(@PathVariable String id) {
		int check = homeServiceOfAdmin.DeleteSlide(id);
		if (check > 0) {
			return "redirect:/admin/slider";
		} else {
			return "redirect:/admin/slider";
		}
	}

}
