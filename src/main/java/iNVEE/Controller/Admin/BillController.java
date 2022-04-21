package iNVEE.Controller.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Entity.Bills;
import iNVEE.Entity.Users;
import iNVEE.Service.Admin.BillServiceOfAdminImpl;

@Controller(value = "billOfAdminController")
public class BillController extends BaseController {

    @Autowired
    BillServiceOfAdminImpl billServiceOfAdmin;

    @RequestMapping(value = {"/admin/order"})
    public ModelAndView Order(HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
        if (loginInfo != null) {
            _mvShare.setViewName("admin/order");
            _mvShare.addObject("bills", billServiceOfAdmin.GetDataBills());
            return _mvShare;
        } else {
            _mvShare.setViewName("redirect:/admin/login");
            return _mvShare;
        }
    }

    @RequestMapping(value = {"/admin/order/order-detail/{id}"})
    public ModelAndView OrderDetail(@PathVariable String id) {
        _mvShare.setViewName("admin/orderDetails");
        _mvShare.addObject("bill", billServiceOfAdmin.GetBillsByID(id));
        _mvShare.addObject("infoCustomer", billServiceOfAdmin.GetInfoCustomerByIDBills(id));
        _mvShare.addObject("productDetais", billServiceOfAdmin.GetProductDetailByIDBills(id));
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/complete-bill/{id}"}, method = RequestMethod.GET)
    public ModelAndView CompleteBill(@PathVariable String id) {
        _mvShare.setViewName("admin/completeOrder");
        _mvShare.addObject("bill", new Bills());
        _mvShare.addObject("idBill", id);
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/complete-bill/{id}"}, method = RequestMethod.POST)
    public ModelAndView CompleteBill(@PathVariable String id, @ModelAttribute("bill") Bills bill, HttpSession session) {
        bill.setID(id);
        int check = billServiceOfAdmin.CompleteBill(bill, id, session);
        _mvShare.setViewName("redirect:/admin/order");

        return _mvShare;
    }
}
