package co.taejoon.prj;

import java.util.Scanner;

import co.taejoon.friend.CompanyFriend;
import co.taejoon.friend.Friend;
import co.taejoon.friend.SchoolFriend;

public class DoWhileTest {
	private Scanner sc = new Scanner(System.in);
	private Friend[] friendArr;

	public DoWhileTest() {
		friendArr = new Friend[100];
		friendArr[0] = new SchoolFriend("최창민", "010-6372-8114", "인천광역시 연수구", "인하대학교");
		friendArr[1] = new CompanyFriend("홍길동", "010-1234-6578", "대구광역시 북구", "삼성");
		friendArr[2] = new SchoolFriend("김하나", "010-0029-1837", "부산광역시 해운대구", "부산대학교");
		friendArr[3] = new CompanyFriend("김철수", "010-5938-2091", "서울특별시 성동구", "카카오");
	}

	private void mainMenu() {
		System.out.println("----------------------");
		System.out.println("-----1. 친구 등록-----");
		System.out.println("-----2. 친구 수정-----");
		System.out.println("-----3. 친구 조회-----");
		System.out.println("-----4. 메뉴 종료-----");
		System.out.println("----------------------");
		System.out.println("원하는 번호를 선택하세요.");
	}

	private void firstMenu() {
		System.out.println("--------친구 등록 메뉴입니다.--------");
		System.out.println("1. 회사 동료\t 2. 학교 친구");
		int choice = readInt("등록할 친구를 선택하세요.");
		String name = readStr("친구 이름을 입력하세요.");
		String tel = readStr("친구 전화번호를 입력하세요.");
		String address = readStr("친구 주소를 입력하세요.");
		Friend friend = null;
		if (choice == 1) {
			String company = readStr("회사를 입력하세요.");
			friend = new CompanyFriend(name, tel, address, company);

		} else if (choice == 2) {
			String school = readStr("학교를 입력하세요.");
			friend = new SchoolFriend(name, tel, address, school);
		}
		for (int i = 0; i < friendArr.length; i++) {
			if (friendArr[i] == null) {
				friendArr[i] = friend;
				break;
			}
		}
	}

	private void secondMenu() {
		System.out.println("--------친구 수정 메뉴입니다.--------");
		for (int i = 0; i < friendArr.length; i++) {
			if (friendArr[i] != null) {
				System.out.print("[" + i + "]");
				friendArr[i].friendPrint();
			}
		}
		int choice = readInt("친구의 번호를 선택하세요.");
		String tel = readStr("바꿀 전화번호를 입력하세요.");
		if (tel.equals("")) {
			System.out.println("전화번호를 바꾸지 않습니다.");
		} else {
			friendArr[choice].setTel(tel);
		}
		String address = readStr("바꿀 주소를 입력하세요.");
		if (address.equals("")) {
			System.out.println("주소를 바꾸지 않습니다.");
		} else {
			friendArr[choice].setAddress(address);
		}
		if (friendArr[choice] instanceof CompanyFriend) {
			String company = readStr("바꿀 회사를 입력하세요.");
			if (company.equals("")) {
				System.out.println("회사를 바꾸지 않습니다.");
			} else {
				((CompanyFriend) friendArr[choice]).setCompany(company);
			}
		} else if (friendArr[choice] instanceof SchoolFriend) {
			String school = readStr("바꿀 학교를 입력하세요.");
			if (school.equals("")) {
				System.out.println("학교를 바꾸지 않습니다.");
			} else {
				((SchoolFriend) friendArr[choice]).setSchool(school);
			}
		}
		System.out.println("수정이 완료되었습니다.");
	}

	private void thirdMenu() {
		System.out.println("--------친구 조회 메뉴입니다.--------");
		String name;
		String tel;
		while (true) {
			name = readStr("이름을 입력하세요.");
			tel = readStr("연락처를 입력하세요.");
			boolean nameFlag = true;
			boolean telFlag = true;
			if (name.equals("")) {
				nameFlag = false;
			}
			if (tel.equals("")) {
				telFlag = false;
			}
			if ((nameFlag || telFlag) == true) {
				break;
			}
		}
		for (Friend friend : friendArr) {
			if (friend == null) {
				continue;
			}
			if (name.equals("") == false && tel.equals("") == false) {
				if (friend.getName().indexOf(name) != -1 && friend.getTel().indexOf(tel) != -1) {
					friend.friendPrint();
				}
			}
			if (name.equals("") == false && tel.equals("") == true) {
				if (friend.getName().indexOf(name) != -1) {
					friend.friendPrint();
				}
			}
			if (name.equals("") == true && tel.equals("") == false) {
				if (friend.getTel().indexOf(tel) != -1) {
					friend.friendPrint();
				}
			}
		}
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

	public String readStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}

	public int readInt(String msg) {
		System.out.println(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
}
