package l.io.ex2;

import java.io.Serializable;

public class Product implements Serializable{ //직렬화가능한 객체이다.
	private String name;
	private int price;
	
	public Product() {
		super();
	}
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	
}
