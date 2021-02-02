package project;

import java.util.ArrayList;

/*Dao = DATA ACCESS OBJECT
 * MVC = Model(data) View(데이터의 표현) Controller(model 과 view의 호환*/ 
public class ArticleDao {
	ArrayList<postMember> post = new ArrayList<>(); // 내용리스트
	ArrayList<coment> coments = new ArrayList<>();
	
	
	
	
	ArticleDao(){
		postMember member1 = new postMember(1, "제목1", "내용1", UtilDao.getCurrentDate(), 0, "홍길동", 0);
		postMember member2 = new postMember(2, "제목2", "내용2", UtilDao.getCurrentDate(), 0, "홍길순", 0);
		postMember member3 = new postMember(3, "제목3", "내용3", UtilDao.getCurrentDate(), 0, "박춘식", 0);

		post.add(member1);
		post.add(member2);
		post.add(member3);
	}
	
	public int searchNuber(int id) {
		int targetNumber = -1;

		for (int i = 0; i < post.size(); i++) {

			if (id == post.get(i).getPostnumber()) {
				targetNumber = i;

			}
		}
		return targetNumber;
	}
	
	public postMember GetIndex(int target) {
		int readNumber = searchNuber(target);
		postMember member = post.get(readNumber);
		if(readNumber != -1) {
			return member;			
		}
		else {
			return null;
		}
	}
	
	public void AddComent(coment member) {
		coments.add(member);
	}
	
	public void AddMember(postMember member) {
		post.add(member);
	}
	
	public void PrintComents(postMember members) {
		for (int i = 0; i < coments.size(); i++) {
			coment co = coments.get(i);
			if (co.getParentId() == members.getPostnumber()) {
				System.out.println("내용 : " + co.getComent());
				System.out.println("작성자 : " + co.getNickname());
				System.out.println("작성일 : " + co.getDate());
			}

		}
	}
	
	
	public void deletProcess(postMember member) {
		post.remove(member);

		System.out.println("삭제가 완료되었습니다.");

		for (int j = 0; j < post.size(); j++) {
			postMember memberlist = post.get(j);
			System.out.println("번호 : " + memberlist.getPostnumber());
			System.out.println("제목 : " + memberlist.getPosttitle());
			System.out.println("================================");
		}
	}
	
	public void SerachPost(int item, String keywoard) {
		ArrayList<postMember> searchTitle = new ArrayList<>();

		if (item == 1) {
			for (int i = 0; i < post.size(); i++) {
				postMember member = post.get(i);
				String title = member.getPosttitle();
				if (title.contains(keywoard)) {
					searchTitle.add(member);
				}
			}
			printPosttitle(searchTitle);

		} else if (item == 2) {
			for (int i = 0; i < post.size(); i++) {
				postMember member = post.get(i);
				String contents = member.getPostcontents();
				if (contents.contains(keywoard)) {
					searchTitle.add(member);
				}
			}
			printPosttitle(searchTitle);
		} else if (item == 3) {
			for (int i = 0; i < post.size(); i++) {
				postMember member = post.get(i);
				String title = member.getPosttitle();
				String contents = member.getPostcontents();
				if (contents.contains(keywoard) || title.contains(keywoard)) {
					searchTitle.add(member);
				}
			}
			printPosttitle(searchTitle);
		} else if (item == 4) {
			for (int i = 0; i < post.size(); i++) {
				postMember member = post.get(i);
				String name = member.getNickname();
				if (name.contains(keywoard)) {
					searchTitle.add(member);
				}
			}
			printPosttitle(searchTitle);
		}
	}
	
	
	public void printPosttitle(ArrayList<postMember> post) {
		for (int i = 0; i < post.size(); i++) {
			postMember member = post.get(i);
			String str = member.getPostdate();
			str = str.substring(0, 10);

			System.out.println("번호 : " + member.getPostnumber());
			System.out.println("제목 : " + member.getPosttitle());
			System.out.println("작성자 : " + member.getNickname());
			System.out.println("조회수 : " + member.getPostviews());
			System.out.println("날짜 : " + member.getPostdate());
			System.out.println("================================");
		}
	}
	
	public ArrayList<postMember> ReturnPostArray() {
		return post;
	}
	
	
	public void UpdateProccessSet(int id, postMember member) {
		post.set(searchNuber(id), member);

		for (int j = 0; j < post.size(); j++) {
			postMember memberlist = post.get(j);
			System.out.println("번호 : " + memberlist.getPostnumber());
			System.out.println("제목 : " + memberlist.getPosttitle());
			System.out.println("날짜 : " + memberlist.getPostdate());
			System.out.println("================================");
		}
	}
	
	
	
	
	
	
}
