package co.taejoon.prj;

import java.util.Scanner;

public class DoWhileTest {
	private Scanner sc = new Scanner(System.in);

	private void mainMenu() {
		System.out.println("---------------------");
		System.out.println("-----1. 입력하기-----");
		System.out.println("-----2. 수정하기-----");
		System.out.println("-----3. 조회하기-----");
		System.out.println("-----4. 종료하기-----");
		System.out.println("---------------------");
		System.out.println("원하는 번호를 선택하세요.");
	}

	private void firstMenu() {
		System.out.println("-------------------------------------------");
		System.out.println("--------여기는 입력하는 화면입니다.--------");
		System.out.println("--메인메뉴로 돌아가려면 아무 키나 누르세요.");
		System.out.println("-------------------------------------------");
		sc.nextLine();
	}

	private void secondMenu() {
		System.out.println("-------------------------------------------");
		System.out.println("--------여기는 수정하는 화면입니다.--------");
		System.out.println("--메인메뉴로 돌아가려면 아무 키나 누르세요.");
		System.out.println("-------------------------------------------");
		sc.nextLine();
	}

	private void thirdMenu() {
		System.out.println("-------------------------------------------");
		System.out.println("--------여기는 조회하는 화면입니다.--------");
		System.out.println("--메인메뉴로 돌아가려면 아무 키나 누르세요.");
		System.out.println("-------------------------------------------");
		sc.nextLine();
	}

	private void endMenu() {
		System.out.println("-------프로그램을 종료합니다.-------");

	}

	private void doWhileMenu() {
		boolean b = false;
		do {
			mainMenu();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				firstMenu();
				break;
			case 2:
				secondMenu();
				break;
			case 3:
				thirdMenu();
				break;
			case 4:
				endMenu();
				b = true;
				break;
			}
		} while (!b);
	}
	
	public void run() {
		doWhileMenu();
		sc.close();
	}
}
