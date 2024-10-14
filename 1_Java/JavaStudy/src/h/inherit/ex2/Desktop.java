package h.inherit.ex2;

public class Desktop extends Product{
	
	private boolean allinOne; //일체형 여부

	public Desktop() {
		super();
	}

	public Desktop(String brand, String pCode, String pName, int price) {
		super(brand, pCode, pName, price);
		
		this.allinOne = allinOne;
	}
	
	@Override
	public String information() {
		return super.information();
	}
	
}
