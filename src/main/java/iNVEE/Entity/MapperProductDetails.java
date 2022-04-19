package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductDetails implements RowMapper<ProductDetails> {
	public ProductDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDetails products = new ProductDetails();
		products.setID(rs.getString("ID"));
		products.setBrand(rs.getString("brand"));
		products.setCategory(rs.getString("category"));
		products.setName(rs.getString("name"));
		products.setPrice(rs.getDouble("price"));
		products.setImportprice(rs.getDouble("importprice"));
		products.setSizeid(rs.getString("sizeid"));
		products.setSize(rs.getString("size"));
		products.setQuantity(rs.getInt("quantity"));
		products.setDescription(rs.getString("description"));
		products.setPhoto(rs.getString("photo"));
		products.setStatus(rs.getInt("status"));
		products.setCreateddate(rs.getString("createddate"));
		products.setCreateby(rs.getString("createdby"));
		products.setModifiedby(rs.getString("modifiedby"));
		products.setModifieddate(rs.getString("modifieddate"));
		return products;
	}
}
