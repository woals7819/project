package project;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class homePage {

	static ArrayList<postMember> post = new ArrayList<>(); // 내용리스트

	public static void main(String[] args) {

		SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:ss");
		Date time = new Date();

		Scanner ms = new Scanner(System.in);
		int esq = 4; // 게시물 번호
		int viewNuber = 0;
		String nickname = "익명";

		String time1 = date.format(time);
		postMember member1 = new postMember(1, "제목1", "내용1", time1, viewNuber, nickname);
		postMember member2 = new postMember(2, "제목2", "내용2", time1, viewNuber, nickname);
		postMember member3 = new postMember(3, "제목3", "내용3", time1, viewNuber, nickname);

		post.add(member1);
		post.add(member2);
		post.add(member3);

		while (true) {
			System.out.println("명령어를 입력해주세요.:");
			String command = ms.next();

			/* ===========================게시물 추가기능========================== */
			if (command.equals("add")) {
				System.out.println("제목을 입력해주세요.");
				String title = ms.next();
				System.out.println("내용을 입력해주세요.");
				String contents = ms.next();
				int postviews = viewNuber;

				postMember member = new postMember(esq, title, contents, time1, postviews, nickname);

				esq++;
				post.add(member);
			}

			/* ===========================게시물 출력기능========================== */
			else if (command.equals("list")) {

				printPosttitle(post);
			}

			/* ===========================게시물 수정기능========================== */
			else if (command.equals("update")) {

				System.out.println("수정할 게시물의 번호를 입력하세요. :");
				int id = ms.nextInt();
				int updateNumber = searchNuber(id);

				if (updateNumber != -1) {
					System.out.println("새 제목 :");
					String title = ms.next();

					System.out.println("새 내용 :");
					String contents = ms.next();
					String postdate = date.format(time);
					int postview = viewNuber;

					postMember member = new postMember(id, title, contents, postdate, postview, nickname);
					post.set(updateNumber, member);

					System.out.println("수정이 완료되었습니다.");

					for (int j = 0; j < post.size(); j++) {
						postMember memberlist = post.get(j);
						System.out.println("번호 : " + memberlist.getPostnumber());
						System.out.println("제목 : " + memberlist.getPosttitle());
						System.out.println("날짜 : " + memberlist.getPostdate());
						System.out.println("================================");
					}
				} else {
					System.out.println("없는 게시물 번호 입니다.");
				}
			}

			/* ===========================게시물 삭제기능========================== */
			else if (command.equals("delet")) {
				System.out.println("삭제할 게시물의 번호를 입력해주세요. :");
				int delet = ms.nextInt();
				int deletNumber = searchNuber(delet);

				if (deletNumber != -1) {
					post.remove(deletNumber);

					System.out.println("삭제가 완료되었습니다.");

					for (int j = 0; j < post.size(); j++) {
						postMember memberlist = post.get(j);
						System.out.println("번호 : " + memberlist.getPostnumber());
						System.out.println("제목 : " + memberlist.getPosttitle());
						System.out.println("================================");
					}
				} else {
					System.out.println("없는 게시물 번호 입니다.");
				}
			}

			/* ===========================게시물 상세보기 기능========================== */
			else if (command.equals("read")) {
				System.out.println("원하는 게시물의 번호:");
				int postNumber = ms.nextInt();
				int readNumber = searchNuber(postNumber);

				if (readNumber != -1) {
					postMember member = post.get(readNumber);

					member.setPostviews(member.getPostviews() + 1);

					System.out.println("==========" + member.getPostnumber() + "번의 게시물 =========");
					System.out.println("번호 : " + member.getPostnumber());
					System.out.println("제목 : " + member.getPosttitle());
					System.out.println("내용 : " + member.getPostcontents());
					System.out.println("작성자 : " + member.getNickname());
					System.out.println("조회수 : " + member.getPostviews());
					System.out.println("날짜 : " + member.getPostdate());
					System.out.println("================================");

				} else {
					System.out.println("없는 게시물 입니다.");
				}
			}

			else if (command.equals("search")) {
				System.out.println("검색 키워드를 입력해주세요. : ");
				String keyword = ms.next();

				ArrayList<postMember> searchTitle = new ArrayList<>();

				for (int i = 0; i < post.size(); i++) {
					postMember member = post.get(i);
					String title = member.getPosttitle();
					if (title.contains(keyword)) {
						searchTitle.add(member);
					}
				}
				
				
				
			}

			/* ===========================기능 종료========================== */
			else if (command.equals("exit")) {
				break;
			}

		}

	}

	public static int searchNuber(int a) {
		int targetNumber = -1;

		for (int i = 0; i < post.size(); i++) {

			if (a == post.get(i).getPostnumber()) {
				targetNumber = i;

			}
		}
		return a;
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

}
