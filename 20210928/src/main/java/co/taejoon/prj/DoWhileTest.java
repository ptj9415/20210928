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
		friendArr[0] = new SchoolFriend("��â��", "010-6372-8114", "��õ������ ������", "���ϴ��б�");
		friendArr[1] = new CompanyFriend("ȫ�浿", "010-1234-6578", "�뱸������ �ϱ�", "�Ｚ");
		friendArr[2] = new SchoolFriend("���ϳ�", "010-0029-1837", "�λ걤���� �ؿ�뱸", "�λ���б�");
		friendArr[3] = new CompanyFriend("��ö��", "010-5938-2091", "����Ư���� ������", "īī��");
	}

	private void mainMenu() {
		System.out.println("----------------------");
		System.out.println("-----1. ģ�� ���-----");
		System.out.println("-----2. ģ�� ����-----");
		System.out.println("-----3. ģ�� ��ȸ-----");
		System.out.println("-----4. �޴� ����-----");
		System.out.println("----------------------");
		System.out.println("���ϴ� ��ȣ�� �����ϼ���.");
	}

	private void firstMenu() {
		System.out.println("--------ģ�� ��� �޴��Դϴ�.--------");
		System.out.println("1. ȸ�� ����\t 2. �б� ģ��");
		int choice = readInt("����� ģ���� �����ϼ���.");
		String name = readStr("ģ�� �̸��� �Է��ϼ���.");
		String tel = readStr("ģ�� ��ȭ��ȣ�� �Է��ϼ���.");
		String address = readStr("ģ�� �ּҸ� �Է��ϼ���.");
		Friend friend = null;
		if (choice == 1) {
			String company = readStr("ȸ�縦 �Է��ϼ���.");
			friend = new CompanyFriend(name, tel, address, company);

		} else if (choice == 2) {
			String school = readStr("�б��� �Է��ϼ���.");
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
		System.out.println("--------ģ�� ���� �޴��Դϴ�.--------");
		for (int i = 0; i < friendArr.length; i++) {
			if (friendArr[i] != null) {
				System.out.print("[" + i + "]");
				friendArr[i].friendPrint();
			}
		}
		int choice = readInt("ģ���� ��ȣ�� �����ϼ���.");
		String tel = readStr("�ٲ� ��ȭ��ȣ�� �Է��ϼ���.");
		if (tel.equals("")) {
			System.out.println("��ȭ��ȣ�� �ٲ��� �ʽ��ϴ�.");
		} else {
			friendArr[choice].setTel(tel);
		}
		String address = readStr("�ٲ� �ּҸ� �Է��ϼ���.");
		if (address.equals("")) {
			System.out.println("�ּҸ� �ٲ��� �ʽ��ϴ�.");
		} else {
			friendArr[choice].setAddress(address);
		}
		if (friendArr[choice] instanceof CompanyFriend) {
			String company = readStr("�ٲ� ȸ�縦 �Է��ϼ���.");
			if (company.equals("")) {
				System.out.println("ȸ�縦 �ٲ��� �ʽ��ϴ�.");
			} else {
				((CompanyFriend) friendArr[choice]).setCompany(company);
			}
		} else if (friendArr[choice] instanceof SchoolFriend) {
			String school = readStr("�ٲ� �б��� �Է��ϼ���.");
			if (school.equals("")) {
				System.out.println("�б��� �ٲ��� �ʽ��ϴ�.");
			} else {
				((SchoolFriend) friendArr[choice]).setSchool(school);
			}
		}
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}

	private void thirdMenu() {
		System.out.println("--------ģ�� ��ȸ �޴��Դϴ�.--------");
		String name;
		String tel;
		while (true) {
			name = readStr("�̸��� �Է��ϼ���.");
			tel = readStr("����ó�� �Է��ϼ���.");
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
		System.out.println("-------���α׷��� �����մϴ�.-------");

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
