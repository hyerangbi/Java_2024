package test240711.object3;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		
		
		Book[] arr = new Book[3]; 
		
		// arr[0] = new Book("안녕", "소설", "김철수", 50);
		// System.out.println(arr[0].toString());
			
		/*
		 	우리는 도서관에서 책을 관리하는 프로그램을 만들려고한다.
		 	해당 클래스는 도서관에 책을 등록할 때 사용하는 book객체를 생성할 Book클래스이다.
		 	필요하다고 생각하는 데이터와 기능을 구현해보자.
		 	
		 	
		 	
		 	◾◾ 사용자로부터 제목, 장르, 저자, 책번호를 입력받아
		 		b1이라는 객체를 생성하고 생성된 객체의 toString 메소드를 호출하여 모든 정보를 확인하자 
		 	
		 */
		
		
//		Book b1=null, b2 = null, b3 = null;
		
		Book[] barr = new Book[3];
		
		
		
			
			/*
				
				
				//Book tmpBook = new Book(title, genre, author, num);
				
				for(int i=0; i<barr.length; i++) {
					if(barr[i] == null) {
						barr[i] = new Book(title, genre, author, num);
						break;
					}
					// i = 9일때
					else if(i == (barr.length -1)) {
						System.out.println("이미 등록할 수 있는 책이 가득 찼습니다.");
					}
				}
								
				System.out.println("책이 등록되었습니다.");
				//System.out.println(tmpBook.toString());
				break;
			
				
			case 2:
				System.out.println("=========== 등록 도서목록 ===========");
				
				for(int i=0; i<barr.length ; i++) {
					if(barr[i] == null) {
						break;
					}
					System.out.println(barr[i].toString());
				}
				
				*/
				
				
				/*
				if(b1 != null ) {
					System.out.println(b1.toString());
				}
				if(b2 != null ) {
					System.out.println(b2.toString());
				}
				if(b3 != null ) {
					System.out.println(b1.toString());
				}
				*/
		/*
				break;
				
				
				
			case 3:				
				System.out.println("============= 도서검색 =============");
				System.out.print("검색할 책 이름 입력 : ");
				String target = sc.nextLine();
				// 책 정보				
				//or 입력하신 제목의 책은 등록되어있지 않습니다.
				
				for(int i=0; i<barr.length ; i++) { //null을 발견하면 뒤에 데이터는 null이므로 반복 종료
					if(barr[i] == null) {
						break;
					}
					
					else if(target.equals(barr[i].getTitle())) { // 동일한 제목 발견시 출력 후 
						System.out.println(barr[i].toString());
						break;
						}else {
							System.out.println("입력하신 제목의 책은 등록되어있지 않습니다.");
						}					
					}
				break;
				
				/*
				if(b1 != null && target.equals(b1.getTitle()) ) {
					System.out.println(b1.toString());
				}
				else if(b2 != null && target.equals(b2.getTitle()) ) {
					System.out.println(b2.toString());
				}
				else if(b3 != null && target.equals(b3.getTitle()) ) {
					System.out.println(b1.toString());
				}
				else {
					System.out.println("입력하신 제목의 책은 등록되어있지 않습니다.");
				}
				
				*/
				/*			
			case 4:
				System.out.println("========== 등록 도서목록 ===========");
				for(int i=0; i<barr.length ; i++) {
					if(barr[i] == null) {
						break;
					}
					System.out.println(barr[i].toString());
				}
				
				System.out.print("삭제할 도서의 번호 입력 : ");
				int num1 = sc.nextInt();
				
				//배열에서 해당 책 삭제
				for(int i=0; i<barr.length; i++) {
					if(barr[i] == null) {
						System.out.println("삭제할 도서의 번호를 찾지 못하였습니다.");
						break;
					}
					else if(num1 == barr[i].getNumber()) {						
						System.out.println("선택한 책 삭제하였습니다.");
						//삭제할 위치부터 마지막위치까지 모든 값을 한칸씩 앞으로 당김
						for(int j=i; j<(barr.length - 1); j++) {
							barr[j] = barr[j+1];					
						}
						//마지막 값에 null대입
						barr[barr.length-1] = null;
						
						
					}
				}
				
				break;
				
				
			case 9:
				System.out.println("도서관리 프로그램이 종료됩니다.");
				return;
			
			default:
				
			
			}
		
		}
		
		
		*/
		
		
		
		
		
	}

}
