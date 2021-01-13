package exm;

public class VendingMachine {
	
	int money = 0;
	int change = 0;
	
	Bevers d1 = new Bevers("콜라", 1000);
	Bevers d2 = new Bevers("사이다", 1200);
	Bevers d3 = new Bevers("커피", 800);
	
	
	
	void printAllBeverages(){
		System.out.println("0." + d1.drink + ":" + d1.sell);
		System.out.println("1." + d2.drink + ":" + d2.sell);
		System.out.println("2." + d3.drink + ":" + d3.sell);
	}
	
	
	int setInputedMoney(int a) {
		money += a;
		System.out.println("현재 투입된 금액은" + a +"원입니다.");
		return a;
	}
	
	
	
	String getBeverage(int a) {
		
		Bevers target;
		
		if(a == 0) {
			target = d1;
		}
		else if(a == 1){
			target = d2;
		}
		else if(a == 2){
			target = d3;
		}
		
		if(money < target.sell) {
			System.out.println("잔액이 부족합니다.");
			return "";
		}
		
		money -= target.sell;
		System.out.println("잔액은" + money + "원입니다.");
		
		
		return target.drink;
	}

}
