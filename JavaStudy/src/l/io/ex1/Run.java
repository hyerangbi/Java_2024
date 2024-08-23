package l.io.ex1;

import java.io.File;
import java.io.IOException;

public class Run {
	
	/*
	 * 간단하게 파일을 만들어보자
	 * java.io.File클래스를 가지고 
	 */
	
	public static void main(String[] agrs) {
		//1. 경로지정을 딱히 하지 않고 파일 생성하기
		File f1 = new File("test.txt"); // 파일 객체를 하나 만든 상태(실제파일 x) 
		//2. 존재하는 폴더에 파일 생성
		File f2 = new File("D:\\test2.txt");
		//3. 존재하지 않는 경로에 파일 생성
//		File f3 = new File("D:\\tmp\\text.txt");
		try {
			
			f1.createNewFile(); // createNewFile 메소드가 실행할 때 실제 파일이 만들어짐 / outputStream을 사용하여 만듬
			f2.createNewFile();
//			f3.createNewFile(); // 존재하지 않는 경로로 생성 시 예외 발생 → IOException
			
			//3. 폴더 먼저 만들고 파일 만들어지게 하는 방법
			File tmpFolder = new File("D:\\tmp");
			tmpFolder.mkdir();
			
			File f3 = new File("D:\\tmp\\test.txt");
			f3.createNewFile();
			//파일의 존재유무를 코드로 확인할 수 있다.
						
			File f4 = new File("ttt.txt");
			System.out.println(f4.exists());
			System.out.println(f4.createNewFile());
					
			//파일인지 확인하는 메소드
			System.out.println(f1.isFile());
			System.out.println(tmpFolder.isFile());
			
			// -----------------------------------------
			
			File folder = new File("parent"); //InputStream을 사용한 것이다.
			folder.mkdir();
			
			File file = new File("parent\\person.txt"); 
			file.createNewFile(); //파일을 만든 것이 아니라 객체를 만든 것이다.
			
			System.out.println("파일 명 : " + file.getName());
			System.out.println("파일 경로 : " + file.getAbsolutePath());
			System.out.println("파일 용량 : " + file.length());
			System.out.println("파일 상위 폴더 : " + file.getParent());
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
