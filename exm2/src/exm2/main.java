package exm2;

public class main {

	public static void main(String[] args) {
		MemberManager mm = new MemberManager();
		
//		// �׽�Ʈ�� �������� 5�� �����
//		mm.makeData();
//	
//		// ��� �� ��ȸ
//		mm.printMembers();
//		
//		// Ư�� �� ��ȸ
//		// ������ ���̵� �޾� �ش� ������ ��� ������ ���.
//		mm.printMemberByUserId("firstUser");
//		/*
//		 
//		 ���̵� : firstUser
//		 �̸�   : ȫ�浿
//		 ����   : 27
//		  
//		 * */	
//		mm.printMemberByUserId("aaaa");
//		// ���� ���̵��Դϴ�.
		
		// ȸ���� ���̵�, �̸�, ���� ������ �̿��� ���� ��й�ȣ ã��
		mm.findMemberPassword("secondUser", "�Ӳ���", 45);
		// ��й�ȣ�� 5678�Դϴ�.
		
//		mm.findMemberPassword("secondUser", "ȫ�浿", 45);
//		// ȸ���� ������ ��ġ���� �ʽ��ϴ�.
//		
//		
//		// �α��� ��� - ���̵�� ��й�ȣ�� �޾� �α��� üũ
//		mm.loginCheck("thirdUser", "2468");
//		// Ȳ���̴� �α���. ȯ���մϴ�.
//		
//		mm.loginCheck("thirdUser", "2234");
//		// ��й�ȣ�� Ʋ�Ƚ��ϴ�.
//		
//		mm.loginCheck("noneUser", "2468");
//		// ���� ���̵��Դϴ�.

	}

}
