package co.taejoon.prj;

import co.taejoon.friend.CompanyFriend;
import co.taejoon.friend.Friend;
import co.taejoon.friend.SchoolFriend;

public class MainApp {
	public static void main(String[] args) {
//		DoWhileTest doWhileTset = new DoWhileTest();
//		doWhileTset.run();

//		Animal man = new Man();
//		man.run();
//		man.sleep();
//		
//		Animal bird = new Bird();
//		bird.run();
//		bird.sleep();
//		
//		Man man2 = new Man();
//		man2.run();
//		man2.sleep();
		
		Friend schoolFriend = new SchoolFriend();
		schoolFriend.name = "È«±æµ¿";
		schoolFriend.tel = "010-1234-5678";
		schoolFriend.address = "´ë±¸±¤¿ª½Ã ºÏ±¸";
		schoolFriend.friendPrint();
		System.out.println("");
		
		Friend companyFriend = new CompanyFriend();
		companyFriend.name = "±èÃ¶¼ö";
		companyFriend.tel = "010-9573-9222";
		companyFriend.address = "¼­¿ïÆ¯º°½Ã ¼ºµ¿±¸";
		companyFriend.friendPrint();
	}
}
