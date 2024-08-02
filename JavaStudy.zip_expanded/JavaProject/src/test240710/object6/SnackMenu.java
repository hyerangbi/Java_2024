package test240710.object6;

import java.util.Scanner;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("맛 : ");
		String flavor = sc.next();
		
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		String res = scr.saveData(kind, name, flavor, numOf, price);
		
		System.out.println(res);
		
		while(true) {
			System.out.print("저장된 정보를 확인하시겠습니까 ? (y/n) : ");
			char ch = sc.next().charAt(0);
			
			if(ch == 'y' || ch == 'Y' || ch == 'ㅛ') {
				res = scr.comfirmData();
				System.out.println(res);
				break;
			}
			else if(ch == 'n' || ch == 'N' || ch == 'ㅜ') {
				break;
			}
			else {
				System.out.println();
				System.out.println("잘못 입력하셨습니다. 아래에서 다시 입력해주세요");
				System.out.println();
				
			}
		}
	}

}
