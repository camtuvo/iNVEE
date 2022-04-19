package iNVEE.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dto.CartDto;
import iNVEE.Entity.Bills;

@Service
public interface IBillService {
	@Autowired
	public int AddBills(Bills bill);
	public void AddBillDetail(HashMap<Long, CartDto> carts);
}
