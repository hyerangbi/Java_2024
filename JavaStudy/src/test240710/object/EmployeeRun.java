package test240710.object;

public class EmployeeRun {

	public static void main(String[] args) {
		Employee human = new Employee();
		
		human.setEmpNo(100);
		human.setEmpName("홍길동");
		human.setDept("영업부");
		human.setJob("과장");
		human.setAge(25);
		human.setGender('남');
		human.setSalary(25000000);
		human.setBounsPoint(0.05);
		human.setPhone("010-1234-5678");
		human.setAddress("서울시 강남구");
		
		System.out.println("번호 : " + human.getEmpNo());
		System.out.println("이름 : " + human.getEmpName());
		System.out.println("부서 : " + human.getDept());
		System.out.println("직책 : " + human.getJob());
		System.out.println("나이 : " + human.getAge());
		System.out.println("성별 : " + human.getGender());
		System.out.println("급여 : " + human.getSalary());
		System.out.println("보너스 : " + human.getBounsPoint());
		System.out.println("전화번호 : " + human.getPhone());
		System.out.println("주소 : " + human.getAddress());

	}

}
