package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductInBillDetails implements RowMapper<ProductInBillDetails> {

	public ProductInBillDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductInBillDetails product = new ProductInBillDetails();
		product.setID(rs.getString("ID"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setQuantity(rs.getInt("quantity"));
		product.setSize(rs.getString("size"));
		return product;
	}

}
