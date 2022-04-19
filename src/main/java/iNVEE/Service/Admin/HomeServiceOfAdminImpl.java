package iNVEE.Service.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.BaseDao;
import iNVEE.Dao.SlidesDao;
import iNVEE.Entity.Slides;
import iNVEE.Entity.Users;

@Service
public class HomeServiceOfAdminImpl {
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private SlidesDao slidesDao;
	public int getQuantityNewOrders() {
		return baseDao.getQuantityNewOrders();
	}
	public int getQuantityProducts() {
		return baseDao.getQuantityProducts();
	}
	public int getQuantityCustomers() {
		return baseDao.getQuantityCustomers();
	}
	public int getQuantityEmployees() {
		return baseDao.getQuantityEmployees();
	}
	public int addNewSlide(Slides slide,HttpSession session) {
		return slidesDao.AddNewSlide(slide, session);
	}
	public int UpdateSlide(Slides slide,String id,HttpSession session) {
		return slidesDao.UpdateSlide(slide, id, session);
	}
	public int DeleteSlide(String id) {
		return slidesDao.DeleteSlide(id);
	}
	public Slides FindSlideByID(String id) {
		return slidesDao.FindSlideByID(id);
	}
}
