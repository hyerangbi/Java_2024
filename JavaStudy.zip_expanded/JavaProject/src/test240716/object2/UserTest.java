package test240716.object2;

public class UserTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		User[] users = new User[3];
		
		users[0] = new User("user01", "pass01", "김철수", 32, 'M', "010-1234-5678");
		users[1] = new User("user02", "pass02", "이영희", 25, 'F', "010-5555-7777");
		users[2] = new User("user03", "pass03", "황진이", 20, 'F', "010-9874-5632");
		
		System.out.println("users list ---------------------------------------------");
		
		for(int i=0; i<users.length; i++) {
			System.out.println(users[i].toString());
		}
		
		System.out.println("copyUsers ----------------------------------------------");
		
		User[] copyUsers = new User[users.length];
		for(int i=0; i<copyUsers.length; i++) {
			User copy = copyUsers[i];
			System.out.println(copy.toString());
			
		}
		/*
		for(User copy : copyUsers) {
			System.out.println(copy.toString());
		}    위에랑 같
		*/
		System.out.println("비교 결과 ------------------------------------------------");
		
		for (int i=0; i<copyUsers.length; i++) {
			System.out.println(copyUsers[i].equals(users[i]));
		}
	}
}
