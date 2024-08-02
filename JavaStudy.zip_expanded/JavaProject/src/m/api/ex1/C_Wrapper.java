package m.api.ex1;

public class C_Wrapper {
	/*
	 	☁Wrapper 클래스
	 	⇒ 기본자료헝을 객체로 포장해줄 수 있는 클래스가 래퍼클래스이다.
	 	
	 		boolean(Boolean)
	 		char(Character)
	 		byte(Byte)
	 		short(Short)
	 		int(Integer)
	 		long(Long)
	 		float(Float)
	 		double(Double)
	 		
	 	⇒ 기본자료형을 객체로 표현해야할 경우
	     ◾ 메소드 호출해야할 때 
	 		→ 메소드의 매개변수가 기본자료형이 아닌 객체타입만 요구될 때
	 	 ◾ 다형성을 적용시키고 싶을 때 
	 	 
	 */
	
	public void method01() {
		
		// 🔶 Boxing : 기본자료형 → Wrapper클래스 자료형
		int num1 = 10;
		int num2 = 20;
		
		// 1. 객체 생성구문을 통한 방법
		Integer i1 = new Integer(num1); // num1 → i1
		Integer i2 = new Integer(num2); // num2 → i2
		
		System.out.println(i1);
		System.out.println(i2);
		
		System.out.println(i1.equals(i2));
		System.out.println(i1.compareTo(i2)); 
		// ↪ 두 값을 비교해서 앞쪽이 크면 1반환, 뒤쪽이 크면 -1반환, 같으면 0반환
		
		// 2. 객체생성따위 하지 않고 곧바로 대입방법 (AutoBoxing)
		Integer i3 = num1;
		System.out.println(i3);
		
		// 객체생성을 통해서 반드시 변환해야하는 경우 → 문자열을 Integer타입으로 변환하고 싶을 때
		Integer i4 = Integer.parseInt("123");		
		Integer i5 = new Integer("123");
		
		// UnBoxing : Wrapper 클래스 자료형 → 기본자료형
		
		// 1. 해당 그 Wrapper 클래스에서 제공하는 xxxValue()메소드를 통해서 가능
		int num3 = i3.intValue();
		int num4 = i4.intValue();
		
		// 2. 메소드를 사용하지 않고 바로 대입하는 방법
		int num5 = i3;
		
		// 기본자료형 ←——————————→ String 
		String str1 = "10";
		String str2 = "15.5"; 
		 
		System.out.println(str1 + str2);
		
		/*
		 String → 기본자료형
		    "10" → 10
		  "15.5" → 15.5
		해당 Wrapper클래스.pasrseXXX()사용 
		 */
		
		int i = Integer.parseInt(str1);
		double d = Double.parseDouble(str2);
		System.out.println(i+d);
		
		// 기본 자료형 → String
		System.out.println(i + "");
		System.out.println(String.valueOf(i));
		System.out.println(String.valueOf(d));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
