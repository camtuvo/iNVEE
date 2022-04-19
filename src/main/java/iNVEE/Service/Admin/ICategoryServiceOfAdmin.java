package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Entity.Categories;
import iNVEE.Entity.Products;

@Service
public interface ICategoryServiceOfAdmin {
	@Autowired
	public int DeleleCategory(String id);
	public List<Categories> GetDataCategoryForAdmin();
	public List<Categories> GetDataCategory();
	public int AddNewCategory(Categories category,HttpSession session);
	public int UpdateCategory(Categories category, String id,HttpSession session);
	public Categories FindCategoryByID(String id);
	
}
