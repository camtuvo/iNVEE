package iNVEE.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Entity.Products;

@Service
public interface IBrandService {
	@Autowired
	public List<Products> GetDataProductsOfBrandPaginate(String id, int start, int totalPage);

	public List<Products> GetDataProductsPaginate(int start, int totalPage);

	public List<Products> GetDataProductByCategoryId(String id);

}
