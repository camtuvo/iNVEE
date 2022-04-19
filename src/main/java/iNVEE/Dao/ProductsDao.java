package iNVEE.Dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import iNVEE.Entity.Brands;
import iNVEE.Entity.MapperBrands;
import iNVEE.Entity.MapperProducts;
import iNVEE.Entity.MapperSize;
import iNVEE.Entity.MapperSizeDetails;
import iNVEE.Entity.ProductDetails;
import iNVEE.Entity.Products;
import iNVEE.Entity.SizeDetails;
import iNVEE.Entity.Sizes;
import iNVEE.Entity.Users;

@Repository
public class ProductsDao extends BaseDao {

	private String SqlString() {
		String sql = "SELECT p.ID,b.name as brand , c.name as category,p.name,p.importprice,p.price,p.description,p.photo,p.status,p.createddate,p.createdby,p.modifieddate,p.modifiedby"
				+ " from product as p " + "INNER  JOIN productcategory as c on p.categoryid = c.ID "
				+ "INNER JOIN productbrand as b on p.brandid = b.ID ";
		return sql;
	}

	private String SqlProductsByCategoryId(String id) {

		String sql = SqlString() + " WHERE 1 = 1 AND p.categoryid = '" + id + "'";
		return sql;
	}

	private String SqlProductsByProductId(String id) {

		String sql = SqlString() + " where 1 = 1 and p.ID = '" + id + "'";
		return sql;
	}

	private String SqlProductsPaginate(int start, int totalPage) {
		String sql = SqlString() + " limit " + start + "," + totalPage;
		return sql;
	}

	private String SqlProductsPaginateByAscePrice(int start, int totalPage) {
		String sql = SqlString() + " order by price asc " + " limit " + start + "," + totalPage;
		return sql;
	}

	private String SqlProductsPaginateByDescPrice(int start, int totalPage) {
		String sql = SqlString() + " order by price desc " + " limit " + start + "," + totalPage;
		return sql;
	}

	private String SqlProductsOfCategoryPaginate(String id, int start, int totalPage) {

		String sql = SqlProductsByCategoryId(id);
		if (checkValidProductsByCategoryId(id)) {
			sql = sql + " limit " + start + "," + totalPage;
			return sql;
		} else
			return null;
	}

	private boolean checkValidProductsByCategoryId(String id) {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlProductsByCategoryId(id);
		list = _jdbcTemplate.query(sql, new MapperProducts());
		if (list.size() > 0)
			return true;
		return false;
	}

	public List<Products> GetDataProduct() {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlString() + "order by p.ID";
		list = _jdbcTemplate.query(sql, new MapperProducts());

		return list;

	}

	public List<Products> GetDataProductByCategoryId(String id) {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlProductsByCategoryId(id);
		list = _jdbcTemplate.query(sql, new MapperProducts());

		return list;

	}

	public List<Products> GetDataProductsOfCategoryPaginate(String id, int start, int totalPage) {
		List<Products> list = new ArrayList<Products>();

		String sql = SqlProductsOfCategoryPaginate(id, start, totalPage);
		if (sql != null) {
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} else
			return null;
	}

	public List<Products> GetDataProductsPaginate(int start, int totalPage) {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlProductsPaginate(start, totalPage);
		list = _jdbcTemplate.query(sql, new MapperProducts());

		return list;
	}

	public List<Products> GetDataProductsPaginateByDescPrice(int start, int totalPage) {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlProductsPaginateByDescPrice(start, totalPage);
		list = _jdbcTemplate.query(sql, new MapperProducts());

		return list;
	}

	public List<Products> GetDataProductsPaginateByAscePrice(int start, int totalPage) {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlProductsPaginateByAscePrice(start, totalPage);
		list = _jdbcTemplate.query(sql, new MapperProducts());

		return list;
	}

	public List<Products> GetDataProductByProductId(String id) {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlProductsByProductId(id);
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}

	public Products FindDataProductByProductId(String id) {
		Products pro = new Products();
		String sql = SqlProductsByProductId(id);
		pro = _jdbcTemplate.queryForObject(sql, new MapperProducts());
		return pro;
	}

	public List<Products> GetDataProductsOfBrandPaginate(String id, int start, int totalPage) {
		List<Products> list = new ArrayList<Products>();

		String sql = SqlProductsOfBrandPaginate(id, start, totalPage);
		if (sql != null) {
			list = _jdbcTemplate.query(sql, new MapperProducts());
			return list;
		} else
			return null;
	}

	private String SqlProductsOfBrandPaginate(String id, int start, int totalPage) {
		String sql = SqlProductsByBrandId(id);
		if (checkValidProductsByBrandId(id)) {
			sql = sql + " limit " + start + "," + totalPage;
			return sql;
		} else
			return null;
	}

	private boolean checkValidProductsByBrandId(String id) {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlProductsByBrandId(id);
		list = _jdbcTemplate.query(sql, new MapperProducts());
		if (list.size() > 0)
			return true;
		return false;
	}

	private String SqlProductsByBrandId(String id) {
		String sql = SqlString() + " WHERE 1 = 1 AND p.brandid = '" + id + "'";
		return sql;
	}

	public List<Products> GetDataProductByBrandId(String id) {
		List<Products> list = new ArrayList<Products>();
		String sql = SqlProductsByBrandId(id);
		list = _jdbcTemplate.query(sql, new MapperProducts());

		return list;
	}

	public int DeleteProduct(String id) {
		String sql = "Delete from product where 1=1 and ID ='" + id + "'";
		int check = _jdbcTemplate.update(sql);
		return check;
	}

	public int AddNewProduct(Products product,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "INSERT INTO `product`(`ID`, `brandid`, `categoryid`, `name`,importprice , `price`, `description`, `photo`, `status`, `createddate`, `createdby`) VALUES ('"
				+ getNewIDOfProduct() + "','" + product.getBrand() + "','" + product.getCategory() + "','"
				+ product.getName() + "','" + product.getImportprice()  + "','" + product.getPrice() + "','" + product.getDescription() + "','"
				+ product.getPhoto() + "',1,'" + getDateNow() + "','"+ loginInfo.getID() +"')";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public int UpdateProduct(Products product, String id,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "UPDATE `product` SET `brandid`='"+product.getBrand()+"',`categoryid`='"+product.getCategory()+"',`name`='"+product.getName()+"',`importprice`='"+product.getImportprice()+"',`price`='"+product.getPrice()+"',`description`='"+ product.getDescription() +"',`photo`='"+product.getPhoto()+"',`modifieddate`='"+ getDateNow() +"',`modifiedby`='"+ loginInfo.getID() +"' WHERE ID = '" + id + "'";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public String getNewIDOfProduct() {

		String lastId = getLastProductId().getID();
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

	private Products getLastProductId() {
		String sql = SqlString() + " order by ID desc limit 1";
		Products product = new Products();
		product = _jdbcTemplate.queryForObject(sql, new MapperProducts());

		return product;
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public String getDateNow() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public Products FindProductByID(String id) {
		String sql = "select * from product where ID ='" + id + "'";
		Products product = _jdbcTemplate.queryForObject(sql, new MapperProducts());
		return product;
	}

	public List<Sizes> GetDataSize() {
		String sql = "select * from size";
		List<Sizes> size = new ArrayList<Sizes>();
		size = _jdbcTemplate.query(sql, new MapperSize());
		return size;

	}

	public int AddProductInWarehouse(ProductDetails product,String proid) {
		String sql = "INSERT INTO `sizedetail`(`ID`, `productid`, `sizeid`, `quantity`, `createddate`, `createdby`) VALUES ('"
				+ getNewIDOfSizeDetail() + "','" + proid + "','" + product.getSize() + "','"
				+ product.getQuantity() + "','" + getDateNow() + "','')";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public String getNewIDOfSizeDetail() {

		String lastId = getLastSizeDetailId().getID();
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

	private SizeDetails getLastSizeDetailId() {
		String sql = "select ID, productid, sizeid as size, quantity, totalsale from sizedetail order by ID desc limit 1";
		SizeDetails size = new SizeDetails();
		size = _jdbcTemplate.queryForObject(sql, new MapperSizeDetails());
		return size;
	}

}
