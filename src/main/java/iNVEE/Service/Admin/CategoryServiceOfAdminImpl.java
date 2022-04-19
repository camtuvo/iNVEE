package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.CategoriesDao;
import iNVEE.Dao.ProductsDao;
import iNVEE.Entity.Categories;
import iNVEE.Entity.Products;

@Service
public class CategoryServiceOfAdminImpl implements ICategoryServiceOfAdmin {
	@Autowired
	private CategoriesDao categoriesDao;
	
	public int DeleleCategory(String id){
		return categoriesDao.DeleteCategory(id);
	}

	public int AddNewCategory(Categories category,HttpSession session) {
		return categoriesDao.AddNewCategory(category,session);
	}

	public int UpdateCategory(Categories category, String id,HttpSession session) {
		return categoriesDao.UpdateCategory(category, id,session);
	}

	public Categories FindCategoryByID(String id) {
		return categoriesDao.FindCategoryByID(id);
	}

	public List<Categories> GetDataCategoryForAdmin() {
		return categoriesDao.GetDataCategoryForAdmin();
	}
	public List<Categories> GetDataCategory() {
		return categoriesDao.GetDataCategory();
	}


}
