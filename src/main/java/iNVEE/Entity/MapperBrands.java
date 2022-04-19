package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBrands implements RowMapper<Brands> {
	public Brands mapRow(ResultSet rs, int rowNum) throws SQLException {
		Brands brands = new Brands();
		brands.setID(rs.getString("ID"));
		brands.setName(rs.getString("name"));
		brands.setPhoto(rs.getString("photo"));
		brands.setDescription(rs.getString("description"));
		brands.setStatus(rs.getInt("status"));
		brands.setCreateddate(rs.getString("createddate"));
		brands.setCreatedby(rs.getString("createdby"));
		brands.setModifiedby(rs.getString("modifiedby"));
		brands.setModifieddate(rs.getString("modifieddate"));
		return brands;
	}
}
