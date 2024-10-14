package com.kh.board.model.vo;

public class Reply {
	private int replyNo;
	private String replyContent;
	private int refBoardNo;
	private String replyWriter;
	private String createDate;
	private String status;
	
	public Reply() {
		super();
	}

	public Reply(int replyNo, String replyContent, int refBoardNo, String replyWrite, String createDate,
			String status) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.refBoardNo = refBoardNo;
		this.replyWriter = replyWrite;
		this.createDate = createDate;
		this.status = status;
	}
	
	

	public Reply(int replyNo, String replyContent, String replyWriter, String createDate) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getRefBoardNo() {
		return refBoardNo;
	}

	public void setRefBoardNo(int refBoardNo) {
		this.refBoardNo = refBoardNo;
	}

	public String getreplyWriter() {
		return replyWriter;
	}

	public void setreplyWriter(String replyWrite) {
		this.replyWriter = replyWrite;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", refBoardNo=" + refBoardNo
				+ ", replyWrite=" + replyWriter + ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
}
