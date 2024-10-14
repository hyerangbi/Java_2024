package test240709.object1;

public class MemberRun {
	
	public static void main(String[] args) {
		Member Na = new Member();
		Na.changeName("이름");
		Na.printName();
		
		//아이디, 비번, 이름을 초기화하는 생성자를 통해
		//객체를 하나 생성하고 printName()을 통해 이름을 출력해라
		
		Member mu = new Member("m10011", "m101", "하나");
	}
}
