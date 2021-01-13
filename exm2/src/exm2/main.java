package exm2;

public class main {

	public static void main(String[] args) {
		MemberManager mm = new MemberManager();
		
//		// 테스트용 고객데이터 5명 만들기
//		mm.makeData();
//	
//		// 모든 고객 조회
//		mm.printMembers();
//		
//		// 특정 고객 조회
//		// 유저의 아이디를 받아 해당 유저의 모든 정보를 출력.
//		mm.printMemberByUserId("firstUser");
//		/*
//		 
//		 아이디 : firstUser
//		 이름   : 홍길동
//		 나이   : 27
//		  
//		 * */	
//		mm.printMemberByUserId("aaaa");
//		// 없는 아이디입니다.
		
		// 회원의 아이디, 이름, 나이 정보를 이용해 고객의 비밀번호 찾기
		mm.findMemberPassword("secondUser", "임꺽정", 45);
		// 비밀번호는 5678입니다.
		
//		mm.findMemberPassword("secondUser", "홍길동", 45);
//		// 회원의 정보가 일치하지 않습니다.
//		
//		
//		// 로그인 기능 - 아이디와 비밀번호를 받아 로그인 체크
//		mm.loginCheck("thirdUser", "2468");
//		// 황진이님 로그인. 환영합니다.
//		
//		mm.loginCheck("thirdUser", "2234");
//		// 비밀번호를 틀렸습니다.
//		
//		mm.loginCheck("noneUser", "2468");
//		// 없는 아이디입니다.

	}

}
