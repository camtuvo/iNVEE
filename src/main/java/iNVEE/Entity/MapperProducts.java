package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProducts implements RowMapper<Products> {
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();
		products.setID(rs.getString("ID"));
		products.setBrand(rs.getString("brand"));
		products.setCategory(rs.getString("category"));
		products.setName(rs.getString("name"));
		products.setPrice(rs.getDouble("price"));
		products.setImportprice(rs.getDouble("importprice"));
		products.setDescription(rs.getString("description"));
		products.setPhoto(rs.getString("photo"));
		products.setStatus(rs.getInt("status"));
		products.setCreateddate(rs.getString("createddate"));
		products.setCreatedby(rs.getString("createdby"));
		products.setModifiedby(rs.getString("modifiedby"));
		products.setModifieddate(rs.getString("modifieddate"));
		return products;
	}
}
