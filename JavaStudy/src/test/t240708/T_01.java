package test.t240708;

import java.util.Scanner;

public class T_01 {
	public static void main(String[] args) {
		/*
		 키보드로 1개의 정수형(int) 데이터를 입력 받아, 1~100 사이의 값일 때만 2의 배수인지 아닌지를
		 출력 처리한다.
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력 : ");
		int num = sc.nextInt();
		
		System.out.println(num % 2 == 0 ? "2의 배수 입니다." : "2의 배수가 아닙니다.");
	}
	
	

}