package test240712.object2;

public class StringTest {

	public static void main(String[] args) {
		String str = "1.22, 4.12 , 5.93, 8.71, 9.34";
		
		//문자열.split(",")   ,(,은 예시 "" 안에 있는 문자를 기준)기준으로 배열로 바꿀 수 있다
		//문자열은 구분자론 나눠서 배열로 반환하는 메소드
		
		//배열에 들어있는 모든 요소를 가져와서 사용하는 경우가 매우 많다.
		//for(자료형 변수명 : 배열){
		// 		변수명 -> 배열에 있는 모든 요소가 한번 씩 들어와서 반복
		//}
		
		double sum = 0;
		
		// str에서 데이터를 분리한다.
		
		String[] sArr = str.split(",");
		double data[]= new double[sArr.length]; 
		
		
		for(int i=0; i<sArr.length; i++){//for~each 문 사용한다.			
			// 배열에 실수 데이터를 넣는다. 
			data[i] = Double.parseDouble(sArr[i]);
			
			}
		
		
		for(double d : data) {
			sum += d;
		}
		
		
		// 결과 값을 출력 한다.
		
		System.out.println("합계 : "+ sum);
		System.out.println("평균 : "+ (sum/data.length));
	}

}
