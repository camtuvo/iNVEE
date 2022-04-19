package iNVEE.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BaseDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int getQuantityNewOrders() {
		String sql = "SELECT COUNT(status) from orders where status = 0";
		String result =  _jdbcTemplate.queryForObject(sql, String.class);
		return Integer.parseInt(result);
		
	}
	
	public int getQuantityProducts() {
		String sql = "SELECT COUNT(*) from product where status = 1";
		String result =  _jdbcTemplate.queryForObject(sql, String.class);
		return Integer.parseInt(result);
		
	}
	public int getQuantityCustomers() {
		String sql = "SELECT COUNT(*) from useraccount where status = 1 and isadmin = 0";
		String result =  _jdbcTemplate.queryForObject(sql, String.class);
		return Integer.parseInt(result);
		
	}
	public int getQuantityEmployees() {
		String sql = "SELECT COUNT(*) from useraccount where status = 1 and isadmin != 0";
		String result =  _jdbcTemplate.queryForObject(sql, String.class);
		return Integer.parseInt(result);
		
	}
}
