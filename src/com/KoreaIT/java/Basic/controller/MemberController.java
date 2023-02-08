package com.KoreaIT.java.Basic.controller;

import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.Basic.dto.Member;
import com.KoreaIT.java.Basic.util.Util;

public class MemberController extends Controller {

	private List<Member> members;
	private Scanner sc;
	private String command;
	private String actionMethodName;

	public MemberController(List<Member> members, Scanner sc) {
		this.members = members;
		this.sc = sc;
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;
		
		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		}
		
	}

	int lastMemberId;

	public void doJoin() {
		int id = lastMemberId + 1;
		String regDate = Util.getNowDateStr();
		String loginId = null;
		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();
			if (loginIdCheck(loginId)) {
				System.out.println("중복된 ID입니다.");
				continue;
			}
			break;
		}

		String loginPw = null;
		String loginPwConfirm = null;
		while (true) {
			System.out.printf("로그인 비밀번호 : ");
			loginPw = sc.nextLine();
			System.out.printf("로그인 비밀번호 확인: ");
			loginPwConfirm = sc.nextLine();

			if (loginPw.equals(loginPwConfirm) == false) {
				System.out.println("비밀번호를 다시 입력해주세요");
				continue;
			}

			break;
		}
		System.out.printf("이름 : ");
		String name = sc.nextLine();

		Member member = new Member(id, regDate, regDate, loginId, loginPw, name);
		members.add(member);

		System.out.printf("%d번 회원이 가입 되었습니다\n", id);
		lastMemberId++;

	}

	public void showMemberList() {
		if (members.size() == 0) {
			System.out.println("회원이 없습니다");
		}
		System.out.println("아이디    /     이름    /   가입일자   ");
		for (int i = members.size() - 1; i >= 0; i--) {
			Member member = members.get(i);
			System.out.printf("%4s	/    %6s    /   %4s\n", member.loginId, member.name, member.regDate);
		}

	}

	public boolean loginIdCheck(String loginId) {
		boolean check = true;
		Member member = FindById(loginId);
		if (member == null)
			check = false;
		return check;
	}

	public Member FindById(String loginId) {
		for (Member member : members) {
			if (member.getloginId().equals(loginId)) {
				return member;
			}
		}
		return null;
	}
}
