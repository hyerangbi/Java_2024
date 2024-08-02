package test240715.object1;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// 정수 num1, num2, num3을 입력 받아 홀짝을 출력하라.
		// 입력 : 6 4 7 
		// 짝 짝 홀
		
		Scanner sc = new Scanner(System.in);
		
		
		/*
		
		System.out.print("입력 (3개 입력): ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
				
		
		System.out.println(num1%2 == 0 ? "짝 " : "홀 ");
		System.out.println(num2%2 == 0 ? "짝 " : "홀 ");
		System.out.println(num3%2 == 0 ? "짝 " : "홀 ");
		*/
		
		// 정수(0~100)을 입력받을 0부터 입력받은 수까지 출력
		// 입력 : 7 
		// 0 1 2 3 4 5 6 7
		/*
		System.out.print("입력 :");
		int num11 = sc.nextInt();
		
		for(int i=0; i<=num11; i++) {
			System.out.print(i +" ");
		}
		*/
		/*
		 번호를 입력한 횟수를 구하는 프로그램을 작성한다.
		 번호(1~20)까지를 무작위로 10번 입력 받는다.
		 입력 받은 1~20까지의 수가 각가 몇번 입력되었는지를 출력한다.
		 입력 : 1 5 7 10 15 5 1 7 7 2
		 입력 횟수 : 2 1 0 0 2 0 3 0 0 1 0 0 0 0 1 0 0 0 0 0
		 */
		
		int[] arr = new int[20];
		
		System.out.print("입력 : ");
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			arr[num - 1]++;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
