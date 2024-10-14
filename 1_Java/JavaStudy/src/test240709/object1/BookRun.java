package test240709.object1;

import java.util.Scanner;

public class BookRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("책 이름 : ");
		String title = sc.next();
		System.out.print("출판사 : ");
		String publisher = sc.next();
		System.out.print("저자 : ");
		String author = sc.next();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("할인율 : ");
		double discountRate = sc.nextDouble();
				
		Book b1 = new Book(title, publisher, author, price, discountRate);
				
		b1.inform();
		

	}

}
