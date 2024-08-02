package test240711.object2;

public class TV {
	private String brand;
	private int year;
	private int inchi;
	private int price;
	
	
	public TV() {
		
	}
	
	
	
	public TV(String brand, int year, int inchi, int price) {
		super();
		this.brand = brand;
		this.year = year;
		this.inchi = inchi;
		this.price = price;
		
	}

	
	
	
	
	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getInchi() {
		return inchi;
	}

	public void setInchi(int inchi) {
		this.inchi = inchi;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public void show(){
		System.out.println(this.brand + "에서 만든 " + this.year +
						"년형 "+this.inchi + "인치 TV 가격 : " + this.price);
	}
	 

	
}
