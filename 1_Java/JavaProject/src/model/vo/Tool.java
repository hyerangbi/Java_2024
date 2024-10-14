package model.vo;

public class Tool{
	
	private int toolNo;
	private String toolName;
	private int toolDe;
	
	public Tool() {
		super();
	}
	
	public Tool(int toolNo) {
		super();
		this.toolNo = toolNo;
	}
	
	public Tool(int toolNo, String toolName, int toolDe) {
		super();
		this.toolNo = toolNo;
		this.toolName = toolName;
		this.toolDe = toolDe;
	}
	
	public int gettoolNo() {
		return toolNo;
	}
	
	public void settoolNo(int toolNo) {
		this.toolNo = toolNo;
	}
	
	public String gettoolName() {
		return toolName;
	}
	
	public void settoolName(String toolName) {
		this.toolName = toolName;
	}
	
	public int gettoolDe() {
		return toolDe;
	}
	
	public void settoolDe(int toolDe) {
		this.toolDe = toolDe;
	}
	
	@Override
	public String toString() {
		return "toolName=" + toolName + "\ntoolDe=" + toolDe;
	}
	
	
	
}
