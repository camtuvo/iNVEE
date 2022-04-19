package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperID implements RowMapper<ID> {

	public ID mapRow(ResultSet rs, int rowNum) throws SQLException {
		ID id = new ID();
		id.setID(rs.getString("ID"));
		return id;
	}

}
