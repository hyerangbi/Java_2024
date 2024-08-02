package test240718.object1;

public class PersonController {
	Person[] p = new Person[20];
//	Student[] s = new Student[3];
//	Employee[] e = new Employee[10]; ->
	
	public int[] personCount() {
		
		int studentCount = 0 , employeeCount = 0;
		int[] cArr = new int[2];
		
		for(Person tmp : p) {
			if(tmp == null) {
				break;
			}else if(tmp instanceof Student) {
				studentCount ++;
			}else if(tmp instanceof Employee) {
				employeeCount ++;
			}
			
		}
		
		/*
		for(int i=0; i<p.length; i++) {
			if(p[i] != null) {
				Count ++;
			}else{
				break;
			}
		}
		*/
/*		for (Employee emp : e) {
			if(emp == null) {
				break;
			}
				eCount ++;
		}
*/
		//cArr[0] = Count;
				
		return cArr;
	}
			
	public void insertPerson(String name, int age, double height, double weight
			, int grade, String major) {
		
		for(int i=0; i<p.length; i++) {
			if(p[i] == null) {
				p[i] = new Student(name, age, height, weight, grade, major);
				return;
			}
		}
	}
	
	public Student[] printStudent() {
		
		
		return (Student[]) this.p;
	}
	
	
	
	
	
	
	
	
	
	
	public void insertEmployee(String name, int age, double height, double weight,
			int salary, String dept) {
		
		for(int i=0; i<p.length; i++) {
			if(p[i] == null) {
				p[i] = new Employee(name, age, height, weight, salary, dept);
				return;
			}
		}
	}
	
	public Employee[] printEmployee() {
		return null;
	}
}
