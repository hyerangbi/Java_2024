package h.inherit.ex1;

public class BusinessMan extends Man{
	private String company;
	private String position;
	public BusinessMan(String name, String company, String position) {
		super(name);		
		this.company = company;
		this.position = position;
	}
	
	public void tellYouInfo() {
		System.out.println("My Company is " + this.company);
		System.out.println("My Position is " + this.position);
		super.tellYourname();
	}
	
}
