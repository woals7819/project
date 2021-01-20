package project;

import java.util.ArrayList;
import java.util.Scanner;

public class homePage {

	public static void main(String[] args) {
		ArrayList<postMember> post = new ArrayList<>(); // 내용리스트

		Scanner ms = new Scanner(System.in);
		int esq = 1; // 게시물 번호

		while (true) {
			System.out.println("명령어를 입력해주세요.:");
			String command = ms.next();

			if (command.equals("add")) {
				System.out.println("제목을 입력해주세요.");
				String title = ms.next();
				System.out.println("내용을 입력해주세요.");
				String contents = ms.next();

				postMember member = new postMember(esq, title, contents);

				esq++;
				post.add(member);
			}

			else if (command.equals("list")) {
				for (int i = 0; i < post.size(); i++) {
					postMember member = post.get(i);
					System.out.println("번호 : " + member.postnumber);
					System.out.println("제목 : " + member.posttitle);
				}
			}

			else if (command.equals("update")) {

				System.out.println("수정할 게시물의 번호를 입력하세요. :");
				int id = ms.nextInt();
				int targetNumber = -1;

				for (int i = 0; i < post.size(); i++) {
					if (post.get(i).postnumber == id) {
						targetNumber = i;
					}

					if (targetNumber != -1) {
						System.out.println("새 제목 :");
						String title = ms.next();

						System.out.println("새 내용 :");
						String contents = ms.next();

						postMember member = new postMember(id, title, contents);
						post.set(targetNumber, member);

						System.out.println("수정이 완료되었습니다.");
					} else {
						System.out.println("없는 게시물 번호 입니다.");
					}
				}
			}

			else if (command.equals("delet")) {
				System.out.println("삭제할 게시물의 번호를 입력해주세요. :");
				int delet = ms.nextInt();
				int qlry = -1;

				for (int i = 0; i < post.size(); i++) {

					if (delet == post.get(i).postnumber) {
						qlry = i;

					}

					if (qlry != -1) {
						post.remove(qlry);

						System.out.println("삭제가 완료되었습니다.");
					} else {
						System.out.println("없는 게시물 번호 입니다.");
					}
				}
			}

			else if (command.equals("exit")) {
				break;
			}

		}

	}

}
