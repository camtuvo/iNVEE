package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBills implements RowMapper<Bills> {

	public Bills mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bills bill = new Bills();
		bill.setID(rs.getString("ID"));
		bill.setCustomerid(rs.getString("customerid"));
		bill.setOrdernumber(rs.getString("ordernumber"));
		bill.setDeliverto(rs.getString("deliverto"));
		bill.setEmail(rs.getString("email"));
		bill.setPhone(rs.getString("phone"));
		bill.setNote(rs.getString("note"));
		bill.setTotalprice(rs.getInt("totalprice"));
		bill.setStatus(rs.getInt("status"));
		bill.setCreateddate(rs.getString("createddate"));
		bill.setModifiedby(rs.getString("modifiedby"));
		bill.setModifieddate(rs.getString("modifieddate"));
		
		return bill;
	}

}
