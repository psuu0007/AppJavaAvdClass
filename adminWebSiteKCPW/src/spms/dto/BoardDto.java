package spms.dto;

import java.util.Date;

public class BoardDto {

	private int boardNo;
	private String title;
	private String content;
	private String email;
	private String myName;
	private Date createdDate;
	private Date modifiedDate;
	private int readCount;
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int boardNo, String title, String content, String email) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.email = email;
	}
	
	public BoardDto(int boardNo, String title, String content, String email, Date createdDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.email = email;
		this.createdDate = createdDate;
	}
	
	public BoardDto(int boardNo, String title, String content, String email, Date createdDate, String myName,
			Date modifiedDate, int readCount) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.email = email;
		this.createdDate = createdDate;
		this.myName = myName;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
	}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	
	
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", email=" + email
				+ ", createdDate=" + createdDate + ", myName=" + myName + ", modifiedDate=" + modifiedDate
				+ ", readCount=" + readCount + "]";
	}
	
	
}
