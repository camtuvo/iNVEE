package iNVEE.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.ProductsDao;
import iNVEE.Entity.Products;
@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private ProductsDao productsDao;
	
	public List<Products> GetDataProductsOfCategoryPaginate(String id, int start, int totalPage){
		return productsDao.GetDataProductsOfCategoryPaginate(id, start, totalPage);
	}
	public List<Products> GetDataProductsPaginate(int start, int totalPage){
		return productsDao.GetDataProductsPaginate(start, totalPage);
	}

	public List<Products> GetDataProductByCategoryId(String id) {
		return productsDao.GetDataProductByCategoryId(id);
	}

	
}
