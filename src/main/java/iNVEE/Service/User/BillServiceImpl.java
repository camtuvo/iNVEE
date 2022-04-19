package iNVEE.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.BillsDao;
import iNVEE.Dto.CartDto;
import iNVEE.Entity.BillDetails;
import iNVEE.Entity.Bills;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	private BillsDao billsDao;

	public int AddBills(Bills bill) {
		return billsDao.AddBills(bill);
	}

	public void AddBillDetail(HashMap<Long, CartDto> carts) {
		String idBills = billsDao.getIDLastBills();

		for (Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillDetails billDetails = new BillDetails();
			billDetails.setOrderid(idBills);
			billDetails.setProductid(itemCart.getValue().getProduct().getID());
			billDetails.setSizeid(itemCart.getValue().getProduct().getSizeid());
			billDetails.setQuantity(itemCart.getValue().getQuantity());
			billDetails.setPrice(itemCart.getValue().getProduct().getPrice());
			billDetails.setTotalprice(itemCart.getValue().getTotalPrice());
		
			billsDao.AddBillDetails(billDetails);
		}

	}



}
