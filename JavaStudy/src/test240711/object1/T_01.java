package test240711.object1;

import java.util.Scanner;

public class T_01 {

	public static void main(String[] args) {
		/*
		 정수를 n(2~9)를 입력받아 2부터 n가지 중 짝수의 구구단을 출력하는 코드를 작성하세요.
		 만약 2~9사이의 값을 입력하지 않는다면 다시 입력하세요를 반복합니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("2~9 숫자 중 하나를 입력하세요 : ");
			int num = sc.nextInt();
			
			if(num >= 2 && num <=9) {
			
				for(int i=2; i<10; i++) {
					if(i % 2 == 0) {
						for(int j=1; j<10; j++) {
							System.out.println(i + " × " + j + " = " + i*j);
						}
						
						System.out.println();
					}
				}
				break;
			}
			else {
				System.out.println("다시입력하세요");
				System.out.println();
			}
		}
	}

}
