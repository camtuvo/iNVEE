package iNVEE.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dto.ProductDetailDto;
import iNVEE.Entity.ProductDetails;
import iNVEE.Entity.Products;
@Service
public class ProductDetailsServiceImpl implements IProductDetailService {
	@Autowired
	private ProductDetailDto productDetail;

	public List<ProductDetails> GetDataProductsByProductId(String id) {
		return productDetail.GetDataProductDetailByProductId(id);
	}

}
