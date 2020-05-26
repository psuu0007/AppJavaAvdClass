package mtp.boardManageDto;

public class BoardManagementDto {

	private int no = 0;
	private String writer = "";
	private String title = "";
	private String context = "";
	
	public BoardManagementDto() {
		super();
	}

	public BoardManagementDto(int no, String writer, String title) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
	}

	public BoardManagementDto(String writer, String title, String context) {
		super();
		this.writer = writer;
		this.title = title;
		this.context = context;
	}

	public BoardManagementDto(int no, String writer, String title, String context) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.context = context;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "boardManagementDto [no=" + no + ", writer=" + writer + 
			   ", title=" + title + ", context=" + context + "]";
	}
	
	
}
