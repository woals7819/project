package project;

import java.util.ArrayList;
import java.util.Scanner;

public class exm {
	// {5,4,3,2,1,0}을 ArrayList에 추가 해주세요.
	// ArrayList의 사이즈를 출력해주세요.
	// ArrayList의 3,4번째 값을 읽어서 출력해주세요.
	// 1,2번째 값을 지운 뒤, 다시 3,4번째 값을 출력해주세요
	// List의 모든 값을 toString 혹은 그냥 리스트명을 입력하여 출력해주세요.

	public static void main(String[] args) {
		Scanner ms = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(5);
		a.add(4);
		a.add(3);
		a.add(2);
		a.add(1);
		a.add(0);
		System.out.println(a.size());
		
		System.out.println("=====================");
		
		System.out.println(a.get(2));
		System.out.println(a.get(3));
		
		System.out.println("=====================");
		
		a.remove(0);
		a.remove(1);
		System.out.println(a.get(2));
		System.out.println(a.get(3));
		
		System.out.println("=====================");
		
		String v = ms.next();
		if(v.equals("a")) {
			for(int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i));
			}
		}

	}

}
