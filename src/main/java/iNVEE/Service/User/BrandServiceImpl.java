package iNVEE.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.BrandsDao;
import iNVEE.Dao.ProductsDao;
import iNVEE.Entity.Brands;
import iNVEE.Entity.Products;


@Service
public class BrandServiceImpl {
	@Autowired
	private BrandsDao brandsDao;
	@Autowired
	private ProductsDao productsDao;
	
	public List<Brands> GetDataBrand() {
		return brandsDao.GetDataBrand();
	}
	public List<Products> GetDataProductsOfBrandPaginate(String id, int start, int totalPage){
		return productsDao.GetDataProductsOfBrandPaginate(id, start, totalPage);
	}
	public List<Products> GetDataProductsPaginate(int start, int totalPage){
		return productsDao.GetDataProductsPaginate(start, totalPage);
	}

	public List<Products> GetDataProductByBrandId(String id) {
		return productsDao.GetDataProductByBrandId(id);
	}

	
}
