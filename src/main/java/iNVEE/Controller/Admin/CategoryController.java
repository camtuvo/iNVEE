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
import iNVEE.Service.Admin.CategoryServiceOfAdminImpl;

@Controller(value = "categoryOfAdminController")
public class CategoryController extends BaseController {


	@Autowired
	private CategoryServiceOfAdminImpl CategoryServiceOfAdmin;

	@RequestMapping(value = { "/admin/category" })
	public ModelAndView Category() {
		_mvShare.setViewName("admin/category");
		_mvShare.addObject("categories", CategoryServiceOfAdmin.GetDataCategoryForAdmin());
		return _mvShare;
	}

	@RequestMapping(value = { "/admin/category/add" },method = RequestMethod.GET)
	public ModelAndView AddCategory() {
		_mvShare.setViewName("admin/addNewCategory");
		_mvShare.addObject("category", new Categories());
		return _mvShare;
	}
	@RequestMapping(value = { "/admin/category/add" },method = RequestMethod.POST)
	public String RAddCategory(@ModelAttribute("category") Categories category,HttpSession session) {
		_mvShare.setViewName("admin/addNewCategory");
		int check = CategoryServiceOfAdmin.AddNewCategory(category,session);
		if(check > 0) {
			_mvShare.addObject("Status","Thêm thành công!");
			return "redirect:/admin/category";
		}else {
			_mvShare.addObject("Status","Thêm không thành công!");
			return "redirect:/admin/category";
		}
		
	}

	@RequestMapping(value = { "/admin/category/delete/{id}" }, method = RequestMethod.GET)
	public String ReloadDel(@PathVariable String id) {
		int check = CategoryServiceOfAdmin.DeleleCategory(id);
		if (check > 0) {
			return "redirect:/admin/category";
		} else {
			return "redirect:/admin/category";
		}
	}

	@RequestMapping(value = { "/admin/category/edit/{id}" },method = RequestMethod.GET)
	public ModelAndView EditCat(@PathVariable String id) {
		_mvShare.setViewName("admin/editCategory");
		_mvShare.addObject("currentCategory",CategoryServiceOfAdmin.FindCategoryByID(id));
		_mvShare.addObject("category", new Categories());
		return _mvShare;

	}
	@RequestMapping(value = { "/admin/category/edit/{id}" },method = RequestMethod.POST)
	public String ReEditCat(@PathVariable String id,@ModelAttribute("category") Categories category,HttpSession session) {
		_mvShare.setViewName("admin/editCategory");
		_mvShare.addObject("CategoryId", id);
		int check = CategoryServiceOfAdmin.UpdateCategory(category,id,session);
		if(check > 0) {
			_mvShare.addObject("Status","Cập nhật thành công!");
			return "redirect:/admin/category";
		}else {
			_mvShare.addObject("Status","Cập nhật không thành công!");
			return "redirect:/admin/category";
		}

	}
}
