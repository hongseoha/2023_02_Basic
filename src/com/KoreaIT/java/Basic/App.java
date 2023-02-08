package com.KoreaIT.java.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.Basic.controller.ArticleController;
import com.KoreaIT.java.Basic.controller.Controller;
import com.KoreaIT.java.Basic.controller.MemberController;
import com.KoreaIT.java.Basic.dto.Article;
import com.KoreaIT.java.Basic.dto.Member;
import com.KoreaIT.java.Basic.util.Util;

public class App {
	public static List<Article> articles;
	public static List<Member> members;
	
	static {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}

	public void run() {
		System.out.println("==프로그램 시작==");

		makeTestData();

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(members, sc);
		ArticleController articleController = new ArticleController(articles, sc);
		

		while (true) {

			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}

			String[] commandBits = command.split(" ");
			
			if(commandBits.length == 1){
				System.out.println("명령어 오류입니다.");
				continue;
			}
			
			String controllerName = commandBits[0];
			String actionMethodName = commandBits[1];
			
			Controller controller = null;
			
			if(controllerName.equals("article")) {
				controller = articleController;
			}else if(controllerName.equals("member")) {
				controller = memberController;
			}else {
				System.out.println("존재하지 않는 명령어 입니다.");
				continue;
			}
			
			controller.doAction(command);
			
			
//			if (command.equals("member join")) {
//				memberController.doJoin();
//			} else if (command.equals("article list")) {
//				articleController.showArticleList();
//			} else if (command.equals("member list")) {
//				memberController.showMemberList();
//			} else if (command.equals("article write")) {
//				articleController.doArticleWrite();
//			} else if (command.startsWith("article detail ")) {
//				articleController.showArticleDetail(command);
//			} else if (command.startsWith("article modify ")) {
//				articleController.doArticleModify(command);
//			} else if (command.startsWith("article delete ")) {
//				articleController.doArticleDelete(command);
//			}
//			else {
//				System.out.println("존재하지 않는 명령어입니다");
//			}
//
		}

		System.out.println("==프로그램 끝==");

		sc.close();

	}

	public static void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다");

		articles.add(new Article(1, Util.getNowDateStr(), Util.getNowDateStr(), "제목1", "내용1", 11));
		articles.add(new Article(2, Util.getNowDateStr(), Util.getNowDateStr(), "제목2", "내용2", 22));
		articles.add(new Article(3, Util.getNowDateStr(), Util.getNowDateStr(), "제목3", "내용3", 33));
	}
}