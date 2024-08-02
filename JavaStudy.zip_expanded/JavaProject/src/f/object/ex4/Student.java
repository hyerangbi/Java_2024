package f.object.ex4;

// 이름 나이 수학점수 영어점수 국어점수를 데이터로 가지고 있는 개체를 만들어라
// 데이터는 직접 접근을 허용하지 않고 모두 간접적으로 set/get을 해줄 수 있도록 작성해라
// 모든 데이터를 매개변수로 받아 초기화하면서 객체를 생서할 수 있는 생성자를 작성

public class Student {
	
	//필드영역
	private String name;
	private int age;
	private int ko;
	private int ma;
	private int en;
	
	//생성자영역 / ⭐ 단축키 : alt + shift + s → o
	public Student() {
		
	}
	
	
	
	public Student(String name, int age, int ko, int ma, int en) {
		super();
		this.name = name;
		this.age = age;
		this.ko = ko;
		this.ma = ma;
		this.en = en;
	}



	//메소드영역(기능)		
	// getter  setter
	// 단축키 : alt + shift + s → r
	public String getName() {
		return this.name;
	}	

	public void setName(String name) {
		this.name = name;
	}
	

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if(age<1) {
			this.age = age;
			return; //메소드 종료
		}
	}

	public int getKo() {
		return this.ko;
	}

	public void setKo(int ko) {
		if(ko<1) {
			this.ko = ko;
		}
	}

	public int getMa() {
		return this.ma;
	}

	public void setMa(int ma) {
		if(ma<1) {
			this.ma = ma;
		}
	}

	public int getEn() {
		return this.en;
	}

	public void setEn(int en) {
		if(en<1) {
			this.en = en;
		}
	}

	public double getEvg() {
		double evg = (this.ko + this.ma + this.en)/3.0;
		return evg;
	}
	
	public void printEvg() {
		System.out.println(this.getName() + " 님의 평균 : " + this.getEvg());
	}
}
