package project;

import java.util.Scanner;

public class testmain {

	public static void main(String[] args) {
		String[][] ms2 = new String[100][];

		int count = 0;
		int seq = 1;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("명령어를 입력해 주세요. :");
			String a = sc.next();

			if (a.equals("add")) {
				String[] ms = new String[3];
				ms[0] = String.valueOf(seq);

				System.out.println(ms[0] + "게시물의 제목을 입력해 주세요. :");
				ms[1] = sc.next();

				System.out.println("--------------------------");

				System.out.println(ms[0] + "게시물의 내용을 입력해 주세요. :");
				ms[2] = sc.next();

				ms2[count] = ms;
				System.out.println("게시물이 등록 되었습니다.");

				seq++;
				count++;
			}
			
			//리스트 입력 시, 전체 리스트가 안나옴
			else if (a.equals("list")) {
				for (int i = 0; i < count; i++) {
					System.out.println(
							ms2[i][0] + "제목 [ " + ms2[i][1] + "]" + "->" + ms2[i][0] + "내용[" + ms2[i][2] + "]");
				}

			}
			
			if(a.equals("exit")) {
				break;
				
				
			}
		}


	}

}
