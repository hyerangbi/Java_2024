package test240725.object1;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	
	public String afterToken(String str) {		 
		StringTokenizer stn = new StringTokenizer(str);
		
		
		String newStr = "";
				
		while(stn.hasMoreElements()) {
			newStr += stn.nextToken();
			
		}
		System.out.println(newStr);
		return newStr;
		
		
	}
	
	public String fristCap(String input) {
		// 매개변수로 받아온 input의 첫 번째 글자만 대문자로 바꾼 문자열 반환 
		String str = "";
		/*
		for(int i=0; i<input.length(); i++) {
			str += (i == 0 ? (input.charAt(i) + "").toUpperCase() : input.charAt(i));
			// 0번째 ~ 
		}
		*/
		
		str = input.substring(0, 1).toUpperCase() + input.substring(1);
				
		return str;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		/*
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == one) {
				count ++;
			}		
		}
		*/
		
		for (char c : input.toCharArray()) {
			if ( c == one ) {
				count ++;
			}
		}
		return count;
	}
}
