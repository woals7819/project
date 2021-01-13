package exm2;

import exm2.Member;

public class MemberManager {
	Member[] mb = new Member[100];
	int count = 0;
	
	
	void makeData() {
		Member m1 = new Member();
		m1.setId("hgd");
		m1.setName("홍길동");
		m1.setPw("ghdrlfehd");
		m1.setAge(24);
		
		Member m2 = new Member();
		m2.setId("hgs");
		m2.setName("홍길순");
		m2.setPw("ghdrlftns");
		m2.setAge(22);
		
		Member m3 = new Member();
		m3.setId("pcx");
		m3.setName("박춘식");
		m3.setPw("qkrcnstlr");
		m3.setAge(28);
		
		Member m4 = new Member();
		m4.setId("pcs");
		m4.setName("박춘순");
		m4.setPw("qkrcnstns");
		m4.setAge(27);
		
		Member m5 = new Member();
		m5.setId("kcs");
		m5.setName("김춘삼");
		m5.setPw("rlacnstka");
		m5.setAge(21);
		
	}
	
	void printMembers() {
		for(int i = 0; i < count; i++) {
			System.out.println(mb[i].id);
			System.out.println(mb[i].name);
			System.out.println(mb[i].pw);
			System.out.println(mb[i].age);
			
		}
		
	}
	
	String printMemberByUserId(String SearchId){
		for(int i = 0; i < count; i++) {
			if(SearchId == mb[i].id) {
				System.out.println(mb[i].id);
				System.out.println(mb[i].name);
				System.out.println(mb[i].age);
			}
			else if(SearchId == mb[i].id) {
				System.out.println("없는 아이디입니다.");
			}
		}
		return SearchId;
		
	}
	
	void insertMember(Member m) {
		int duplicateFlag = 0;

		for (int i = 0; i < count; i++) {
			if (mb[i].id.equals(m.id)) {
				duplicateFlag = 1;
				break;
			}
		}

		if (duplicateFlag == 0) {
			mb[count] = m;
			count++;
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("이미 등록된 아이디입니다.");
		}
		
	}
	
	Member GetId(String a) {
		for(int i = 0; i < count; i++) {
			Member m = mb[i];
			if(m.getId().equals(a) ) {
				return m;
			}
		}
		return null;
	}

	
	void findMemberPassword(String id, String name, int age) {
		Member z = GetId(id);
		for(int i = 0; i < count; i++) {
			if(name.equals(z.getName()) && age == z.getAge()) {
				System.out.println("해당 아이디의 비밀번호는" + mb[i].pw);
			}
			else {
				System.out.println("회원의 정보가 일치하지 않습니다.");
			}
		}
		
	}
	
//	String loginCheck(String a, String b) {
//		
//	}

}
