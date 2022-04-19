package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBillDetails implements RowMapper<BillDetails> {

	public BillDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetails billDetail = new BillDetails();
		billDetail.setID(rs.getString("ID"));
		billDetail.setOrderid(rs.getString("orderid"));
		billDetail.setProductid(rs.getString("productid"));
		billDetail.setSizeid(rs.getString("sizeid"));
		billDetail.setSize(rs.getString("size"));
		billDetail.setPrice(rs.getDouble("price"));
		billDetail.setQuantity(rs.getInt("quantity"));
		billDetail.setTotalprice(rs.getDouble("totalprice"));
		//billDetail.setStatus(rs.getInt("status"));
		return billDetail;
	}

}
