package test240712.object1;

public class MemberController {
	private Member[] m = new Member[SIZE];
	
	public static final int SIZE = 10;
	
	
	public int existMemberNum() {
		int count = 0;
		for(int i=0; i<m.length; i++) {
			if(m[i] != null) {
				count ++;
			}else {
				break;
			}
		}
		return count;
	}
	
	public Boolean checkId(String inputId) {
		
		for(int i=0; i<m.length; i++) {
			if(m[i] == null) {
				return true; //사용가능
			}
			// String userId = m[i].getId();		
			else if(m[i].getId().equals(inputId)) {  // if(userId.euqals(inputId)){
				//중복 id 찾음
				return false; //사용불가
			}else {
				return true; //사용가능
			}
		}
		
		return false;
		
	}
	
	public void insertMember(String id, String name, String password, 
			String email, char gender, int age) {
		for(int i=0; i<m.length; i++) {
			if(m[i]==null) { //이 부분이 비었구나 라는 것을 확인
				m[i] = new Member(id, name, password, email, gender, age);
				break;
			}
		}
	}
	
	public String searchId(String id) {
		for(int i=0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				return m[i].inform();
				
			}		
			
		}
		return null;
	}
	
	public Member[] searchName(String name) {
		Member[] mArr = new Member[this.SIZE];
		int index = 0;
		
		for(int i=0; i<m.length; i++) {
			if(m[i] != null && m[i].getName().equals(name)) {				
				
				mArr[index ++] = m[i];				
				
			}			
		}		
		return mArr;
	}
	
	public Member[] searchEmail(String email) {
		Member[] mArr = new Member[this.SIZE];
		int index = 0;
		
		for(int i=0; i<m.length; i++) {
			if(m[i] != null && m[i].getName().equals(email)) {				
				
				mArr[index ++] = m[i];				
				
			}			
		}		
		return mArr;
	}
	
	/*
	 성공적으로 비밀번호 변경 시 return true
	 			   실패 시 return false
	 */
	public Boolean updatePassword(String id, String password) {
		for(int i=0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				//배열 m의 i번째 인덱스가 null이 아니고 사용자가 입력한 id가 동일할 때
				m[i].setPassword(password);
				return true;			
			}
		}
		return false; //배열의 모든 index에 담긴 member를 확인하였지만, id가 같은 member를 찾지 못함.
	}
	
	public Boolean updateName(String id, String name) {
		for(int i=0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				//배열 m의 i번째 인덱스가 null이 아니고 사용자가 입력한 id가 동일할 때
				m[i].setName(name);
				return true;			
			}
		}
		return false; //배열의 모든 index에 담긴 member를 확인하였지만, id가 같은 member를 찾지 못함.
				
	}
	
	
	public Boolean updateEmail(String id, String email) {
		for(int i=0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				//배열 m의 i번째 인덱스가 null이 아니고 사용자가 입력한 id가 동일할 때
				m[i].setEmail(email);
				return true;			
			}
		}
		return false; //배열의 모든 index에 담긴 member를 확인하였지만, id가 같은 member를 찾지 못함.
	}
	
	//true → 정상적으로 삭제 됨
	//false → id를 찾지 못함→
	public Boolean delete(String id) {
		for(int i=0; i<m.length; i++) {
			if(m[i] == null) {
				return false;
			}else if(m[i].getId().equals(id)) { //찾았을 때
				for(int j=i; j<m.length - 1; j++) {
					m[j] = m[j+1];
				}
				m[m.length-1] = null;
				return true; 
			}
		}
		return false;
	}
	
	public void delete() {
		/*
		for(int i=0; i<m.length; i++) {
			
		}
		
		*/		
		this.m = new Member[this.SIZE]; //새로 만들어서 초기화  ex) 기존에 그리던 그림에서 [File]->[새로만들기] 한 것과 같다. 
	}
	
	public Member[] printAll(){
				
		return this.m;
	}
	
	
	
	
}
