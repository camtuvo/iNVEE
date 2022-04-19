package iNVEE.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Entity.Products;

@Service
public interface IProductsService {
	@Autowired
	public Products GetDataProductsByProductId(String id);
	@Autowired
	public List<Products> GetDataProductsPaginateByAscePrice(int start, int totalPage);
	@Autowired
	public List<Products> GetDataProductsPaginateByDescPrice(int start, int totalPage);
}
