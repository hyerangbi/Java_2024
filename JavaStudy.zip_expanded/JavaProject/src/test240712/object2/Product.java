package test240712.object2;

public class Product {

	private String name;
	private int price;
	private int quantity;
	
	public Product() {
		super();
	}

	public Product(String name, int price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	public String information() {
		this.name = "갤럭시 s7";
		this.price = 563500;
		this.quantity = 3;
		return "상품명 : " + this.name +"\n"+
		"가격 : " + this.price +" 원 \n" +
		"수량 : " + this.quantity + "개 \n"
		+this.getPrice();
	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
