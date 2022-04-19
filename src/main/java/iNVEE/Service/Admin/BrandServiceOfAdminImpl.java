package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.BrandsDao;
import iNVEE.Entity.Brands;


@Service
public class BrandServiceOfAdminImpl implements IBrandServiceOfAdmin {
	@Autowired
	private BrandsDao brandsDao;

	public int DeleleBrand(String id) {
		return brandsDao.DeleteBrand(id);
	}

	public int AddNewBrand(Brands brand,HttpSession session) {
		return brandsDao.AddNewBrand(brand,session);
	}

	public int UpdateBrand(Brands brand, String id,HttpSession session) {
		return brandsDao.UpdateBrand(brand, id, session);
	}

	public Brands FindBrandByID(String id) {
		return brandsDao.FindBrandByID(id);
	}

	public List<Brands> GetDataBrandForAdmin() {
		return brandsDao.GetDataBrandForAdmin();
	}

	public List<Brands> GetDataBrand() {
		return brandsDao.GetDataBrand();
	}

}
