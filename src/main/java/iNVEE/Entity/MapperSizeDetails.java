package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSizeDetails implements RowMapper<SizeDetails>{

	public SizeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		SizeDetails sizeDetails = new SizeDetails();
		sizeDetails.setID(rs.getString("ID"));
		sizeDetails.setProductid(rs.getString("productid"));
		sizeDetails.setQuantity(rs.getInt("quantity"));
		sizeDetails.setSize(rs.getString("size"));
		sizeDetails.setTotalsale(rs.getInt("totalsale"));
		return sizeDetails;
	}
	
}
