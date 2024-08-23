package test240716.object3;

public class PersonController {
	Student[] s = new Student[3];
	Employee[] e = new Employee[10];
	
	public int[] personCount() {
		
		int sCount = 0 , eCount = 0;
		int[] cArr = new int[2];
		
		for(int i=0; i<s.length; i++) {
			if(s[i] != null) {
				sCount ++;
			}else{
				break;
			}
		}
		for (Employee emp : e) {
			if(emp == null) {
				break;
			}
				eCount ++;
		}
		cArr[0] = sCount;
		cArr[1] = eCount;
		
		return cArr;
	}
			
	public void insertStudent(String name, int age, double height, double weight
			, int grade, String major) {
		
		for(int i=0; i<s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade, major);
				return;
			}
		}
	}
	
	public Student[] printStudent() {
		
		
		return null;
	}
	
	public void insertEmployee(String name, int age, double height, double weight,
			int salary, String dept) {
		
		for(int i=0; i<e.length; i++) {
			if(e[i] == null) {
				e[i] = new Employee(name, age, height, weight, salary, dept);
				return;
			}
		}
	}
	
	public Employee[] printEmployee() {
		return null;
	}
}
