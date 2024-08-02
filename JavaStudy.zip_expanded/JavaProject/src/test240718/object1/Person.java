package test240718.object1;

public class Person {
	private String name;
	private int age;
	private double height;
	private double weight;
	
	
	public Person() {
		super();
	}
	
	
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
	
}
