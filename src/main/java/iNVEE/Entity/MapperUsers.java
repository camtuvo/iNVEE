package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;
public class MapperUsers implements RowMapper<Users> {
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();
		users.setID(rs.getString("ID"));
		users.setPhoto(rs.getString("photo"));
		users.setName(rs.getString("name"));
		users.setEmail(rs.getString("email"));
		users.setPhone(rs.getString("phone"));
		users.setAddress(rs.getString("address"));
		users.setBirthday(rs.getString("birthday"));
		users.setGender(rs.getInt("gender"));
		users.setUsername(rs.getString("username"));
		users.setPassword(rs.getString("password"));
		users.setStatus(rs.getInt("status"));
		users.setIsadmin(rs.getInt("isadmin"));
		users.setCreateddate(rs.getString("createddate"));
		users.setCreatedby(rs.getString("createdby"));
		users.setModifiedby(rs.getString("modifiedby"));
		users.setModifieddate(rs.getString("modifieddate"));
		return users;
	}
}
