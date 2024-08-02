package test240715.object1;

import java.util.Scanner;

public class StudentRun {
	/*
	 학생성적관리 프로그램을 만들고자한다.
	 학생 클래스를 정의해보자. Student class는 name(String), classRoom(int),
	 javaScore(double), sqlScore(double), practics(double)값을 가진다.
	 각 필드데이터의 getter/setter, 기본생성자, 모든 필드 데이터를 초기화하는 생성자를 작성하고
	 또한 toString : 학생의 정보를 "xx반 xxx학생 xx점 xx점 xx점" 으로 정보를 반환하는 메소드를 각 점수는 자바, sql, pratics순으로 작성
	 	isPassd : 모든 점수가 50점 이상이면서 평균 60점 이상이면 true 아니면 false 를 반환하는 메소드
	 	reTest : 학생의 모든 점수를 랜덤(0~100)으로 다시 부여하는 메소드 반환없음
	 	
	 	학생 10명을 생성하고 reTest를 실행한 후 모든 학생의 점수를 출력하라.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student[] stArr = new Student[10];
		
		
		for(int i=0; i<stArr.length; i++) {
			System.out.print("이름 : ");
			stArr[i].setName(sc.next());
			
			
			System.out.print("반:");
			stArr[i].setClassRoom(sc.nextInt());
			
			stArr[i].reTest();
		}
		System.out.printf("%5s %3s %4s %4s %4s",
				"이름", "반", "자바", "sql", "실습");
		
		for(int i=0; i<stArr.length; i++) {
			Student st = stArr[i];
			System.out.printf("%5s %3d %4.2f %4.2f %4.2f \n",
					st.getName(), st.getClassRoom()
					, st.getJavaScore(), st.getSqlScore(), st.getSqlScore()
					,st.getPracticeScore());
		}
		
	}
	
}
