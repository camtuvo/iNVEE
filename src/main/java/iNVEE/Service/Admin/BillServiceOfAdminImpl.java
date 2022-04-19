package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.BillsDao;
import iNVEE.Entity.Bills;
import iNVEE.Entity.ProductInBillDetails;
import iNVEE.Entity.Users;
import iNVEE.Entity.string;

@Service
public class BillServiceOfAdminImpl  implements IBillServiceOfAdmin{
	@Autowired BillsDao billsDao;
	

	public List<Bills> GetDataBills() {
		return billsDao.GetDataBills();
	}


	public Bills GetBillsByID(String id) {
		return billsDao.GetBillsByID(id);
	}


	public string GetInfoCustomerByIDBills(String id) {
		return billsDao.GetInforCustomerByIDBills(id);
	}


	public List<ProductInBillDetails> GetProductDetailByIDBills(String id) {
		return billsDao.GetProductDetailByIDBills(id);
	}


	public int CompleteBill(Bills bill, String id, HttpSession session) {
		return billsDao.CompleteBill(bill, id, session);
	}

}
