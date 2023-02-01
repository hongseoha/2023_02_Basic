package com.KoreaIT.java.Basic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==start program==");
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.printf("명령어)");
			String command = sc.nextLine();
			
			if (command.equals("system exit")) {
				break;
			}
		}
				
		System.out.println("==end program==");
		
		sc.close();
	}
}
