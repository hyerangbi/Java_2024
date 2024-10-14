package i.polymorphism.ex1;

public class Run {
	public static void main(String[] args) {
		/*
		  		클래스 참조변수 = new 클래스 생성자;
  ( 부모 클래스가 올 수 있다.) / (자식 클래스로 생성할 수 있다.)
   실제로 어디까지 접근이 가능  / 실제로 어떤 형태의 메모리가 생성이 되는가
		 */
		
		Cake c1 = new CheeseCake();
		// Cake 까지 접근 가능하며 메모리 공간은 실제 ChessseCake다
		c1.sweet();
		c1.yummy(); // 오버라이딩시에 실제 메모리에 있는 재정의된
					// 매서드가 호출됨.
		
		// CheeseCake ch2 = new Cake();
		// ↪ 실제 메모리공간이 Cake 이므로 CheeseCake 공간에 접근할 수 없다.
		
	}
}
