package exm;

public class exm1 {

	public static void main(String[] args) {
		
		VendingMachine vm = new VendingMachine();
		
		vm.printAllBeverages();
    // 출력 : 0.콜라 : 1000
    // 출력 : 1.사이다 : 1200
    // 출력 : 2.커피 : 800

		vm.setInputedMoney(2000);
    // 출력 : 현재 투입된 금액은 2000원입니다.

		String rst = vm.getBeverage(1);
    // 출력 : 사이다를 뽑으셨습니다.
    // 출력 : 잔액은 800원입니다.

		System.out.println(rst);
    // 출력 : 사이다

    String rst2 = vm.getBeverage(0);
    // 출력 : 잔액이 부족합니다.

		vm.setInputedMoney(500);
    // 출력 : 현재 투입된 금액은 1300원입니다.
		
    String rst3 = vm.getBeverage(0);
    // 출력 : 콜라를 뽑으셨습니다.
    // 출력 : 잔액은 300원입니다.
		System.out.println(rst3);
    // 출력 : 콜라
		

	}

}
