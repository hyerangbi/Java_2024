package test240712.object1;

import java.util.Scanner;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {
		return ;
	}
	
	// 멤버 필드
	public void mainMenu() {		
		
		int menu = 0;
		
		while(menu != 9) {
			System.out.println("최대 등록 가능한 회원 수는 "+ MemberController.SIZE +"명 입니다.");
			
			System.out.println("현재 등록된 회원 수 는 " + mc.existMemberNum() + "명입니다.");
			
			if(mc.existMemberNum() != 10) {
				System.out.println("1. 새 회원 등록");
				System.out.println("2. 회원검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				menu = sc.nextInt();		
			}else {
				System.out.println("회원수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
				System.out.println("2. 회원검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				
			}
			switch(menu) {
			case 1:				
				this.insertMember();
				break;
			case 2:				
				this.searchMember();
				break;
			case 3:				
				this.updateMember();
				break;
			case 4:				
				this.deleteMember();
				break;
			case 5:				
				this.printAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertMember() {
		String id;
		
		System.out.println("새 회원을 등록합니다.");
		
		while(true) {
			System.out.print("아이디 : ");
			id = sc.next();
			if(mc.checkId(id)){ // 사용가능				
				break;
			}else { // 사용불가
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
		}
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("비밀번호 : ");
			String pw = sc.next();
			
			System.out.print("이메일 : ");
			String em = sc.next();
			
			System.out.print("성별(M/F) : ");
			char gen = sc.next().charAt(0);
			while(true) {
				if(gen == 'm' || gen == 'M' || gen == 'f' || gen == 'F') {
					break;
				}				
				else {
					System.out.println("성별을 다시 입력해주세요.");
				}
			}
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
				
		mc.insertMember(id, name, pw, em, gen, age);
		
		
	}
	
	public void searchMember() {
		int num = 0;
		
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		num = sc.nextInt();
		
		switch(num) {
		case 1:
			this.searchId();
			break;
		case 2:
			this.searchName();
			break;
		case 3:
			this.searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;			
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
	}
	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String id = sc.next();
		
		mc.searchId(id);
		
		String memberInfo = mc.searchId(id);
		if(memberInfo == null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(memberInfo);
		}
		
	}
	
	public void searchName() {
		System.out.println("검색할 이름 : ");
		String name = sc.next();
		
		Member[] mArr = mc.searchName(name);
		if(mArr[0] == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(int i=0; i<mArr.length; i++) {
				if(mArr[i] == null) {
					break;
				}
				String info = mArr[i].inform();
				System.out.println("찾으신 회원 조회 결과입니다.");
				System.out.println(info);
			}
		}			
		
	}
	
	public void searchEmail() {
		System.out.println("검색할 이메일 : ");
		String email = sc.next();
		
		Member[] mArr = mc.searchEmail(email);
		if(mArr[0] == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(int i=0; i<mArr.length; i++) {
				if(mArr[i] == null) {
					break;
				}
				String info = mArr[i].inform();
				System.out.println("찾으신 회원 조회 결과입니다.");
				System.out.println(info);
			}
		}
	}
	
	public void updateMember() {
		int num = 0;
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
		case 1:
			this.updatePassword();
			break;
		case 2:
			this.updateName();
			break;
		case 3:
			this.updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return; //this.mainMenu로 갈 경우 점점 쌓여서 느려짐.
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
	}
	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		
		System.out.print("수정할 비밀번호 : ");
		String pw = sc.next();
		if(mc.updatePassword(id, pw)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
		
		
	}
	
	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		
		System.out.print("수정할 이름 : ");
		String name = sc.next();
		
		if(mc.updatePassword(id, name)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
		
	}
	
	public void updateEmail() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		
		System.out.print("수정할 이름 : ");
		String email = sc.next();
		if(mc.updatePassword(id, email)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 이메일 입니다.");
		}
	}
	
	public void deleteMember() {
		int num = 0;
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 선택 : ");
		num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
		case 1:
			this.deleteOne();
			break;
		case 2:
			this.deleteAll();
			break;
		case 9:
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
	}
	
	public void deleteOne() {

		System.out.println("삭제할 회원 ID");
		String id = sc.next();

		System.out.print("정말 모든 정보를 삭제하시겠습니까 ?(y/n) : ");
		char result = sc.next().charAt(0);
		
		if(result == 'y' || result == 'Y'){
			mc.delete(id);
			System.out.println("성공적으로 삭제하였습니다.");
		}	
		
	}
	
	public void deleteAll() {
		System.out.print("정말 모든 정보를 삭제하시겠습니까 ?(y/n) : ");
		
		char result = sc.next().charAt(0);
		
		if(result == 'y' || result == 'Y'){
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
				
	}
	
	public void printAll() {
		
		if(mc.existMemberNum() == 0) {
			System.out.println("저장된 회원이 없습니다.");
		}else {
			Member[] mArr = mc.printAll();
			for(int i=0; i<mArr.length; i++) {
				if(mArr[i] == null) {
					break;
				}
				String info = mArr[i].inform();
				System.out.println(info);
			}
			
		}
	}
}
