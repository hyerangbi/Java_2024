package test240711.object3;

import java.util.Scanner;

//사용자와의 소통
//입력을 받고 응답을 출력하는 것
public class Library {
	private Scanner sc = new Scanner(System.in);
	private Book[] barr = new Book[10];
	
	public void menu() {//메뉴를 출력하는 메소드
		int menu = 0 ;
		while(menu != 9){
			System.out.print("제목 : ");
			String title = sc.nextLine();
			System.out.print("장르 : ");
			String genre = sc.nextLine();
			System.out.print("저자 : ");
			String author = sc.nextLine();
			System.out.print("책번호 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				this.addBook();
				break;
			case 2:
			case 3:
			case 4:
			case 9:
			default :	
			}
			
		}
	}
	
	public void addBook() {
		
	}
	
	public void printBookLise() {
		
	}
	
	public void searchBook(){
		
	}
	
	public void deleteBook() {
		
	}
}
