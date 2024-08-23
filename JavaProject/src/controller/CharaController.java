package controller;

import model.vo.Chara;
import model.vo.Tool;

public class CharaController {
	
	public Chara insertName(String chName){
		Chara cha = new Chara(chName);
		
		return cha;
	}
	
	public Chara insertJob(Chara cJob) {
		Chara job = new Chara();
		int type = (int)(Math.random() * 1);
	
		switch(type){
			case 0:
				job.setJob("백수");
				break;
			case 1:
				job.setJob("눈사람");
				break;
			default:
				System.out.println("?");
		}
		return job;
	}
	
	public void insertStatus(int chStat) {
		Chara c = new Chara();
		String status = null;
		int type = (int)(Math.random() * 1);
		
		switch(type){
			case 0:
				status = "평온";				
				break;
			case 1:
				status = "졸림";
				break;
			default:
				System.out.println("?");
		}
		
	}
	
	public String insertTool(Tool toolName) {
		Tool t = new Tool();
		Chara c = new Chara();
		
		c.setChaTool(null);
		
		return null;
	}
	
	public boolean delete (Chara c) {
		return false;
	}
}
