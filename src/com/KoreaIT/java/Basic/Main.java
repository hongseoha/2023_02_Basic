package com.KoreaIT.java.Basic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==start program==");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("명령어)");
		String cmd = sc.nextLine();
		
		System.out.printf("입력된 명령어: %s\n",cmd);
		
		System.out.println("==end program==");
		
		sc.close();
	}
}
