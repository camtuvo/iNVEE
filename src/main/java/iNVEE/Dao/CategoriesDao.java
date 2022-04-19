package iNVEE.Dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import iNVEE.Entity.Categories;
import iNVEE.Entity.MapperCategories;
import iNVEE.Entity.MapperUsers;
import iNVEE.Entity.Products;
import iNVEE.Entity.Users;

@Repository
public class CategoriesDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	

	public List<Categories> GetDataCategory() {
		List<Categories> list = new ArrayList<Categories>();
		String sql = "SELECT ID,name,description,status, date_format(createddate,'%H:%i %d-%m-%Y') as createddate ,createdby,date_format(modifieddate,'%H:%i %d-%m-%Y') as modifieddate,modifiedby FROM productcategory where status = 1 ";
		list = _jdbcTemplate.query(sql, new MapperCategories());
		return list;
	}
	public List<Categories> GetDataCategoryForAdmin() {
		List<Categories> list = new ArrayList<Categories>();
		String sql = "SELECT ID,name,description,status, date_format(createddate,'%H:%i %d-%m-%Y') as createddate ,createdby,date_format(modifieddate,'%H:%i %d-%m-%Y') as modifieddate,modifiedby FROM productcategory";
		list = _jdbcTemplate.query(sql, new MapperCategories());
		return list;
	}


	public int DeleteCategory(String id) {
		String sql = "Delete from productcategory where 1=1 and ID ='" + id + "'";
		int check = _jdbcTemplate.update(sql);
		return check;
	}

	public int AddNewCategory(Categories category,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "INSERT INTO `productcategory`(`ID`, `name`, `description`, `type`, `status`, `createddate`, `createdby`, `modifieddate`, `modifiedby`) VALUES ('"
				+ getNewIDOfCategory() + "','" + category.getName() + "','" + category.getDescription() + "',1,1,'"
				+ getDateNow() + "','"+ loginInfo.getID() +"',null,'')";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public int UpdateCategory(Categories category,String id,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "UPDATE `productcategory` SET `name`='" + category.getName()
				+ "',`status`='"+ category.getStatus() +"',`modifieddate`='"+ getDateNow() +"',`modifiedby`='"+ loginInfo.getID() +"' WHERE ID ='" + id + "'";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public String getNewIDOfCategory() {

		String lastId = getLastCategoryId().getID();
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

	private Categories getLastCategoryId() {
		String sql = "select * from productcategory order by ID desc limit 1";
		Categories category = new Categories();
		category = _jdbcTemplate.queryForObject(sql, new MapperCategories());

		return category;
	}

	public String getDateNow() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public Categories FindCategoryByID(String id) {
		String sql = "select * from productcategory where ID ='" + id + "'";
		Categories cat = _jdbcTemplate.queryForObject(sql, new MapperCategories());
		return cat;
	}
}
