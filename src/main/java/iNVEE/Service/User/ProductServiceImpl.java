package iNVEE.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.ProductsDao;
import iNVEE.Entity.Products;

@Service

public class ProductServiceImpl implements IProductsService {
	@Autowired
	private ProductsDao productsDao;

	public Products GetDataProductsByProductId(String id) {
	List<Products> list =  productsDao.GetDataProductByProductId(id);	
		return list.get(0);
	}

	public List<Products> GetDataProductsPaginateByAscePrice(int start, int totalPage) {
		return productsDao.GetDataProductsPaginateByAscePrice(start, totalPage);
	}

	public List<Products> GetDataProductsPaginateByDescPrice(int start, int totalPage) {
		return productsDao.GetDataProductsPaginateByDescPrice(start, totalPage);
	}

}
