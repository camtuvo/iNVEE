package iNVEE.Controller.Web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Dto.CartDto;
import iNVEE.Entity.Bills;
import iNVEE.Entity.Users;
import iNVEE.Service.User.BillServiceImpl;
import iNVEE.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillServiceImpl billServiceImpl = new BillServiceImpl();

	@RequestMapping(value = "/cart")
	public ModelAndView Cart() {
		ModelAndView mv = new ModelAndView("web/cart");
		return mv;
	}

	@RequestMapping(value = "/cart/add-cart/id={id}&quantity={quantity}")
	public String AddCart(HttpSession session, @PathVariable String id,
			@PathVariable int quantity) {

		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("ShoppingCart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCart(id, quantity, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("TotalQuantityCart", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:/product-details/" + id;

	}

	@RequestMapping(value = "/cart/edit-cart/id={id}")
	public String EditCart(HttpSession session, @PathVariable String id) {

		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("ShoppingCart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.EditCart(id, 0, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("TotalQuantityCart", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:/cart";

	}

	@RequestMapping(value = "/cart/delete-cart/id={id}")
	public String DeleteCart(HttpSession session, @PathVariable String id) {

		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("ShoppingCart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("TotalQuantityCart", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:/cart";

	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("web/checkout");
		Bills bill = new Bills();
		Users loginInfo = (Users) session.getAttribute("LoginInfor");
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("ShoppingCart");
		if (loginInfo != null) {
			if(cart != null) {
				bill.setDeliverto(loginInfo.getAddress());
				bill.setCustomerid(loginInfo.getID());
				bill.setPhone(loginInfo.getPhone());
				bill.setEmail(loginInfo.getEmail());
				bill.setTotalprice((Double) session.getAttribute("TotalPriceCart"));
				_mvShare.addObject("nameCustomer",loginInfo.getName());
				_mvShare.addObject("bill", bill);
				return _mvShare;
			} else {
				_mvShare.setViewName("redirect:/product");
				return _mvShare;
			}
			
		} else {
			
			_mvShare.setViewName("redirect:/account/login");
			return _mvShare;
		}

	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView CheckoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bills bills) {
		try {
			int check = billServiceImpl.AddBills(bills);
			if (check > 0) {
				HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>) session.getAttribute("ShoppingCart"); 
				billServiceImpl.AddBillDetail(carts);
				
			}
			session.removeAttribute("ShoppingCart");
			session.removeAttribute("TotalPriceCart");
			session.removeAttribute("TotalQuantityCart");
			_mvShare.setViewName("redirect:/success");
			return _mvShare;
		} catch (Exception e) {	
			_mvShare.addObject("status","Số lượng mua lớn hơn trong kho!");
			_mvShare.setViewName("web/cart");
			return _mvShare;
		}
		

	}
	
	@RequestMapping(value = "/success")
	public ModelAndView SuccessOrder() {
		_mvShare.setViewName("web/successOrder");
		return _mvShare;
	}
}
