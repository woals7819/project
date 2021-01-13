package exm1;

public class duck {	
	void duckfly() {
		System.out.println("오리가 날개로 날아갑니다.");
	}
	
	void duckswim() {
		System.out.println("오리가 오리발로 헤엄칩니다.");
	}

}

class cjdendduck extends duck{

}

class gmlsduck extends duck{

}

class rhanduck extends duck{
	void fly() {
		System.out.println("저는 날 수 없어요. ㅜㅠ");
	}
	void swim() {
		System.out.println("오리가 둥둥 떠다닙니다.");
	}
}

class rhanduck2 extends rhanduck{
	
}

class asuraduck extends rhanduck {
	void fly() {
		duckfly();
	}
	void duckswim() {
		swim();
	}
}
