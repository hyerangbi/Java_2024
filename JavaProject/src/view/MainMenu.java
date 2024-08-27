package view;

import java.util.Scanner;

import controller.CharaController;
import model.vo.Chara;
import view.CharaMenu;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private CharaController cc = new CharaController();
	
	
	public void mainMenu() {
		
		// (아무런 설정이 없는 경우) 맨 처음 켰을 때 뜨는 메뉴		
		if(cc.checkChName() == null) {
			System.out.println("■ · . (۶•̀ᴗ•́)۶ \' 。·");
			System.out.println("■ 캐릭터 생성 창으로 이동 중 ...");
			System.out.println();
			this.create();
		}
		
		System.out.println();
		System.out.println("ヾ(≧▽≦*)o");
		System.out.println();
		int menu = 0;
		while(true) { // 캐릭터 생성 후 뜨는 메뉴
			System.out.println("■ 기본 메뉴  ");
			System.out.println("| 1.캐릭터 관련메뉴");
			System.out.println("| 2.맵 이동");
			System.out.println("| 0.프로그램 종료");
			System.out.print("| 입력 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1: //캐릭터메뉴
				this.userMenu();
				break;
			case 2: //맵 이동
				System.out.println("아직 준비되지 않았습니다. (´•̥̥̥‸•̥̥̥`) ..");
				break;			
			case 0:
				return;
			default:
				System.out.println("| 잘못된 번호입니다 ! 다시 입력해주세요 !");
			}
		}
		
	}

	public void create() { 
		System.out.println("■ ~◾~◾~◾~◾~◾~");
		System.out.print("■ 캐릭터 이름 : ");
		String chName = sc.nextLine();
		cc.insertName(chName);
		cc.insertJob();
	}
	
	
	public void userMenu() {
		int menu = 0;
		
		while(true) {
			System.out.println("■ ~◾~◾~◾~◾~◾~");
			System.out.println("■ 캐릭터 조작 ");
			System.out.println();
			System.out.println("| 1. 정보 보기");			
			System.out.println("| 2. 캐릭터 초기화");
			System.out.println("| 0. 기본 메뉴로 돌아가기");
			System.out.print("■ 메뉴 입력 : ");
			menu = sc.nextInt();
			
			
			switch(menu) {
			case 1: // 캐릭터 정보
				this.charList();
				break;				
			case 2: // 삭제
				this.charReset();
				break;
			case 0: // mainMenu로 돌아가기
				System.out.println("|");
				System.out.println("■ 돌아갑니다. ");
				System.out.println();
				return;
			default:
				System.out.println("■ 없는 메뉴 입니다. 다시 입력해주세요 !");
				
			}
			
		}
		
	}
	
	public void charList() {		
		new CharaMenu(cc, sc).CharaMenus();
	}
	
	public void charReset() {
		char check;
		System.out.println();
		System.out.print("■ !! 정말 초기화 하시겠습니까 ? (y/n)");
		check = sc.next().charAt(0);
		
		if(check=='y' || check=='Y' || check == 'ㅛ') {
			cc.reset();
		}else {
			System.out.println("■ 전에 있던 메뉴로 다시 돌아갑니다.");
			return;
		}
		
	}
	
	public void moveNext() {
		new Place().first();
	}
	
}
