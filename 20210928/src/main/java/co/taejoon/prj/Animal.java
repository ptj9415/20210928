package co.taejoon.prj;

public abstract class Animal { // 추상 class는 instance 생성 불가
	public abstract void run();

	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
}
