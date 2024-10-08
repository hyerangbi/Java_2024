package test240731.object1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FarmController {
	private HashMap<Farm, Integer> hMap; //마트 저장용
	private ArrayList<Farm> list; //고객이 구매한 내역
	
	public FarmController() {
		super();
		this.hMap = hMap;
		this.list = list;
	}

	public boolean addNewKind(Farm f,int amount) {
		if(hMap.containsKey(f)) { //f라는 키로 데이터가 존재한다면 -> 추가불가
			return false;
		}else { //추가가능
			hMap.put(f, amount);
			return true;
		}
		
	}
	
	public boolean removeKind(Farm f) {
		if(hMap.containsKey(f)) {
			hMap.remove(f);
			return true;
		}
		return false;
	}
	
	public boolean changeAmount(Farm f, int amount) {
		if(hMap.containsKey(f)) {
			hMap.replace(f, amount);
			return true;
		}
		return false;
	}
	
	public HashMap<Farm, Integer> printFarm(){
		
		return this.hMap;
	}
	
	public boolean buyFarm(Farm f) {
		Integer amount = hMap.get(f);
		if (amount != null && amount > 0) {
			list.add(f);
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	public boolean removeFarm(Farm f) {
		return false;
	}
	
	public ArrayList<Farm> printBuyFarm(){
		return null;
	}
	
}
