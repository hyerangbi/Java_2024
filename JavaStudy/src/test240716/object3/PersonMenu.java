package test240716.object3;

import java.util.Scanner;

public class PersonMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private PersonController pc = new PersonController();
	
	int menu = 0;
	
	public void mainMenu() {
		int[] cArr = pc.personCount();
		
		
		
		while(true) {
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 " +cArr[0]+ "명 입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 " +cArr[1] +"명 입니다.");
			
			System.out.println();
			
			System.out.println("1. 학생 메뉴");			
			System.out.println("2. 사원 메뉴");			
			System.out.println("9. 끝내기");			
			System.out.print("메뉴 번호 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				this.studentMenu();
				break;
			case 2:
				this.employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}		
		}		
	}
	
	public void studentMenu() {
		while(true) {
			System.out.println("1. 학생 추가");			
			System.out.println("2. 학생 보기");			
			System.out.println("9. 메인으로");			
			System.out.print("메뉴 번호 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				this.insertStudent();
				break;
			case 2:
				this.printStudent();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			System.out.println("1. 사원 추가");			
			System.out.println("2. 사원 보기");			
			System.out.println("9. 끝내기");			
			System.out.print("메뉴 번호 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				this.insertEmployee();
				break;
			case 2:
				this.printEmployee();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}		
	}
	
	public void insertStudent() {
		char ch ;
		
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.next();
			
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			
			System.out.print("학생 키 : ");
			double height = sc.nextDouble();
			
			System.out.print("학생 몸무게 : ");
			double weight = sc.nextDouble();
			
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			
			System.out.print("학생 전공 : ");
			String major = sc.next();
			sc.nextLine();
						

			
			int[] personCount = pc.personCount();
			if(personCount[0] == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 종료합니다.");
				return;
			}
			
			pc.insertStudent(name, age, height, weight, grade, major);
					
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			ch = sc.next().charAt(0);
			if(ch == 'n' || ch == 'N') {
				return;
			}
		}
		
	}
	
	public void printStudent() {
		Student [] sArr = pc.printStudent();
		
		
		
	}
	
	public void insertEmployee() {
		char ch;
		
		while(true) {
			System.out.print("사원 이름 : ");
			String name = sc.next();
			
			System.out.print("사원 나이 : ");
			int age = sc.nextInt();
			
			System.out.print("사원 키 : ");
			double height = sc.nextDouble();
			
			System.out.print("사원 몸무게 : ");
			double weight = sc.nextDouble();
			
			System.out.print("사원 급여 : ");
			int salary = sc.nextInt();
			
			System.out.print("사원 부서 : ");
			String dept = sc.next();
			sc.nextLine();
			
			int[] personCount = pc.personCount();
			if(personCount[1] == 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 종료합니다.");
				return;
			}
			
			pc.insertEmployee(name, age, height, weight, salary, dept);
			
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			ch = sc.next().charAt(0);
			if(ch == 'n' || ch == 'N') {
				return;
			}
		}
		
	}
	
	public void printEmployee() {
		
	}
}
