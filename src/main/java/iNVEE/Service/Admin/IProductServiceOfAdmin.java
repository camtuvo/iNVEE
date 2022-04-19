package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iNVEE.Entity.ProductDetails;
import iNVEE.Entity.Products;
import iNVEE.Entity.Sizes;
@Service
public interface IProductServiceOfAdmin {
	@Autowired
	public List<Products> GetDataProduct();
	public List<ProductDetails> GetDataProductDetail(String id);
	public Products FindDataProductByProductId(String id);
	public int AddNewProduct(Products product,HttpSession session);
	public int DeleteProduct(String id);
	public int UpdateProduct(Products product, String id,HttpSession session);
	public List<Sizes> GetDataSize();
	public int AddProductInWarehouse(ProductDetails product,String proid);
}
