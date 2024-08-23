package model.vo;

public class Chara extends Tool{
	private int charaNo;
	private String chaName;
	private String chaTool;
	private String job;	
	private String status;
	
	public Chara() {
		super();
	}

	public Chara(String chaName) {
		super();
		this.chaName = chaName;
		}

	public Chara(int charaNo, String chaName, String chaTool, String job, String status) {
		super();
		this.charaNo = charaNo;
		this.chaName = chaName;		
		this.chaTool = chaTool;
		this.job = job;
		this.status = status;
	}
	
	public int getCharaNo() {
		return charaNo;
	}

	public void setCharaNo(int charaNo) {
		this.charaNo = charaNo;
	}

	public String getChaName() {
		return chaName;
	}

	public void setChaName(String chaName) {
		this.chaName = chaName;
	}

	public String getChaTool() {
		return chaTool;
	}

	public void setChaTool(String chaTool) {
		this.chaTool = chaTool;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "이름 : " + this.chaName + ", \n나이 :" + "\n도구 :" + this.chaTool
				+ "\n직업 : " + this.job + "\n상태 : " + this.status ;
	}
	
	
	
	
}
