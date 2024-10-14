package view;

import java.util.Scanner;

import controller.CharaController;
import controller.ToolController;
import model.vo.Tool;

public class CharaMenu {
	private CharaController cc;
	private Scanner sc;
	
	private ToolController tc;
	
	public CharaMenu(CharaController cc, Scanner sc, ToolController tc) {
		super();
		this.cc = cc;
		this.sc = sc;
		this.tc = tc;
	}

	public void CharaMenus() {
		int choice = 0;
		System.out.println("- ̗̀ ⸜՞•▽•՞⸝ ̖́-");
		System.out.println("■ 캐릭터 정보 보기에 대한 메뉴로 오셨습니다.");
		while(true) {			
			System.out.println();
			System.out.println("| 1. 캐릭터 자세한 정보");
			System.out.println("| 2. 가지고 있는 도구 보기");
			System.out.println("| 0. 캐릭터 조작 메뉴로 돌아가기");
			System.out.println();
			System.out.print("■ 메뉴 입력 :");
			choice = sc.nextInt();
		
			switch(choice) {
			case 1:
				this.charaInform();
				break;
			case 2:
				this.toolInform();
				break;
			case 0:
				return;
			default:
				System.out.println("| 없는 메뉴 입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void charaInform() {
		cc.informCharaStat();
	}
	
	public void toolInform() {
		tc.informTool();
	}
	
	
}
