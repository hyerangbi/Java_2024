package test240710.object;

public class Person {
	String name = "이름 없음"; // 값이 없다면 "이름 없음"
	int age; // 값이 없다면 1
	
	//모든 필드 데이터를 전달받은 값으로 초기화하는 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("name : " + name + " age : "+age);
	}

	// name값만을 전달받아 초기화하는 생성자
	public Person(String name) { // 생성자는 항상 맨 앞에 호출		
		this(name, 1); // this() 는 본인의 생성자 호출, 생성자의 가장 첫번째 줄에 작성해야한다.	
		System.out.println("name: "+ name + " age : " + age);
	}

	// 값을 전달받지 않고 초기화하는 생성자
	public Person() {		
		this("이름 없음", 1);
		System.out.println("name : " + name + " age : " + age);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
}
