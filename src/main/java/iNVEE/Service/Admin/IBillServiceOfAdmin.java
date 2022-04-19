package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Entity.Bills;
import iNVEE.Entity.ProductInBillDetails;
import iNVEE.Entity.Users;
import iNVEE.Entity.string;

@Service
public interface IBillServiceOfAdmin {
	@Autowired
	public List<Bills> GetDataBills();
	public Bills GetBillsByID(String id);
	public string GetInfoCustomerByIDBills(String id);
	public List<ProductInBillDetails> GetProductDetailByIDBills(String id);
	public int CompleteBill(Bills bill, String id, HttpSession session);
}
