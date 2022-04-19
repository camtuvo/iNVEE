package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSize implements RowMapper<Sizes> {
	public Sizes mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sizes size = new Sizes();
		size.setID(rs.getString("ID"));
		size.setName(rs.getString("name"));
		return size;
	}
}
