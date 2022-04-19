package iNVEE.Dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import iNVEE.Entity.Categories;
import iNVEE.Entity.MapperUsers;
import iNVEE.Entity.Users;

@Repository
public class UserDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<Users> GetDataCustomer() {
		String sql = "select * from useraccount where isadmin = 0";
		List<Users> user = new ArrayList<Users>();
		user = _jdbcTemplate.query(sql, new MapperUsers());
		return user;

	}

	public List<Users> GetDataEmployee() {
		String sql = "select * from useraccount where isadmin = 1";
		List<Users> user = new ArrayList<Users>();
		user = _jdbcTemplate.query(sql, new MapperUsers());
		return user;

	}

	public String getIDOfUserAccount() {

		String lastId = getLastUser().getID();
		String newId = "";
		// covert string lastId to array
		char[] ch = new char[lastId.length()];

		for (int i = 0; i < lastId.length(); i++) {
			ch[i] = lastId.charAt(i);
		}
		// get string is not number array
		String strchar = "";
		for (int i = 0; i < 3; i++) {
			strchar += ch[i];
		}
		// get string is number
		String strnumber = "";
		for (int i = 3; i < 10; i++) {
			strnumber += ch[i];
		}
		// convert string strnumber to integer;
		int number = Integer.parseInt(strnumber);
		// increase number
		number++;
		// convert number to string;
		String num = Integer.toString(number);
		for (int i = 3; i < 10; i++) {
			if (num.length() == 7) {
				newId = strchar + num;
			} else {
				num = "0" + num;
			}
		}

		return newId;
	}

	private Users getLastUser() {
		String sql = "select * from useraccount order by ID desc limit 1";
		Users user = new Users();
		user = _jdbcTemplate.queryForObject(sql, new MapperUsers());

		return user;
	}

	public int AddAccount(Users user) {
		try {
			String sql = "INSERT INTO useraccount (ID, photo, name, email, phone, address, birthday, gender, username, password, status, isadmin, createddate) VALUES ('"
					+ getIDOfUserAccount() + "','" + user.getPhoto() + "',N'" + user.getName() + "','" + user.getEmail()
					+ "','" + user.getPhone() + "',N'" + user.getAddress() + "','" + user.getBirthday() + "','"
					+ user.getGender() + "','" + user.getUsername() + "','" + user.getPassword() + "',1,0,'"
					+ getDateNow().toString() + "')";

			int insert = _jdbcTemplate.update(sql);
			return insert;
		} catch(Exception e){
			return 0;
			
		}
		

	}
	public int AddAccountAdmin(Users user) {
		try {
			String sql = "INSERT INTO useraccount (ID, photo, name, email, phone, address, birthday, gender, username, password, status, isadmin, createddate) VALUES ('"
					+ getIDOfUserAccount() + "','" + user.getPhoto() + "',N'" + user.getName() + "','" + user.getEmail()
					+ "','" + user.getPhone() + "',N'" + user.getAddress() + "','" + user.getBirthday() + "','"
					+ user.getGender() + "','" + user.getUsername() + "','" + user.getPassword() + "',0,1,'"
					+ getDateNow().toString() + "')";

			int insert = _jdbcTemplate.update(sql);
			return insert;
		} catch(Exception e){
			return 0;
			
		}
		

	}

	public String getDateNow() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public Users GetAccount(Users user) {
		try {
			String sql = "SELECT * FROM useraccount WHERE isadmin = 0 and status =1 and username ='" + user.getUsername() + "' ";

			Users u = _jdbcTemplate.queryForObject(sql, new MapperUsers());
			return u;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	};

	public Users GetAccountAdmin(Users user) {
		try {
			String sql = "SELECT * FROM useraccount WHERE isadmin != 0 and status = 1 and username ='" + user.getUsername() + "' ";
			Users u = _jdbcTemplate.queryForObject(sql, new MapperUsers());
			return u;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	};
	public Users FindEmployeeByID(String id) {
		try {
			String sql = "SELECT * FROM `useraccount` WHERE isadmin != '0' and ID = '"+ id +"'";
			Users u = _jdbcTemplate.queryForObject(sql, new MapperUsers());
			return u;
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	public int ActiveEmployee(String id, HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql="UPDATE `useraccount` SET `status`='1',`createddate`='"+ getDateNow() +"',`createdby`='"+ loginInfo.getID() +"' WHERE ID = '"+id+"'";
		int check = _jdbcTemplate.update(sql);
		return check;
	}

	public Users FindCustomerByID(String id) {
		try {
			String sql = "SELECT * FROM `useraccount` WHERE isadmin = '0' and ID = '"+ id +"'";
			Users u = _jdbcTemplate.queryForObject(sql, new MapperUsers());
			return u;
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	public int UpdateProfileEmployee(Users user,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "UPDATE `useraccount` SET `photo`='" 
				+ user.getPhoto()
				+ "',`name`='"+ user.getName() 
				+"',`email`='"+ user.getEmail() 
				+"',`phone`='"+ user.getPhone() 
				+"',`address`='"+ user.getAddress() 
				+"',`birthday`='"+ user.getBirthday() 
				+"',`gender`='"+ user.getGender() 
				/*
				 * +"',`status`='"+ user.getStatus() +"',`isadmin`='"+ user.getIsadmin()
				 */
				+"',`modifieddate`='"+ getDateNow()
				+"',`modifiedby`='"+ loginInfo.getID()
				+"' WHERE ID ='" + loginInfo.getID() + "'";
		int update = _jdbcTemplate.update(sql);
		return update;
	}
	public int UpdateUser(Users user,String id,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "UPDATE `useraccount` SET `photo`='" 
				+ user.getPhoto()
				+ "',`name`='"+ user.getName() 
				+"',`email`='"+ user.getEmail() 
				+"',`phone`='"+ user.getPhone() 
				+"',`address`='"+ user.getAddress() 
				+"',`birthday`='"+ user.getBirthday() 
				+"',`gender`='"+ user.getGender() 
				+"',`status`='"+ user.getStatus()
				+"',`modifieddate`='"+ getDateNow()
				+"',`modifiedby`='"+ loginInfo.getID() 
				+"' WHERE ID ='" + id + "'";
		int update = _jdbcTemplate.update(sql);
		return update;
	}
	public int DeleteUser(String id) {
		String sql = "Delete from useraccount where 1=1 and ID ='" + id + "'";
		int check = _jdbcTemplate.update(sql);
		return check;
	}
}