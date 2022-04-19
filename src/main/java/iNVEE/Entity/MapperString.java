package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperString implements RowMapper<string> {

	public string mapRow(ResultSet rs, int rowNum) throws SQLException {
		string s = new string();
		s.setName(rs.getString("name"));
		return s;
	}

}
