package exm1;

public class duck {	
	void duckfly() {
		System.out.println("������ ������ ���ư��ϴ�.");
	}
	
	void duckswim() {
		System.out.println("������ �����߷� ���Ĩ�ϴ�.");
	}

}

class cjdendduck extends duck{

}

class gmlsduck extends duck{

}

class rhanduck extends duck{
	void fly() {
		System.out.println("���� �� �� �����. �̤�");
	}
	void swim() {
		System.out.println("������ �յ� ���ٴմϴ�.");
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
