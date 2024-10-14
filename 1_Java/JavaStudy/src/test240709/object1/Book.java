package test240709.object1;

public class Book {
	//필드 영억
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;
	
	public Book() {
		this("미입력", "미정", "미입력", 0, 0);
	}
	public Book(String title, String publisher, String author) {		
		super();
		this.title =title;
		this.publisher = publisher;
		this.author = author;
	}
	public Book(String title, String publisher, String author, int price, double discountRate) {
		super();
		this.title =title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}
	
	public void inform(){
		System.out.println("책 이름 : "+title+"\n"
							+"출판사 "+publisher+"\n"
							+"저자 : "+author);
		System.out.println("책 이름 : "+title+"\n"+
							"출판사: "+ publisher+"\n"+
							"저자 : "+author+"\n"+
							"가격 : "+price+"\n"+
							"할인율 : "+discountRate);
	}
}
