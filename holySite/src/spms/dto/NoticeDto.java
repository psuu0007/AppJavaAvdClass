package spms.dto;

import java.util.Date;

public class NoticeDto {
	private int no;
	private String title;
	private String text;
	private Date createdDate;
	private MemberDto writer;
	
	
	public NoticeDto() {
		super();
	}


	public NoticeDto(int no, String title, String text, Date createdDate, MemberDto writer) {
		super();
		this.no = no;
		this.title = title;
		this.text = text;
		this.createdDate = createdDate;
		this.writer = writer;
	}

	

	public NoticeDto(int no, String title, Date createdDate, MemberDto writer) {
		super();
		this.no = no;
		this.title = title;
		this.createdDate = createdDate;
		this.writer = writer;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public MemberDto getWriter() {
		return writer;
	}


	public void setWriter(MemberDto writer) {
		this.writer = writer;
	}


	@Override
	public String toString() {
		return "NoticeDto [no=" + no + ", title=" + title + ", text=" + text + ", createdDate=" + createdDate
				+ ", writer=" + writer + "]";
	}
	
	
}
