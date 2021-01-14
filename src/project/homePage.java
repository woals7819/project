package project;

import java.util.ArrayList;
import java.util.Scanner;

public class homePage {

	public static void main(String[] args) {
		ArrayList<String> title = new ArrayList<String>(); //제목리스트
		ArrayList<String> contents = new ArrayList<String>(); //내용리스트
		ArrayList<Integer> postNumber = new ArrayList<Integer>();
		
		Scanner ms = new Scanner(System.in);
		int count = 0; //게시물 개수
		int esq = 1; //게시물 번호

		while(true) {
			System.out.println("명령어를 입력해주세요.:");
			String command = ms.next();
			
			if(command.equals("add")) {
				postNumber.add(esq);
				System.out.println("제목을 입력해주세요.");
				title.add(count, ms.next());
				System.out.println("내용을 입력해주세요.");
				contents.add(count, ms.next());
				
				count++;
				esq++;
			}
			
			else if(command.equals("list")) {
				for(int i= 0; i < count; i++) {
					System.out.println(postNumber.get(i) + "번 제목:" + title.get(i));
					System.out.println(postNumber.get(i) + "번 내용:" + contents.get(i));
				}
			}
			
			else if(command.equals("exit")) {
				break;
			}
			
		}

	}

}
