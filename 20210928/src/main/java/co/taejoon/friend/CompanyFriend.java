package co.taejoon.friend;

public class CompanyFriend extends Friend {

	String company;

	public CompanyFriend(String name, String tel, String address, String company) {
		super(name, tel, address);
		this.company = company;

	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void friendPrint() {
		System.out.println("[구분: 직장 동료] 이름: " + name + ", 전화번호: " + tel + ", 주소: " + address + ", 직장: " + company);
	}
}