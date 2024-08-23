package l.io.ex3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileChar {
	/*
	 "문자 기반스트림"을 활용하여 입출력
	 
	 ◾ 문자 기반 스트림 : 데이터를 2byte 단위로 전송하는 통로
	 
	   XXXRead : 입력용 스트림
	   XXXWrite : 출력용 스트림
	 */
	
	public void fileSave() {
		
		//1. 객체생성
		try(FileWriter fw = new FileWriter("char_test.txt");) {
			//2. write 메소드를 활용하여 데이터 출력
			fw.write("와 \'ㅁ\'");			
			fw.write(" ");
			
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	public void fileRead() {
		try (FileReader fr = new FileReader("char_test.txt");) {
			
			int value = 0;
			while((value = fr.read()) != -1) {
				System.out.println(value);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
