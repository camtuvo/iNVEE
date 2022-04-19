package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCategories implements RowMapper<Categories> {

	public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categories categories = new Categories();
		categories.setID(rs.getString("ID"));
		categories.setName(rs.getString("name"));
		categories.setDescription(rs.getString("description"));
		categories.setStatus(rs.getInt("status"));
		categories.setCreateddate(rs.getString("createddate"));
		categories.setCreatedby(rs.getString("createdby"));
		categories.setModifiedby(rs.getString("modifiedby"));
		categories.setModifieddate(rs.getString("modifieddate"));
		return categories;
	}

}
