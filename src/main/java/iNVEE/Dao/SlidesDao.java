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
import iNVEE.Entity.MapperSlides;
import iNVEE.Entity.Slides;
import iNVEE.Entity.Users;

@Repository
public class SlidesDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<Slides> GetDataSlide() {
		List<Slides> list = new ArrayList<Slides>();
		String sql = "SELECT * FROM settinghomeimage";
		list = _jdbcTemplate.query(sql, new MapperSlides());
		if (list != null)
			return list;
		return null;
	}

	public int DeleteSlide(String id) {
		String sql = "Delete from settinghomeimage where 1=1 and ID ='" + id + "'";
		int check = _jdbcTemplate.update(sql);
		return check;
	}
	public int UpdateSlide(Slides slide,String id,HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "UPDATE `settinghomeimage` SET `caption`='" + slide.getCaption() 
		+ "',`content`='" + slide.getContent() 
		+ "',`photo`='" + slide.getPhoto() 
		+ "',`status`='" + slide.getStatus() 
		+ "',`modifieddate`='" + getDateNow() 
		+ "',`modifiedby`='" + loginInfo.getID() + "' WHERE ID ='" + id + "'";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}
	public int AddNewSlide(Slides slide, HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
		String sql = "INSERT INTO `settinghomeimage`(`ID`, `caption`, `content`, `photo`, `status`, `createddate`, `createdby`) VALUES ('"
				+ getNewIDOfSlide() + "','" + slide.getCaption() + "','" + slide.getContent() + "','" + slide.getPhoto()
				+ "',1,'" + getDateNow() + "','" + loginInfo.getID() + "')";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private String getDateNow() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	private String getNewIDOfSlide() {
		String lastId = getLastSlideId().getID();
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
	private Slides getLastSlideId() {
		String sql = "select * from settinghomeimage order by ID desc limit 1";
		Slides slide = new Slides();
		slide = _jdbcTemplate.queryForObject(sql, new MapperSlides());

		return slide;
	}
	public Slides FindSlideByID(String id) {
		String sql = "select * from settinghomeimage where ID ='" + id + "'";
		Slides slr = _jdbcTemplate.queryForObject(sql, new MapperSlides());
		return slr;
	}
}
