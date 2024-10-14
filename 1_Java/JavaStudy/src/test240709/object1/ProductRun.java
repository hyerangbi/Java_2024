package test240709.object1;

import java.util.Scanner;

public class ProductRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("상품 명 : ");
		String product = sc.next();
		
		System.out.println("가격 : ");
		int price = sc.nextInt();
		
		System.out.println("브랜드 명 : ");
		String brand = sc.next();
		
		Product egg = new Product(product, price, brand);
		
		egg.information();
	}

}
