package com.KoreaIT.java.Basic.dto;

public class Member extends Dto{
	
	public String loginid;
	public String loginPw;
	public String name;

	public Member(int id, String regDate, String updateDate, String loginid, String loginPw, String name) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.loginid = loginid;
		this.loginPw = loginPw;
		this.name = name;
	}
	

}
