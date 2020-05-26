package spms.dto;

public class MemberDto {
	private int no;
	private String email;
	private String pwd;
	private String nickname;
	private String grade = "0";
	
	
	public MemberDto() {
		super();
	}

	

	public MemberDto(int no, String email, String nickname) {
		super();
		this.no = no;
		this.email = email;
		this.nickname = nickname;
	}



	public MemberDto(int no, String email, String pwd, String nickname) {
		super();
		this.no = no;
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
	}


	public MemberDto(int no, String email, String pwd, String nickname, String grade) {
		super();
		this.no = no;
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
		this.grade = grade;
	}



	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + ", grade="
				+ grade + "]";
	}
	
}
