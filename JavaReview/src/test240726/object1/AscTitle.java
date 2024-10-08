package test240726.object1;

import java.util.Comparator;

public class AscTitle implements Comparator<Music>{
	// 2가지 객체를 가져와서 비교할 때 이렇게 !
	@Override
	public int compare(Music o1, Music o2) {
		return o1.getTitle().compareTo(o2.getTitle());
		//      애가 더 크면 1                 애가 더 크면 -1
	}

	/*
	   ✨ compareTo : 나 자신과 비교해서 크면 1 작으면 -1 동일하면 0
	 */
	
}
