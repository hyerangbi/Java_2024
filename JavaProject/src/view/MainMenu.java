package view;

import java.util.Scanner;

import controller.CharaController;
import model.vo.Chara;
import view.CharaMenu;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private CharaController cc = new CharaController();
	private CharaMenu cm = new CharaMenu();
	
	
	public void mainMenu() {
		// (아무런 설정이 없는 경우) 맨 처음 켰을 때 뜨는 메뉴
		//if() {
			System.out.println("캐릭터 생성 ");
			this.create();
		//}
		System.out.println("ヾ(≧▽≦*)o");
		int menu = 0;
		while(true) { // 캐릭터 생성 후 뜨는 메뉴
			System.out.println("1.캐릭터 관련메뉴");
			System.out.println("2.맵 이동");
			System.out.println("0.프로그램 종료");
			System.out.print("입력 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1: //캐릭터메뉴
				this.userMenu();
				break;
			case 2: //맵 이동
				new Place().house();
				break;			
			case 0:
				return;
			default:
				System.out.println("잘못된 번호입니다 ! 다시 입력해주세요 !");
			}
		}
		
	}

	public void create() { 
		System.out.println("============");
		System.out.print("캐릭터 이름 : ");
		String chName = sc.nextLine();
		cc.insertName(chName);		
	}
	
	
	public void userMenu() {
		int menu = 0;
		
		while(true) {
			System.out.println("??????");
			System.out.println();
			System.out.println("1. 정보 보기");			
			System.out.println("2. 캐릭터 삭제");
			System.out.println("0. 되돌아가기");
			System.out.print("메뉴 입력 : ");
			menu = sc.nextInt();
			
			
			switch(menu) {
			case 1: // 캐릭터 정보
				this.charList();
				break;
			case 2: // 삭제
				break;
			case 0: // mainMenu로 돌아가기
				System.out.println("돌아갑니다. ");
				return;
			default:
				System.out.println("없는 메뉴 입니다. 다시 입력해주세요 !");
				
			}
			
		}
		
	}
	
	public void charList() {
		new CharaMenu().CharaMenu();
	}
	
}
