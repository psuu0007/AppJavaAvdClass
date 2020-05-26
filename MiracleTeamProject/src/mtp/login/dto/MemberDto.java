package mtp.login.dto;

public class MemberDto {
	private int no;
	private String name;
	private String email;
	private String password;

	public MemberDto() {
		super();
	}
	
	public MemberDto(int no, String name, String email, String password) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public MemberDto(int no, String name, String email) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
