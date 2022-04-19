package iNVEE.Dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import iNVEE.Entity.BillDetails;
import iNVEE.Entity.Bills;
import iNVEE.Entity.Brands;
import iNVEE.Entity.ID;
import iNVEE.Entity.MapperBills;
import iNVEE.Entity.MapperID;
import iNVEE.Entity.MapperProductInBillDetails;
import iNVEE.Entity.MapperString;
import iNVEE.Entity.ProductInBillDetails;
import iNVEE.Entity.Users;
import iNVEE.Entity.string;

@Repository
public class BillsDao extends BaseDao {

	public int AddBills(Bills bill) {
		String sql = "INSERT INTO `orders`(`ID`, `userid`, `ordernumber`, `email`, `phone`, `note`, `deliverto`, `totalprice`, `status`, `createddate`) VALUES ('"
				+ getNewIDOfBill() + "','" + bill.getCustomerid() + "','" + getOrderNumber() + "','" + bill.getEmail()
				+ "','"+bill.getPhone()+"','"+bill.getNote()+"','"+bill.getDeliverto()+"','"+bill.getTotalprice()+"','0','"+getDateNow()+"')";
		int check = _jdbcTemplate.update(sql);
		return check;
	}

	private String getOrderNumber() {
		// TODO Auto-generated method stub
		return "";
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public String getDateNow() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public String getNewIDOfBill() {
		String lastId = getIDLastBills();
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

	public String getIDLastBills() {
		String lastId = "";
		String sql = "select ID from orders order by ID desc limit 1";
		ID id = new ID();
		id = _jdbcTemplate.queryForObject(sql, new MapperID());
		if (id != null) {
			lastId = id.getID();
			return lastId;

		} else {
			lastId = "ORD0000000";
			return lastId;
		}

	}

	public void AddBillDetails(BillDetails billDetails) {
		String sql = "INSERT INTO `orderdetail`(`ID`, `orderid`, `productid`,sizeid, `price`, `quantity`, `totalprice`) VALUES ('"
				+ getNewIdOrderDetail() + "','" + billDetails.getOrderid() + "','" + billDetails.getProductid() + "','"
				+ billDetails.getSizeid() + "','" + billDetails.getPrice() + "','" + billDetails.getQuantity() + "','"
				+ billDetails.getTotalprice() + "')";
		_jdbcTemplate.update(sql);
		
		String sql2 = "UPDATE `sizedetail` SET `totalsale`= totalsale + " + billDetails.getQuantity() + " WHERE productid ='" + billDetails.getProductid() +"' and sizeid='"+ billDetails.getSizeid() +"'" ;
		_jdbcTemplate.update(sql2);

	}

	private String getNewIdOrderDetail() {
		String lastId = getIDLastBillDetails();
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

	private String getIDLastBillDetails() {
		String lastId = "";
		String sql = "select * from orderdetail order by ID desc limit 1";
		ID id = new ID();
		id = _jdbcTemplate.queryForObject(sql, new MapperID());
		if (id != null) {
			lastId = id.getID();
			return lastId;

		} else {
			lastId = "ORD0000000";
			return lastId;
		}
	}

	public List<Bills> GetDataBills() {
		List<Bills> bill = new ArrayList<Bills>();
		String sql = "select ID, userid as customerid, ordernumber, email, phone, note, deliverto, totalprice, status,createddate, modifieddate,modifiedby from orders";
		bill = _jdbcTemplate.query(sql, new MapperBills());
		return bill;
	}

	public Bills GetBillsByID(String id) {
		String sql = "select ID, userid as customerid, ordernumber, email, phone, note, deliverto, totalprice, status,date_format(createddate,'%H:%i %d-%m-%Y') as createddate, date_format(modifieddate,'%H:%i %d-%m-%Y') as modifieddate,modifiedby from orders where ID = '"
				+ id + "'";
		Bills bill = new Bills();
		bill = _jdbcTemplate.queryForObject(sql, new MapperBills());
		return bill;
	}

	public string GetInforCustomerByIDBills(String id) {
		String sql = "SELECT u.name  FROM `orders` as o INNER JOIN useraccount as u on o.userid= u.ID WHERE o.ID = '" + id + "'";
		string s = new string();
		s = _jdbcTemplate.queryForObject(sql, new MapperString());
		return s;
	}

	public List<ProductInBillDetails> GetProductDetailByIDBills(String id) {
		String sql = "SELECT o.productid as ID, p.name as name, s.name as size, o.price as price, o.quantity as quantity from orderdetail as o INNER JOIN product as p on o.productid = p.ID INNER JOIN size as s on o.sizeid = s.ID where o.orderid = '"
				+ id + "'";
		List<ProductInBillDetails> list = new ArrayList<ProductInBillDetails>();
		list = _jdbcTemplate.query(sql, new MapperProductInBillDetails());
		return list;
	}

	public int CompleteBill(Bills bill, String id, HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "UPDATE `orders` SET `ordernumber`='"+ bill.getOrdernumber() +"',status = 1, modifiedby='"+ loginInfo.getID() +"'"+  "',modifieddate ='" + getDateNow() +"' WHERE ID = '"+ id +"'";
		int check = _jdbcTemplate.update(sql);
		
		return check;
	}

}
