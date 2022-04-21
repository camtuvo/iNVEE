package iNVEE.Controller.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Entity.Brands;
import iNVEE.Entity.Users;
import iNVEE.Service.Admin.BrandServiceOfAdminImpl;

@Controller(value = "brandOfAdminController")
public class BrandController extends BaseController {

    @Autowired
    private BrandServiceOfAdminImpl BrandServiceOfAdmin;

    @RequestMapping(value = {"/admin/brand"})
    public ModelAndView Brand(HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
        if (loginInfo != null) {
            _mvShare.setViewName("admin/brand");
            _mvShare.addObject("brands", BrandServiceOfAdmin.GetDataBrandForAdmin());
            return _mvShare;
        } else {
            _mvShare.setViewName("redirect:/admin/login");
            return _mvShare;
        }
    }

    @RequestMapping(value = {"/admin/brand/add"}, method = RequestMethod.GET)
    public ModelAndView AddBrand(HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
        if (loginInfo != null) {
            _mvShare.setViewName("admin/addNewBrand");
            _mvShare.addObject("brand", new Brands());
            return _mvShare;
        } else {
            _mvShare.setViewName("redirect:/admin/login");
            return _mvShare;
        }

    }

    @RequestMapping(value = {"/admin/brand/add"}, method = RequestMethod.POST)
    public String RAddBrand(@ModelAttribute("brand") Brands brand, HttpSession session) {
        _mvShare.setViewName("admin/addNewBrand");
        int check = BrandServiceOfAdmin.AddNewBrand(brand, session);
        if (check > 0) {
            _mvShare.addObject("Status", "Thêm thành công!");
            return "redirect:/admin/brand";
        } else {
            _mvShare.addObject("Status", "Thêm không thành công!");
            return "redirect:/admin/brand";
        }

    }

    @RequestMapping(value = {"/admin/brand/delete/{id}"}, method = RequestMethod.GET)
    public String ReloadDel(@PathVariable String id) {
        int check = BrandServiceOfAdmin.DeleleBrand(id);
        if (check > 0) {
            return "redirect:/admin/brand";
        } else {
            return "redirect:/admin/brand";
        }
    }

    @RequestMapping(value = {"/admin/brand/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView EditCat(@PathVariable String id) {
        _mvShare.setViewName("admin/editBrand");
        _mvShare.addObject("currentBrand", BrandServiceOfAdmin.FindBrandByID(id));
        _mvShare.addObject("brand", new Brands());
        return _mvShare;

    }

    @RequestMapping(value = {"/admin/brand/edit/{id}"}, method = RequestMethod.POST)
    public String ReEditCat(@PathVariable String id, @ModelAttribute("brand") Brands brand, HttpSession session) {
        _mvShare.setViewName("admin/editBrand");
        _mvShare.addObject("BrandId", id);
        int check = BrandServiceOfAdmin.UpdateBrand(brand, id, session);
        if (check > 0) {
            _mvShare.addObject("Status", "Cập nhật thành công!");
            return "redirect:/admin/brand";
        } else {
            _mvShare.addObject("Status", "Cập nhật không thành công!");
            return "redirect:/admin/brand";
        }

    }

}
