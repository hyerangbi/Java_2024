package j.Interface.ex1;



public interface Animal {
	/*
	 interface에 들어갈 수 있는 것들
	 : 
	- static변수
	- 추상메소드 : 미완성 메소드로 구현부({})가 없는 메소드 이다.
	- abstract 추상키워드를 붙여서 생성
	- 외부에서 접근이 가능해야하므로 private이면 안된다.
	 public abstract 을 안 써도 된다.
	 */
	public abstract void move();
	public abstract void eat();
	public abstract void makeSound();
}
