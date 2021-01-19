package project;

import java.util.ArrayList;
import java.util.Scanner;

public class homePage {

	public static void main(String[] args) {
		ArrayList<Integer> postNumber = new ArrayList<Integer>();
		ArrayList<String> title = new ArrayList<String>(); // 제목리스트
		ArrayList<String> contents = new ArrayList<String>(); // 내용리스트

		Scanner ms = new Scanner(System.in);
		int count = 0; // 게시물 개수
		int esq = 1; // 게시물 번호

		while (true) {
			System.out.println("명령어를 입력해주세요.:");
			String command = ms.next();

			if (command.equals("add")) {
				postNumber.add(esq);
				System.out.println("제목을 입력해주세요.");
				title.add(count, ms.next());
				System.out.println("내용을 입력해주세요.");
				contents.add(count, ms.next());

				count++;
				esq++;
			}

			else if (command.equals("list")) {
				for (int i = 0; i < count; i++) {
					System.out.println(postNumber.get(i) + "번 제목:" + title.get(i));
					System.out.println(postNumber.get(i) + "번 내용:" + contents.get(i));
				}
			}

			else if (command.equals("update")) {

				System.out.println("수정할 게시물의 번호를 입력하세요. :");
				int up = ms.nextInt();
				int qlry = -1;

				for (int i = 0; i < postNumber.size(); i++) {
					int updateNumber = postNumber.get(i);
					if (updateNumber == up) {
						qlry= i;
					}
					
					if(qlry != -1) {
						System.out.println("제목 :");
						String newtitle = ms.next();
						title.set(qlry, newtitle);
						System.out.println("내용 :");
						String newContents = ms.next();
						contents.set(qlry, newContents);
						
						System.out.println("수정이 완료되었습니다.");
						
						for (int z = 0; z < count; z++) {
							System.out.println(postNumber.get(z) + "번 제목:" + title.get(z));
							System.out.println(postNumber.get(z) + "번 내용:" + contents.get(z));
						}
						
					}
					else {
						System.out.println("없는 게시물 번호 입니다.");
					}
				}
			}

			else if (command.equals("delet")) {
				System.out.println("삭제할 게시물의 번호를 입력해주세요. :");
				int delet = ms.nextInt();
				int qlry = -1;

				for (int i = 0; i < postNumber.size(); i++) {
					int deletPostNuber = postNumber.get(i);
					if (delet == deletPostNuber) {
						qlry = i;

					} 
					
					if(qlry != -1) {
						postNumber.remove(qlry);
						title.remove(qlry);
						contents.remove(qlry);
						
						System.out.println("삭제가 완료되었습니다.");					
					}
					else {
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
