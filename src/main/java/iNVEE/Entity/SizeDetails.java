package iNVEE.Entity;

public class SizeDetails {
	private String ID;
	private String productid;
	private String size;
	private int quantity;
	private int totalsale;
	public SizeDetails() {
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalsale() {
		return totalsale;
	}
	public void setTotalsale(int totalsale) {
		this.totalsale = totalsale;
	}
	
}
