package iNVEE.Service.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Entity.Slides;

@Service
public interface IHomeServiceOfAdmin {
	@Autowired
	public int getQuantityNewOrders();
	public int getQuantityProducts();
	public int getQuantityCustomers();
	public int getQuantityEmployees();
	
	public int addNewSlide(Slides slide,HttpSession session);
	public int UpdateSlide(Slides slide,String id,HttpSession session);
	public int DeleteSlide(String id);
}
