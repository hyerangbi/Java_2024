package test240709.object1;

import java.util.Scanner;

public class StudentRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("** 정보를 입력해주세요 **");
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int classroom = sc.nextInt();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("키 : ");
		double height = sc.nextDouble();
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		Student saram1 = new Student(grade, classroom, name, height, gender); 
		saram1.information();
	}

}
