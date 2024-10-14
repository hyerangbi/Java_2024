package test240710.object5;

import java.util.Scanner;

public class Run {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);				
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("맛 : ");
		String flavor = sc.next();
		
		System.out.print("개수");
		int numOf = sc.nextInt();
		
		System.out.print("가격");
		int price = sc.nextInt();
		
		Snack sn = new Snack(kind, name, flavor, numOf, price);
		System.out.println("저장되었습니다.");
		//데이터를 setter를 이용해 저장하고 저장완료되었다는 결과를 반환하는 메소드
		
		
		System.out.println("저장한 정보를 확인하시겠습니까?(y/n)");
		char ch = sc.next().charAt(0);
		if (ch == 'y') {
			// 저장된 데이터를 반환하는 메소드
			String res = sn.information();
			System.out.println(res);

		}		
	}
	
}