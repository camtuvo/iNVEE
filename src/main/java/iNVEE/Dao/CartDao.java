package iNVEE.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import iNVEE.Dto.CartDto;
import iNVEE.Dto.ProductDetailDto;
import iNVEE.Entity.ProductDetails;
import iNVEE.Entity.Products;

@Repository
public class CartDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Autowired
	private ProductsDao productsDao = new ProductsDao();
	@Autowired
	private ProductDetailDto productDetailDto = new ProductDetailDto();

	public HashMap<String, CartDto> AddCart(String proId, int quantity, HashMap<String, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductDetails productDetail = productDetailDto.FindDataProductDetail(proId, "S");

		if (productDetail != null && cart.containsKey(proId)) {
			itemCart = cart.get(proId);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		} else {
			itemCart.setProduct(productDetail);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(productDetail.getPrice()*quantity);
		}
		cart.put(proId, itemCart);
		return cart;

	}

	public HashMap<String, CartDto> EditCart(String proId, int quantity, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(proId)) {
			itemCart = cart.get(proId);
			itemCart.setQuantity(quantity);
			double totalPrice = quantity * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(proId, itemCart);
		return cart;

	}

	public HashMap<String, CartDto> DeleteCart(String proId, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(proId)) {
			cart.remove(proId);
		}
		return cart;

	}

	public int TotalQuantity(HashMap<String, CartDto> cart) {
		int totalQuantity = 0;
		for (Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;

	}

	public double TotalPrice(HashMap<String, CartDto> cart) {
		int totalPrice = 0;
		for (Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;

	}
}
