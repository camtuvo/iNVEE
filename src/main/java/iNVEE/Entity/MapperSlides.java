package iNVEE.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSlides implements RowMapper<Slides>{

	public Slides mapRow(ResultSet rs, int rowNum) throws SQLException {
		Slides slides = new Slides();
		slides.setID(rs.getString("ID"));
		slides.setCaption(rs.getString("caption"));
		slides.setContent(rs.getString("content"));
		slides.setPhoto(rs.getString("photo"));
		slides.setStatus(rs.getInt("status"));
		slides.setCreateddate(rs.getString("createddate"));
		slides.setCreatedby(rs.getString("createdby"));
		slides.setModifiedby(rs.getString("modifiedby"));
		slides.setModifieddate(rs.getString("modifieddate"));
		return slides;
	}
	
}
