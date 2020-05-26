package spms.dto;

import java.util.Date;

public class Board2Dto {

	private int bno2;
	private String title2;
	private String writer2;
	private String writerEmail2;
	private String contents2;
	private Date writeDate2;
	
	public Board2Dto() {
		super();
	}
	
	

	public Board2Dto(int bno2, String title2, String writer2, String writerEmail2, String contents2, Date writeDate2) {
		super();
		this.bno2 = bno2;
		this.title2 = title2;
		this.writer2 = writer2;
		this.writerEmail2 = writerEmail2;
		this.contents2 = contents2;
		this.writeDate2 = writeDate2;
	}



	public Board2Dto(int bno, String title, String writer, String contents, Date writeDate) {
		super();
		this.bno2 = bno;
		this.title2 = title;
		this.writer2 = writer;
		this.contents2 = contents;
		this.writeDate2 = writeDate;
	}

	public Board2Dto(int bno, String title, String writer, Date writeDate) {
		super();
		this.bno2 = bno;
		this.title2 = title;
		this.writer2 = writer;
		this.writeDate2 = writeDate;
	}

	public int getBno2() {
		return bno2;
	}

	public void setBno2(int bno2) {
		this.bno2 = bno2;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getWriter2() {
		return writer2;
	}

	public void setWriter2(String writer2) {
		this.writer2 = writer2;
	}

	public String getContents2() {
		return contents2;
	}

	public void setContents2(String contents2) {
		this.contents2 = contents2;
	}

	public Date getWriteDate2() {
		return writeDate2;
	}

	public void setWriteDate2(Date writeDate2) {
		this.writeDate2 = writeDate2;
	}
	

	public String getWriterEmail2() {
		return writerEmail2;
	}

	public void setWriterEmail2(String writerEmail2) {
		this.writerEmail2 = writerEmail2;
	}

	@Override
	public String toString() {
		return "Board2Dto [bno2=" + bno2 + ", title2=" + title2 + ", writer2=" + writer2 + ", writerEmail2="
				+ writerEmail2 + ", contents2=" + contents2 + ", writeDate2=" + writeDate2 + "]";
	}
	
	

}
