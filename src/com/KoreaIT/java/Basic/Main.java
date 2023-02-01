package com.KoreaIT.java.Basic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==start program==");
		
		Scanner sc = new Scanner(System.in);
		
		int 글번호=0;
		while(true){
			System.out.printf("명령어)");
			String command = sc.nextLine();
			if (command.equals("article write")) {
				System.out.printf("제목:");
				String command1 = sc.nextLine();
				System.out.printf("내용:");
				String command2 = sc.nextLine();
				
				System.out.printf("%d번 글이 생성되었습니다\n",글번호+1);
				글번호++;
				continue;
			}
			
			if (command.equals("article list")) {
				if (글번호==0) {
				System.out.println("게시글이 없습니다");
				continue;
				}
				else if (글번호>0) {
					System.out.println(글번호);
					continue;
				}
			}
			if (command.equals("system exit")) {
				break;
			}
			else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}
				
		System.out.println("==end program==");
		
		sc.close();
	}
}
