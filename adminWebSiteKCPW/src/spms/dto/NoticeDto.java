package spms.dto;

import java.util.Date;

public class NoticeDto {

	private int noticeNo;
	private String title;
	private String content;
	private String creEmail;
	private String modEmail;
	private String myName;
	private Date createdDate;
	private Date modifiedDate;
	
	public NoticeDto() {
		super();
	}
	public NoticeDto(int noticeNo, String title, String content) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
	}	
	public NoticeDto(int noticeNo, String title, String content, String creEmail) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
		this.creEmail = creEmail;
	}
	public NoticeDto(int noticeNo, String title, String content, String creEmail, Date createdDate) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
		this.creEmail = creEmail;
		this.createdDate = createdDate;
	}
	

	public NoticeDto(int noticeNo, String title, String content, String creEmail, 
			String modEmail, String myName, Date createdDate, Date modifiedDate) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
		this.creEmail = creEmail;
		this.modEmail = modEmail;
		this.myName = myName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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
	public String getCreEmail() {
		return creEmail;
	}
	public void setCreEmail(String creEmail) {
		this.creEmail = creEmail;
	}
	public String getModEmail() {
		return modEmail;
	}
	public void setModEmail(String modEmail) {
		this.modEmail = modEmail;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	@Override
	public String toString() {
		return "NoticeDto [noticeNo=" + noticeNo + ", title=" + title + ", content=" + content + ", creEmail="
				+ creEmail + ", modEmail=" + modEmail + ", myName=" + myName + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}

}
