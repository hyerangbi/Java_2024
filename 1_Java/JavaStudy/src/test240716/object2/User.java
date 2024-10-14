package test240716.object2;

public class User {
	private String id;
	private String password;
	private String name;
	private int age;
	private char gender;
	private String phone;
	
	
	public User() {
		super();
	}


	public User(String id, String password, String name, int age, char gender, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}


	@Override
	public boolean equals(Object obj) {
		User tmp = (User)obj;
		
		
		return this.id.equals(tmp.id)&&
				this.password.equals(tmp.password)&&
				this.name.equals(tmp.name)&&
				this.age == tmp.age &&
				this.gender == tmp.gender &&
				this.phone.equals(tmp.phone);
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		User copy = new User(id, password, name, age, gender, phone);
		return copy;
	}


	@Override
	public String toString() {

		return id + " " + password + " " + name +
				" " + phone;
	}


	
	
	
	
}
