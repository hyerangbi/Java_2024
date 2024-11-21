package com.kh.etc.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APITestController {
	public static final String serviceKey = "V%2Fp0jmpnknwLHkbhBu%2Fg%2BCti2k%2FDxJ49zTGak3O7shgkxzjIvvjJBqvL4%2BQrgxPV6UHyjxJvhmzvOrTg2WZerA%3D%3D";
	
	@ResponseBody
	@GetMapping(value = "wave", produces="application/json; charset=UTF-8")
	public static void main(String[] agrs) throws IOException {
		String url = "http://apis.data.go.kr/1741000/EarthquakeIndoors3";
		
		url += "?serviceKey="+serviceKey;
		url += "&sidoName=" + URLEncoder.encode("location","UTF-8");
		url += "&returnType=json";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
		urlConnection.disconnect();
	}
}
