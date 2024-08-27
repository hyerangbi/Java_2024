package model.vo;

public class Chara extends Tool{	
	private String chaName;
	private String chaTool;
	private String job;	
	private String status;
	
	public Chara() {
		super();
	}
	
	
	public Chara(String job, String status) {
		super();
		this.job = job;
		this.status = status;
	}



	public Chara(String chaName) {
		super();
		this.chaName = chaName;
		}


	public Chara(String chaName, String chaTool, String job, String status) {
		super();		
		this.chaName = chaName;		
		this.chaTool = chaTool;
		this.job = job;
		this.status = status;
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
		return "이름 : " + this.chaName + "\n도구 : " + this.chaTool
				+ "\n직업 : " + this.job + "\n상태 : " + this.status ;
	}
	
	
	
	
}
