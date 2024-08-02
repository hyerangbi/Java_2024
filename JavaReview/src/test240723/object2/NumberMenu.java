package test240723.object2;

import java.util.Scanner;

public class NumberMenu{
	public void menu() {
		Scanner sc = new Scanner(System.in);
		NumberController nc = new NumberController();		 
		
		System.out.println("1부터 100사이의 값을 입력해주세요");
		System.out.print("정수1 : ");		
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");		
		int num2 = sc.nextInt();
			
		try {	
			boolean isDouble = nc.checkDouble(num1, num2);
			System.out.printf("%d 은(는) %d의 배수인가 ? %s", num1, num2, isDouble);
		}catch(NumRangeException e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
		
	}
}
