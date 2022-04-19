package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Entity.Brands;

@Service
public interface IBrandServiceOfAdmin {
	@Autowired
	public int DeleleBrand(String id);
	public int AddNewBrand(Brands brand,HttpSession session);
	public int UpdateBrand(Brands brand, String id,HttpSession session);
	public Brands FindBrandByID(String id);
	public List<Brands> GetDataBrandForAdmin();
	public List<Brands> GetDataBrand();
}
