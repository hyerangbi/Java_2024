package controller;

import model.vo.Chara;
import model.vo.Tool;

public class CharaController {
	private Chara c = new Chara();
	
	public String checkChName() {
		return c.getChaName();
	}
	
	public void insertName(String chName){
		c.setChaName(chName);		
	}
	
	public Chara insertJob() {
		
		int jobtype = (int)(Math.random() * 2);
		int stattype = (int)(Math.random() * 2);
	
		switch(jobtype){
			case 0:				
				c.setJob("사람");		
				break;
			case 1:
				c.setJob("눈사람");
				break;
			case 2:
				c.setJob("슬라임");
				break;
			default:
				c.setJob("알 수 없음");
		}
		
		switch(stattype){
			case 0:				
				c.setStatus("평온");		
				break;
			case 1:
				c.setStatus("졸림");
				break;
			case 2:
				c.setStatus("배고픔");
				break;
			default:
				c.setStatus("알 수 없는 상태");
		}				
		
		return c;
	}
	
	
	public String insertTool(Tool toolName) {
	
		c.setChaTool(null);
		
		return null;
	}
	
	public Chara reset() {
		c.setChaName(null);		
		c.setJob(null);
		c.setStatus(null);
		return c;
	}
	
	public void informCharaStat() {
		
		System.out.println(c.toString());
	}
}
