package exm;

public class exm1 {

	public static void main(String[] args) {
		
		VendingMachine vm = new VendingMachine();
		
		vm.printAllBeverages();
    // ��� : 0.�ݶ� : 1000
    // ��� : 1.���̴� : 1200
    // ��� : 2.Ŀ�� : 800

		vm.setInputedMoney(2000);
    // ��� : ���� ���Ե� �ݾ��� 2000���Դϴ�.

		String rst = vm.getBeverage(1);
    // ��� : ���̴ٸ� �����̽��ϴ�.
    // ��� : �ܾ��� 800���Դϴ�.

		System.out.println(rst);
    // ��� : ���̴�

    String rst2 = vm.getBeverage(0);
    // ��� : �ܾ��� �����մϴ�.

		vm.setInputedMoney(500);
    // ��� : ���� ���Ե� �ݾ��� 1300���Դϴ�.
		
    String rst3 = vm.getBeverage(0);
    // ��� : �ݶ� �����̽��ϴ�.
    // ��� : �ܾ��� 300���Դϴ�.
		System.out.println(rst3);
    // ��� : �ݶ�
		

	}

}
