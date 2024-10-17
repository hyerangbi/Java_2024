package com.kh.etc.opendata.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Run {
	public static final String SERVICE_KEY = "V%2Fp0jmpnknwLHkbhBu%2Fg%2BCti2k%2FDxJ49zTGak3O7shgkxzjIvvjJBqvL4%2BQrgxPV6UHyjxJvhmzvOrTg2WZerA%3D%3D";
	
	public static void main(String[] arg) throws IOException {
		 String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		 url += "?serviceKey" + SERVICE_KEY;
		 url += "&returnType=json";
		 url += "&sidoName=" + URLEncoder.encode("서울", "UTF-8"); // 요청 시 전달 값에 한글이 있으면 인코딩 작업후 전송하기 
		 
		 // System.out.println(url);
		 
		 // 자바코드로 클라이언트 역할을 해서 서버로 요청으 보낼 때
		 // HttpURLConnection 객체를 이용해서 요청을 보낸다.
		 
		 // 1. 요청하고자 하는 url을 전달하면서 java.net.URL 객체 생성
		 URL requestURL = new URL(url);
		 
		 // 2. 만들어진 URL객체를 가지고 HTTPURLConnection 객체 생성
		 HttpURLConnection urlConnection = (HttpURLConnection) requestURL.openConnection();
		 
		 // 3. 요청에 필요한 Header 정보 설정하기
		 urlConnection.setRequestMethod("GET"); 
		 
		 // 4. 해당 api 서버로 요청 보낸 후 입력 데이터 읽어오기
		 BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		 
		 String result = "";
		 String line;
		 while((line = br.readLine()) != null){ // 한 줄씩 읽어서 반환
			 result += line;
		 }
		 
		 System.out.println(result);
		 
		 
		 
	}
}
