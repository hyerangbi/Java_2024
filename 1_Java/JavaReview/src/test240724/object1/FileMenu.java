package test240724.object1;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	int menu = 0;
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.fileSave();
				break;				
			case 2: 
				this.fileOpen();
				break;				
			case 3:
				this.fileEdit();
				break;				
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default : 
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void fileSave() {
		//StringBuilder : 문자열을 다루는 객체 (StringBuilder
		StringBuilder sb = new StringBuilder();
		
		
		
		while(true) { 
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			String str= sc.nextLine();
			
			//ex끝it 이라고 입력했을 때
			if(str.equals("ex끝it")) {
				while(true) {
					System.out.println("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
					String fileName = sc.next();
					
					
					if(fc.checkName(fileName)) {
						System.out.println("이미 존재하는 파일 입니다. 덮어쓰시겠습니까 ?(y/n) : ");
						char isPass = sc.next().charAt(0);
						if(isPass == 'y' || isPass == 'Y') {
							fc.fileSave(fileName, sb);
							return;
						}
					}else {
						fc.fileSave(fileName, sb);
						return;
					}
				}
			}
			sb.append(str);
		}
		
		
	}
	
	public void fileOpen() {
		
	}
	
	public void fileEdit() {
		
	}
	
}
