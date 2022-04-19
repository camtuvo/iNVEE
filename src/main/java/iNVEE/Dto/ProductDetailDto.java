package iNVEE.Dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import iNVEE.Entity.MapperProductDetails;
import iNVEE.Entity.MapperProducts;
import iNVEE.Entity.ProductDetails;
import iNVEE.Entity.Products;

@Repository
public class ProductDetailDto {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	private String SqlString() {
		String sql = "SELECT p.ID, b.name as brand ,c.name as category,p.name , p.importprice, p.price ,s.ID as sizeid,s.name as size,sd.quantity as quantity ,p.description,p.photo,p.status,p.createddate ,p.createdby ,p.modifieddate ,p.modifiedby FROM product as p INNER JOIN sizedetail as sd on p.ID = sd.productid INNER JOIN size as s on s.ID = sd.sizeid INNER JOIN productcategory as c on p.categoryid = c.ID INNER JOIN productbrand as b on b.ID = p.brandid";
		return sql;
	}

	private String SqlProductsByProductId(String id) {
		String sql = SqlString() + " where 1 = 1 and p.ID = '" + id + "'";
		return sql;
	}

	private String SqlProductsByProductIdAndSize(String id, String size) {
		String sql = SqlString() + " where 1 = 1 and p.ID = '" + id + "' and s.name= '" + size + "'";
		return sql;
	}

	public List<ProductDetails> GetDataProductDetailByProductId(String id) {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		String sql = SqlProductsByProductId(id);
		list = _jdbcTemplate.query(sql, new MapperProductDetails());
		return list;
	}

	public ProductDetails FindDataProductDetail(String id, String size) {
		ProductDetails pro = new ProductDetails();
		String sql = SqlProductsByProductIdAndSize(id, size);
		pro = _jdbcTemplate.queryForObject(sql, new MapperProductDetails());
		return pro;
	}

	public ProductDetails FindDataProductDetail(String id) {
		ProductDetails pro = new ProductDetails();
		String sql = SqlProductsByProductId(id);
		pro = _jdbcTemplate.queryForObject(sql, new MapperProductDetails());
		return pro;
	}

}
