package iNVEE.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.CategoriesDao;
import iNVEE.Dao.ProductsDao;
import iNVEE.Dao.SlidesDao;
import iNVEE.Entity.Categories;
import iNVEE.Entity.Products;
import iNVEE.Entity.Slides;
@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategoriesDao categoriesDao;
	@Autowired
	private ProductsDao productsDao;
	
	public List<Slides> GetDataSlide() {
		return slidesDao.GetDataSlide();
	}
	public List<Categories> GetDataCategory() {
		return categoriesDao.GetDataCategory();
	}
	public List<Products> GetDataProduct(){
		return productsDao.GetDataProduct();
		
	}

}
