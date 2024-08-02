package h.inherit.override;

public class Run {
	/*
	 * 참조변수를 호출하면 자동으로 .toString() 호출된다.
	 * 
	 * 오버라이딩 전 : Object 클래스의 toString() 실행
	 * ↪ 풀클래스명 + @ + 객체의 주소를 암호화한 16진수 값
	 * 
	 * 오버라이딩 후 : Man클래스(자식클래스)의 toStirng 을 실행
	 * ↪ 해당 객체가 가지고 있는 모든 필드의 값을 한 문자열로 반환
	 * 
	 * 오버라이딩
	 * - 자식클래스가 상속받고 있는 부모 클래스의 메소드를 재정의 하는 것
	 * - 부모가 제공하는 메소드를 자식이 일부 고쳐서 사용하겠다는 의미
	 *   자식객체를 통해 실행 시 자식 메소드가 우선권을 가지고 있다.
	 * 
	 * ☁ 오버라이딩 성립조건
	 * - 부모메소드명과 메소드명이 동일
	 * - 매개변수의 갯수, 자료형, 순서 통일(매개변수명❌)
	 * - 반환형이 동일
	 * - 부모메소드의 접근제한자보다 범위가 같거나 커야한다. 
	 */

	public static void main(String[] args) {
		Man m = null;
		Object str = new String("안녕");
		System.out.println(m);
		System.out.println(str.toString());
		//객체가 생성되었따면 객체정보를 보기 위채서 참조변수를 출력하는 순간 무조건 toString 메소드가 호출된다.
		//참조변수에 객체의 주소가 없고 null이라면 null 표시
	}

}
