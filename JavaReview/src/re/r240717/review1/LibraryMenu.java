package re.r240717.review1;

import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc;
	private Scanner sc;
	
	
	public void mainMenu() {
		int menu = 0;
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		System.out.println();
		
		lc.insertMember(new Member(name, age, gender));
		
		while(true) {
			System.out.println();
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				lc.myInfo();
				break;
				
			case 2:
				this.selectAll();
				break;
				
			case 3:
				this.searchBook();
				break;
				
			case 4:
				this.rentBook();
				break;
				
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
	
	public void selectAll() {
		Book[] bList = lc.selectAll();
		for(int i=0; i<bList.length; i++) {
			if(bList[i] == null) {
				break;
			}
			System.out.println(i+ "번 도서 : " +bList[i].toString());
		}
	}
	
	public void searchBook() {
		System.out.println("검색할 제목 키워드 : ");
	}
	
	public void rentBook() {
		
	}
}
