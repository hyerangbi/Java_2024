package test240731.object1;

import java.util.HashMap;
import java.util.Scanner;

public class FarmMenu{
	private Scanner sc = new Scanner(System.in);
	FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		
		while(true) {
			int menu = 0;
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님 메뉴 ");
			System.out.println("9. 종료");
			System.out.print("메뉴");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.adminMenu();
				break;
			case 2 : 
				this.customerMenu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default :
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void adminMenu() {
		while(true) {
			int menu = 0;
			System.out.println("******* 직원 메뉴 ******* ");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제 ");
			System.out.println("3. 수량 수정 ");
			System.out.println("4. 농산물 목록 ");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.addNewKind();
				break;
			case 2:
				this.removeFarm();
				break;
			case 3:
				this.changeAmount();
				break;
			case 4:
				this.printFarm();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
			
		}
			
	}
	
	public void customerMenu() {
		while(true) {
			int menu = 0;
			System.out.println("******* 고객 메뉴 ******* ");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기 ");
			System.out.println("3. 구입한 농산물 보기  ");			
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.buyFarm();
				break;
			case 2:
				this.removeFarm();
				break;
			case 3:
				this.printBuyFarm();
				break;			
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	
	public void addNewKind() {
		while(true) {
			System.out.println("1. 과일 |  2.채소  | 3. 견과류");
			System.out.print("추가할 종류 번호 : ");
			int select = sc.nextInt();
			
			if (select != 1 && select != 2 && select != 3) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("수량 : ");		
			int amount = sc.nextInt();
			sc.nextLine();
			
			Farm newItem = null;
			
			switch(select) {
				case 1:
					newItem = new Fruit("과일",name);
					break;
				case 2:
					newItem = new Vegetable("채소", name);
					break;
				case 3: 
					newItem = new Nut("견과류", name);
					break;				
				}
			if(fc.addNewKind(newItem, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			}else {
				System.out.println("새 농작물 추가에 실패하였습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
	public void removeKind() {
		while(true) {			
			System.out.println("1. 과일 |  2.채소  | 3. 견과류");
			System.out.println("삭제할 종류 번호 : ");
			int select = sc.nextInt();
			
			if (select != 1 && select != 2 && select != 3) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			System.out.print("이름 : ");
			String name = sc.next();
			
			sc.nextLine();
			
			Farm item = null;
			switch(select) {
				case 1:
					item = new Fruit("과일",name);
					break;
				case 2:
					item = new Vegetable("채소", name);
					break;
				case 3: 
					item = new Nut("견과류", name);				
				}
			
			if(fc.removeKind(item)) {
				System.out.println("농산물 삭제에 성공하셨습니다.");
				break;
			}else {
				System.out.println("농작물 삭제에 실패하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void changeAmount() {
		while(true) {			
			System.out.println("1. 과일 |  2.채소  | 3. 견과류");
			System.out.println("수정할 종류 번호 : ");
			int select = sc.nextInt();
			
			if (select != 1 && select != 2 && select != 3) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("수량 : ");
			int amount = sc.nextInt();			
			sc.nextLine();
			
			Farm item = null;
			switch(select) {
				case 1:
					item = new Fruit("과일",name);
					break;
				case 2:
					item = new Vegetable("채소", name);
					break;
				case 3: 
					item = new Nut("견과류", name);				
				}
			
			if(fc.changeAmount(item, amount)) {
				System.out.println("농산물 수정에 성공하셨습니다.");
				break;
			}else {
				System.out.println("농작물 수정에 실패하였습니다. 다시 입력해주세요.");
			}
		}

	}
	
	public void printFarm() { 
		HashMap<Farm, Integer> farmMap = fc.printFarm();
		for(Farm f : farmMap.keySet()) {
			System.out.printf("%s(%d개)\n", f.toString(), farmMap.get(f));
		}
	}
	
	
	//여기서부터 손님
	public void buyFarm() {
		while(true) {			
			System.out.println("1. 과일 |  2.채소  | 3. 견과류");
			System.out.println("수정할 종류 번호 : ");
			int select = sc.nextInt();
			
			if (select != 1 && select != 2 && select != 3) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("수량 : ");
			int amount = sc.nextInt();			
			sc.nextLine();
			
			Farm item = null;
			switch(select) {
				case 1:
					item = new Fruit("과일",name);
					break;
				case 2:
					item = new Vegetable("채소", name);
					break;
				case 3: 
					item = new Nut("견과류", name);				
				}
			
			if(fc.buyFarm(item)) {
				System.out.println("구매에 성공하셨습니다.");
				break;
			}else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void removeFarm() {
		
	}
	
	public void printBuyFarm() {
		
	}
}
