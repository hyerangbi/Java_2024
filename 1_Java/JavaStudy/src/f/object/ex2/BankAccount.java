package f.object.ex2;

public class BankAccount {
	//필드영역
	int balance = 0;
	
	//메소드영역	
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}
	public int withdraw(int amount) {
		balance -= amount;
		return balance;
	}
	public void checkMyBalance(int balance) {
		//영역 안에서 변수를 찾을 때는 가장 작은 단위부터 탐색한다.
		// 지역변수 우선 → 이후에 필드
		// this키워드 사용 시 접근한 객체의 필드값을 가져올 수 있다.→
		System.out.println("잔액 : " +this.balance);
		
	}
}