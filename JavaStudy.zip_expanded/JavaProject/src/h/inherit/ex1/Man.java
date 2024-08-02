package h.inherit.ex1;

public class Man {
	private String name;
	
	
	public Man() {
		super();
		System.out.println("Man 기본 생성자 호출");
	}


	public Man(String name) {
		super();
		this.name = name;
		System.out.println("Man Name을 초기화 하는 생성자 호출");
	}
	
	public void tellYourname() {
		System.out.println("My name is " + this.name);;
	}
	
}
