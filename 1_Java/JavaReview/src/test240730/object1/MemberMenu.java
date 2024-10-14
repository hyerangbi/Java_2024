package test240730.object1;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========== KH 사이트 =========="); 
		int menu = 0;
		
		while(true) {
			System.out.println("******* 메인 메뉴 ******* ");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 로그인 ");
			System.out.println("3. 같은 이름 회원 찾기 ");
			System.out.println("9. 종료 ");
			System.out.print("메뉴 번호 선택 : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.joinMembership();
				break;
			case 2:
				this.logIn();
				this.memberMenu();
				break;
			case 3:
				this.sameName();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void memberMenu() {
		int menu = 0;
		while(true) {
			System.out.println("******* 회원 메뉴 *******");
			System.out.println("1. 비밀번호 바꾸기 ");
			System.out.println("2. 이름 바꾸기 ");
			System.out.println("3. 로그아웃 ");			
			System.out.print("메뉴 번호 선택 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:				
				this.changePassword();
				break;
			case 2:
				this.changeName();
				break;
			case 3:
				System.out.println();
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void joinMembership() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		sc.nextLine();
		
		if(mc.joinMembership(name, new Member(pw,id))) {
			System.out.println("성공적으로 회원가입 완료되었습니다.");
		}else {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		}
	}
	
	public void logIn() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		
			String name = mc.login(id, pw);
			if(name != null) {
				System.out.println(name +"님, 환영합니다 ! ");
				return;
			}else {		
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시입력해주세요.");
			}
	}
	
	public void changePassword() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("현재 비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("새 비밀번호 : ");
		String newPw = sc.nextLine();
				
		if(mc.changePassword(id, pw, newPw)) {
			System.out.println("비밀번호가 성공적으로 변경되었습니다.");
		}else {
			System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
		}
		
	}
	
	public void changeName() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			
			String name = mc.login(id, pw);
			
			if(name != null) {
				System.out.println("현재 설정된 이름 : " +name);
				
				System.out.println("변경할 이름 : ");
				String newName = sc.nextLine();
				mc.changeName(name, newName);
			}else {
				System.out.println("이름 변경에 실피했습니다. 다시 입력해주세요.");
			}
			
			}
	}
	
	public void sameName() {
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		mc.sameName(name);
		
		TreeMap result = mc.sameName(name);
		if(result.isEmpty()) {
			System.out.println("회원을 찾지 못하였습니다.");
		}else {
			for(Object entry : result.entrySet()) {
				Entry<String, String> en = (Entry)entry;
				System.out.println(en.getKey() + " : " + en.getValue());
			}
		}
		
	}
}
