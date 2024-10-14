package test240711.object2;

public class Run {

	public static void main(String[] args) {
		/*
		 다음과 같은 코드를 실행했을 때 예시와 같은 결과가 출력되도록 TV클래스를 작성하세요.
		 
		 
		 	TV myTv = new TV("삼성", 2020, 65, 100000);
		 	myTV.show();
		 	TV myTv2 = new TV("LG", 2024, 85, 500000);
		 	myTV2.show();
		 	
		 	삼성에서 만든 2020년형 65인치 TV 가격 : 100000
		 	LG에서 만든 2024년형 85인치 TV 가격 : 500000
		 */
		
		
		TV myTV = new TV("삼성", 2020, 65, 100000);
	 	myTV.show();
	 	TV myTV2 = new TV("LG", 2024, 85, 500000);
	 	myTV2.show();
						
		/*
		 	one 이라는 Human객체를 생성하고 객체를 이용해서 myTV와 myTV2를 구매 가능한지
		 	확인하는 코드를 작성하고자 한다.		 
		 
		 	Human one = new Human("사람", 1000000);
		 	one.buy(myTV);
		 	↪ "사람님 구매내역"
		 	   삼성에서 만든 2020년형 65인치 TV 가격 : 100000 → (돈 차감)→
		 	   남은 잔액 : xxx
		 	   
		 	or
		 	
		 	"사람님 잔액이 부족하여 구매하실 수 없습니다."
		 	
		 */
		
		
	 	Human one = new Human("사람", 1000000);
	 	one.buy(myTV);		

	}

}
