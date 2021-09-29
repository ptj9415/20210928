package co.taejoon.friend;

public class SchoolFriend extends Friend {

	String school;

	public SchoolFriend(String name, String tel, String address, String school) {
		super(name, tel, address);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public void friendPrint() {
		System.out.println("[구분: 학교 친구] 이름: " + name + ", 전화번호: " + tel + ", 주소: " + address + ", 학교: " + school);
	}
}
