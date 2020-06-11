package com.edu.member.model;

import java.util.Date;

public class MemberFileDto {
	private int no;
	private String name;
	private String email;
	private String password;
	private Date createdDate;
	private Date modifiedDate;
	
	private int 			idx;
	private int 			parentSeq;        
	private String 			originalFileName;
    private String 			storedFileName;  
	private int 			fileSize; 
	private Date 			creDate;
	
	public MemberFileDto() {
		super();
	}

	public MemberFileDto(int no, String name, String email, String password, Date createdDate, Date modifiedDate,
			int idx, int parentSeq, String originalFileName, String storedFileName, int fileSize, Date creDate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.idx = idx;
		this.parentSeq = parentSeq;
		this.originalFileName = originalFileName;
		this.storedFileName = storedFileName;
		this.fileSize = fileSize;
		this.creDate = creDate;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getParentSeq() {
		return parentSeq;
	}

	public void setParentSeq(int parentSeq) {
		this.parentSeq = parentSeq;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	@Override
	public String toString() {
		return "MemberFileDto [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", idx=" + idx + ", parentSeq="
				+ parentSeq + ", originalFileName=" + originalFileName + ", storedFileName=" + storedFileName
				+ ", fileSize=" + fileSize + ", creDate=" + creDate + "]";
	}

}
