package iNVEE.Dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import iNVEE.Entity.Brands;
import iNVEE.Entity.MapperBrands;
import iNVEE.Entity.Users;

@Repository
public class BrandsDao extends BaseDao {
	
	
	public List<Brands> GetDataBrand() {
		List<Brands> list = new ArrayList<Brands>();
		String sql = "SELECT ID,name,status,photo,description, date_format(createddate,'%d-%m-%Y') as createddate ,createdby,date_format(modifieddate,'%d-%m-%Y') as modifieddate,modifiedby FROM productbrand where status = 1";
		list = _jdbcTemplate.query(sql, new MapperBrands());
		return list;
	}
	public List<Brands> GetDataBrandForAdmin() {
		List<Brands> list = new ArrayList<Brands>();
		String sql = "SELECT ID,name,status,photo,description, date_format(createddate,'%d-%m-%Y') as createddate ,createdby,date_format(modifieddate,'%d-%m-%Y') as modifieddate,modifiedby FROM productbrand";
		list = _jdbcTemplate.query(sql, new MapperBrands());
		return list;
	}
	public int DeleteBrand(String id) {
		String sql = "Delete from productbrand where 1=1 and ID ='" + id + "'";
		int check = _jdbcTemplate.update(sql);
		return check;
	}
	public int AddNewBrand(Brands brand,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "INSERT INTO `productbrand`(`ID`, `name`, `description`, `type`, `status`, `createddate`, `createdby`) VALUES ('"
				+ getNewIDOfBrand() + "','" + brand.getName() + "','" + brand.getDescription() + "',1,1,'"
				+ getDateNow() + "','"+ loginInfo.getID() +"')";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public int UpdateBrand(Brands brand,String id,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "UPDATE `productbrand` SET `name`='"+brand.getName()+"',`status`='"+brand.getStatus()+"',`modifieddate`='"+ getDateNow() +"',`modifiedby`='"+ loginInfo.getID() +"' WHERE 1 = 1 and ID = '" + id + "'";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public String getNewIDOfBrand() {

		String lastId = getLastBrandId().getID();
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

	private Brands getLastBrandId() {
		String sql = "select * from productBrand order by ID desc limit 1";
		Brands brand = new Brands();
		brand = _jdbcTemplate.queryForObject(sql, new MapperBrands());

		return brand;
	}

	public String getDateNow() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public Brands FindBrandByID(String id) {
		String sql = "select * from productbrand where ID ='" + id + "'";
		Brands brand = _jdbcTemplate.queryForObject(sql, new MapperBrands());
		return brand;
	}
}
