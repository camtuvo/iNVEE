package iNVEE.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Entity.ProductDetails;

@Service
public interface IProductDetailService {
	@Autowired
	public List<ProductDetails> GetDataProductsByProductId(String id);
}
