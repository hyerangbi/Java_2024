package test240715.object1;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~20 까지 숫자 중 무작위로 10번 입력하세요 : ");
		int num5 = sc.nextInt();
		
		int count = 1;
		int[] nArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int[] sArr = new int[20];
		
		for(int i=0; i<nArr.length; i++) {
			if(num5==nArr[i]) {
				sArr[i] += count;
			}
		}
		System.out.println(sArr);
	}

}
