package mtp.notice.dto;

public class NoticeDto {
	
	int no = 0;
	String title = "";
	String writer = "";
	String context = "";
	
	public NoticeDto() {
		super();
	}

	public NoticeDto(int no, String title, String writer, String context) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.context = context;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "NoticeDto [no=" + no + ", title=" + title + ", writer=" + writer + ", context=" + context + "]";
	}
	
}
