package iNVEE.Dto;

import iNVEE.Entity.ProductDetails;

public class CartDto {
	private int quantity;
	private String sizeid;
	private String size;
	private double totalPrice;
	private ProductDetails product;

	public int getQuantity() {
		return quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSizeid() {
		return sizeid;
	}

	public void setSizeid(String sizeid) {
		this.sizeid = sizeid;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public ProductDetails getProduct() {
		return product;
	}

	public void setProduct(ProductDetails product) {
		this.product = product;
	}

	public CartDto() {

	}

	public CartDto(int quantity, String size, double totalPrice, ProductDetails product) {
		super();
		this.quantity = quantity;
		this.size = size;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	

}
