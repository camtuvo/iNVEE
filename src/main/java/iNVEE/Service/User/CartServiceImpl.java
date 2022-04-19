package iNVEE.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.CartDao;
import iNVEE.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartDao cartDao = new CartDao();

	public HashMap<String, CartDto> AddCart(String proId,String size, int quantity, HashMap<String, CartDto> cart) {
		return cartDao.AddCart(proId, size, quantity, cart);
	}

	public HashMap<String, CartDto> EditCart(String proId, int quantity, HashMap<String, CartDto> cart) {
		return cartDao.EditCart(proId, quantity, cart);
	}

	public HashMap<String, CartDto> DeleteCart(String proId, HashMap<String, CartDto> cart) {
		return cartDao.DeleteCart(proId, cart);
	}

	public int TotalQuantity(HashMap<String, CartDto> cart) {
		return cartDao.TotalQuantity(cart);
	}

	public double TotalPrice(HashMap<String, CartDto> cart) {
		return cartDao.TotalPrice(cart);
	}

}
