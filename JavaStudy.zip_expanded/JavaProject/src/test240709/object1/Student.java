package test240709.object1;

public class Student {
	
	//필드영역
	private int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
	//생성자 영역
	public Student(int grade, int classroom, String name, double height, char gender){
		super();
		this.grade = grade;
		this.classroom = classroom;
		this.name = name;
		this.height = height;
		this.gender = gender;
	}
	
	//메소드영역
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade() {
		if(grade<1) {
			this.grade = grade;
		}
	}
	
	public int getClassroom() {
		return classroom;
	}
	
	public void setClassroom() {
		if(classroom<1) {
			this.classroom =classroom;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setname() {
		this.name = name;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight() {
		if(height<1) {
			this.height = height;
		}
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender() {
		this.gender = gender;
	}
	
	public void information() {
		System.out.println("학년 : " + getGrade()+"\n"+
						   "교실 : " + getClassroom()+"\n"+
						   "이름 : " + getName() +"\n"+
						   "키 : " + getHeight() +"\n"+
						   "성별 : " + getGender());
	}

}
