package test240718.object1;

public abstract class SmartPhone implements CellPhone, TouchDisplay{
	private String maker;	

	public SmartPhone() {
		super();
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	//다이어그램에서 기울어져있으면 추상메소드 (public 뒤에 abstract 을 해줘야함)
	public abstract String printInformation();
}
