package iNVEE.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dto.CartDto;

@Service
public interface ICartService {
	@Autowired
	public HashMap<String, CartDto> AddCart(String proId,String size,int quantity,HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> EditCart(String proId,int quantity ,HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> DeleteCart(String proId,HashMap<String, CartDto> cart);
	public int TotalQuantity(HashMap<String, CartDto> cart);
	public double TotalPrice(HashMap<String, CartDto> cart);

}
