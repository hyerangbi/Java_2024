package view;

import java.util.Scanner;

import controller.CharaController;
import model.vo.Chara;

public class CharaMenu {
	private CharaController cc = new CharaController();
	private Scanner sc = new Scanner(System.in);
	private Chara c = new Chara();
	public void CharaMenu() {
		int choice = 0;
		System.out.println("캐릭터 정보에 대한 메뉴로 오셨습니다.");
		
		System.out.println("1. 캐릭터 정보 보기");
		System.out.println("2. 가지고 있는 도구 보기");
		System.out.println("0. 되돌아가기");
		System.out.print("메뉴 입력 : ");
		choice = sc.nextInt();
		
		while(true) {
			switch(choice) {
			case 1:
				this.charaInform();
				break;
			case 2:
				break;
			case 0:
				return;
			default:
				System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void charaInform() {
		System.out.println(c.toString());
		return;
		
	}
}
