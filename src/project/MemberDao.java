package project;

import java.util.ArrayList;
//회원데이터 처리 전문가
public class MemberDao {
	ArrayList<signup> sgu = new ArrayList<>();
	
	public signup getMemberByLoginIdAndPw(String Id, String Pw) {
		for (int i = 0; i < sgu.size(); i++) {
			signup member = sgu.get(i);
			String userid = member.getId();
			String userPw = member.getPassword();
			if (userid.equals(Id) && userPw.equals(Pw)) {
				return member;
			}
		}
		return null; // 객체타입을 리턴할 때, 리턴할 값이 없으면 null리턴
	}
	
	public void InsertMember(signup member) {
		sgu.add(member);
	}
}
