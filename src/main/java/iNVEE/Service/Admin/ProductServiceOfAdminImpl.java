package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.ProductsDao;
import iNVEE.Dto.ProductDetailDto;
import iNVEE.Entity.ProductDetails;
import iNVEE.Entity.Products;
import iNVEE.Entity.Sizes;
@Service
public class ProductServiceOfAdminImpl implements IProductServiceOfAdmin{
	@Autowired
	private ProductsDao productsDao;
	@Autowired
	private ProductDetailDto productDetailDto;
	public List<Products> GetDataProduct() {
		return productsDao.GetDataProduct();
	}
	public List<ProductDetails> GetDataProductDetail(String id) {
		return productDetailDto.GetDataProductDetailByProductId(id);
	}
	public Products FindDataProductByProductId(String id) {
		return productsDao.FindDataProductByProductId(id);
	}
	public int AddNewProduct(Products product,HttpSession session) {
		return productsDao.AddNewProduct(product,session);
	}
	public int DeleteProduct(String id) {
		return productsDao.DeleteProduct(id);
	}
	public int UpdateProduct(Products product, String id,HttpSession session) {
		return productsDao.UpdateProduct(product, id, session);
	}
	public List<Sizes> GetDataSize(){
		return productsDao.GetDataSize();
	}
	public int AddProductInWarehouse(ProductDetails product, String proid) {
		return productsDao.AddProductInWarehouse(product,proid);
	}

}
