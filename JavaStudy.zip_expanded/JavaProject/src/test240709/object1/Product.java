package test240709.object1;

public class Product {
	//필드영역
	private String pName;
	private int price;
	private String brand;
	
	//생성자 영역
	public Product() {
		
	}
	
	public Product(String pName, int price, String brand) {
		super();
		this.pName = pName;
		this.price = price;
		this.brand = brand;
	}
	
	
	
	//메소드 영역

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void information() {
		System.out.println("상품명 : "+ pName +"가격 : " + price+ "브랜드 명 : " +brand);
	}
}
