package re.r240717.review1;

public class LibraryController {
	private Member mem;
	private Book[] bList = new Book[5];
	
	public LibraryController(){
		super();		
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true); 
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19); 
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12); 
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false); 
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	
	}
	
	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return this.mem;
	}
	
	public Book[] selectAll() {
		return this.bList;
	}
	
	public Book[] searchBook(String keyword) {
		Book[] tmpBookList = new Book[5]; //검색결과를 담아줄 객체배열
		//검색 결과의 도서목록 최대가 5개
		int index = 0;
		
		for(int i=0; i<bList.length; i++) {
			
		}
		
		return null;
	}
	
	public int rentBook(int index) {
		return 0;
	}
}
