package test;

import java.util.ArrayList;
import java.util.Scanner;

public class testmain {

	public static void main(String[] args) {
		int postSize = 10;
		String[][] postArr = new String[postSize][];

		int count = 0;// 게시글을 읽을 카운트
		int seq = 1; // 게시글 넘버
		int arradd = 10;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("명령어를 입력해 주세요. :");
			String a = sc.next();

			if (a.equals("add")) {
				if (postArr.length == count) {
					System.out.println("더 이상 게시물을 등록할 수 없습니다.");
					
				} else {
					String[] titleArr = new String[3];
					titleArr[0] = String.valueOf(seq);

					System.out.println(titleArr[0] + "번 게시물의 제목을 입력해 주세요. :");
					titleArr[1] = sc.next();

					System.out.println("--------------------------");

					System.out.println(titleArr[0] + "번 게시물의 내용을 입력해 주세요. :");
					titleArr[2] = sc.next();

					postArr[count] = titleArr;
					System.out.println("게시물이 등록 되었습니다.");

					seq++;
					count++;

				}
			}

			else if (a.equals("list")) {
				for (int i = 0; i < count; i++) {
					System.out.println(postArr[i][0] + "제목 [ " + postArr[i][1] + "]");
					System.out.println(postArr[i][0] + "내용[" + postArr[i][2] + "]");
				}

			}

			if (a.equals("exit")) {
				break;

			}
		}

	}

}
