package test240715.inherit;

import java.util.Scanner;

// 사용자로부터 입력을 받거나 결과를 보여주는 class

public class Menu {
	private Scanner sc = new Scanner(System.in);
	
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	int menu = 0;
	
	public void mainMenu() {
		while(true) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴번호 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				circleMenu();
				break;
			case 2:
				rectangleMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	};
	
	
	public void circleMenu() {
		while(true) {
			System.out.println(" ===== 원 메뉴 ===== ");
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴번호 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				this.calcCircum();
				break;
			case 2:
				this.calcCircleArea();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
		
	};
	
	public void rectangleMenu() {
		while(true) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴번호 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				this.calcPerimeter();
				break;
			case 2: 
				this.calcRectArea();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	};
	
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.println("y 좌표 : ");
		int y = sc.nextInt();
		System.out.println("반지름 : ");
		int ra = sc.nextInt();
		
		String result = cc.calcCircum(x, y, ra);
		System.out.println(result);
	}
	
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.println("y 좌표 : ");
		int y = sc.nextInt();
		System.out.println("반지름 : ");
		int ra = sc.nextInt();
		
		String result = cc.calcArea(x, y, ra);
		System.out.println(result);
	};
	
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int he = sc.nextInt();
		System.out.print("너비 : ");
		int wi = sc.nextInt();
		
		String result = rc.calcPerimeter(x, y, he, wi);
		System.out.println(result);
	};
	
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int he = sc.nextInt();
		System.out.print("너비 : ");
		int wi = sc.nextInt();
		
		String result = rc.calcArea(x, y, he, wi);
		System.out.println(result);
	};
	
	
	
	
}
