package spms.dto;

import java.util.Date;

public class Board1Dto {

	private int no;
	private String title;
	private String writer;
	private String writerEmail;
	private String contents;
	private Date writeDate;
	
	public Board1Dto() {
		super();
	}

	public Board1Dto(int no, String title, String writer, Date writeDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public Board1Dto(int no, String title, String writer, String contents, Date writeDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.writeDate = writeDate;
	}

	
	
	public Board1Dto(int no, String title, String writer, String writerEmail, String contents, Date writeDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.writerEmail = writerEmail;
		this.contents = contents;
		this.writeDate = writeDate;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getWriterEmail() {
		return writerEmail;
	}

	public void setWriterEmail(String writerEmail) {
		this.writerEmail = writerEmail;
	}

	@Override
	public String toString() {
		return "Board1Dto [no=" + no + ", title=" + title + ", writer=" + writer + ", writerEmail=" + writerEmail
				+ ", contents=" + contents + ", writeDate=" + writeDate + "]";
	}



}
