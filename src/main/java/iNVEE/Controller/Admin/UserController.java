package iNVEE.Controller.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Entity.Users;
import iNVEE.Service.Admin.UserServiceOfAdminImpl;

@Controller(value = "userOfAdminController")
public class UserController extends BaseController {

    @Autowired
    private UserServiceOfAdminImpl userServiceOfAdmin;

    @RequestMapping(value = {"/admin/customer"})
    public ModelAndView Customer(HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
        if (loginInfo != null) {
            _mvShare.setViewName("admin/customer");
            _mvShare.addObject("customer", userServiceOfAdmin.GetDataCustomer());
            return _mvShare;
        } else {
            _mvShare.setViewName("redirect:/admin/login");
            return _mvShare;
        }

    }

    @RequestMapping(value = {"/admin/employee"})
    public ModelAndView Employee(HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
        if (loginInfo != null) {
            _mvShare.setViewName("admin/employee");
        _mvShare.addObject("employee", userServiceOfAdmin.GetDataEmployee());
        return _mvShare;
        } else {
            _mvShare.setViewName("redirect:/admin/login");
            return _mvShare;
        }
    }

    @RequestMapping(value = {"/admin/employee/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView UpdateEmployee(@PathVariable String id) {
        _mvShare.setViewName("admin/editEmployee");
        _mvShare.addObject("currentEmployee", userServiceOfAdmin.FindEmployeeByID(id));
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/employee/edit/{id}"}, method = RequestMethod.POST)
    public String PUpdateEmployee(@PathVariable String id, @ModelAttribute("employee") Users user, HttpSession session) {
        _mvShare.setViewName("admin/editEmployee");
        int check = userServiceOfAdmin.UpdateUser(user, id, session);
        if (check > 0) {
            _mvShare.addObject("Status", "Cập nhật thành công!");
            return "redirect:/admin/employee";
        } else {
            _mvShare.addObject("Status", "Cập nhật không thành công!");
            return "redirect:/admin/employee";
        }
    }

    @RequestMapping(value = {"/admin/employee-details/{id}"})
    public ModelAndView EmployeeDetails(@PathVariable String id) {
        _mvShare.setViewName("admin/employeeDetails");
        _mvShare.addObject("employee", userServiceOfAdmin.FindEmployeeByID(id));
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/customer/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView UpdateCustomer(@PathVariable String id) {
        _mvShare.setViewName("admin/editCustomer");
        _mvShare.addObject("currentCustomer", userServiceOfAdmin.FindCustomerByID(id));
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/customer/edit/{id}"}, method = RequestMethod.POST)
    public String PUpdateCustomer(@PathVariable String id, @ModelAttribute("customer") Users user, HttpSession session) {
        _mvShare.setViewName("admin/editCustomer");
        _mvShare.addObject("currentCustomer", id);
        int check = userServiceOfAdmin.UpdateUser(user, id, session);
        if (check > 0) {
            _mvShare.addObject("Status", "Cập nhật thành công!");
            return "redirect:/admin/customer";
        } else {
            _mvShare.addObject("Status", "Cập nhật không thành công!");
            return "redirect:/admin/customer";
        }
    }

    @RequestMapping(value = {"/admin/customer-details/{id}"})
    public ModelAndView CustomerDetails(@PathVariable String id) {
        _mvShare.setViewName("admin/employeeDetails");
        _mvShare.addObject("employee", userServiceOfAdmin.FindCustomerByID(id));
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/decentralization"})
    public ModelAndView Decentralization() {
        _mvShare.setViewName("admin/decentralization");
        _mvShare.addObject("employee", userServiceOfAdmin.GetDataEmployee());
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/active/{id}"}, method = RequestMethod.GET)
    public ModelAndView ActiveEmployee(@PathVariable String id, HttpSession session) {

        userServiceOfAdmin.ActiveEmployee(id, session);
        _mvShare.setViewName("redirect:/admin/decentralization");
        return _mvShare;
    }

    @RequestMapping(value = "/admin/register", method = RequestMethod.GET)
    public ModelAndView Register() {
        _mvShare.setViewName("admin/register");
        _mvShare.addObject("user", new Users());
        return _mvShare;
    }

    @RequestMapping(value = "/admin/register", method = RequestMethod.POST)
    public ModelAndView CreateAccount(HttpSession session, @ModelAttribute("user") Users user) throws Exception {
        int count = userServiceOfAdmin.AddAccountAdmin(user);
        if (count != 0) {

            _mvShare.setViewName("redirect:/admin/successregister");

        } else {

            _mvShare.setViewName("redirect:/admin/register");
        }
        return _mvShare;
    }

    @RequestMapping(value = "/admin/successregister", method = RequestMethod.GET)
    public ModelAndView showNotification() {
        _mvShare.setViewName("admin/successRegister");
        return _mvShare;
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public ModelAndView viewLogin() {
        _mvShare.setViewName("admin/login");
        _mvShare.addObject("user", new Users());
        return _mvShare;
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users user) {
        user = userServiceOfAdmin.CheckAccountAdmin(user);
        if (user != null) {

            _mvShare.setViewName("redirect:/admin/homepage");
            session.setAttribute("LoginInforOfAdmin", user);

            return _mvShare;

        } else {

            _mvShare.setViewName("redirect:/admin/login");
            return _mvShare;
        }

    }

    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String Logout(HttpSession session) {
        session.removeAttribute("LoginInforOfAdmin");
        return "redirect:/admin/login";
    }
}
