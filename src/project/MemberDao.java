package project;

import java.util.ArrayList;
//회원데이터 처리 전문가
public class MemberDao {
	ArrayList<signup> sgu = new ArrayList<>();
	int membernumber = 4;
	
	public signup getMemberByLoginIdAndPw(String Id, String Pw) {
		for (int i = 0; i < sgu.size(); i++) {
			if (Id.equals(sgu.get(i).getId()) && Pw.equals(sgu.get(i).getPassword())) {
				return sgu.get(i); // Member
			} 
		}
		return null; // 객체타입을 리턴할 때, 리턴할 값이 없으면 null리턴
	}
	
	public void InsertMember(signup member) {
		sgu.add(member);
	}
	
	MemberDao(){
		signup member1 = new signup("hong123", "1234", "홍길동");
		signup member2 = new signup("lee123", "4567", "이춘향");
		signup member3 = new signup("kim123", "5678", "김춘식");
		
		sgu.add(member1);
		sgu.add(member2);
		sgu.add(member3);
	}
	
	public void insertMember(signup member) {
		member.setNumber(membernumber);
		membernumber++;
		sgu.add(member);
	}
}
