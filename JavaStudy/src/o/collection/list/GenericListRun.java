package o.collection.list;

import java.util.ArrayList;
import java.util.List;

public class GenericListRun {
	
	public static void main(String[] args) {
		List<Music> list = new ArrayList<>();
		
		list.add(new Music("Love story", "볼사"));
		list.add(new Music("노래","가수"));
		list.add(new Music("가을아침","아이유"));
		list.add(new Music("김사월","프라하"));
		
		System.out.println(list);
		
		for(Music m : list) {
			System.out.println(m);
		}
		
		/*
		 	☁ 제네릭을 사용하는 이유 ( •̀ ▽ •́ )✧
		 	   1. 명시된 타입의 객체만 저장하도록 제한을 둘 수 있다.
		 	   2. 컬렉션에 저장된 객체를 열어서 사용할 때 매번 형변환하는 절차를 없애기 위해서
		 */
		
		
		
	}
}
