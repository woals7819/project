package project;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		/*next() = 공백을 기준으로 문자열을 잘라 리턴
		 *nextLine() = 줄바꿈 기준 문자열을 리턴
		 *nextLine() = 문자열을 숫자로 리턴해준다.
		 *ctrl + shift + o = 자동 import
		 *ctrl + shift + f = 자동 코드정렬 */
		Scanner sc = new Scanner(System.in); //입력
//		String a = sc.next();
//		System.out.println(a);
//		
//		String b = sc.nextLine();
//		System.out.println(b);
		
//		int c = sc.nextInt();
//		int d = sc.nextInt();
//		System.out.println(c + d);
		
		
		//Scanner를 이용해서 아래와 같이 입출력 하여 사칙연산을 수행해주세요.
		//입출력 예시
		//첫번째 숫자를 입력해주세요: 12
		//두번째 숫자를 입력해주세요: 33
		//12 + 33 = 45
		
		
		 // Scanner를 이용해 입력값을 받아
	    // 구구단을 원하는 단이 나오게 해주세요.

	    //예시) 원하는 단을 입력해주세요 : 4 (입력후 엔터)

	    // 4단 출력.
//		int a = sc.nextInt();
//		for(int i = 1; i < 10; i++) {
//			System.out.println(a + "*" + i + "=" + a*i);
//		}
		
//		System.out.println("이름을 입력해주세요:");
//		String name = sc.next();
//	    
//	    System.out.println("나이를 입력해주세요:");
//	    int age = sc.nextInt();
//	    
//	    System.out.println("제 이름은" + name + "이고, 나이는"+ age +"입니다.");
		
		
		
		System.out.println("숫자를 입력해 주세요. : ");
		int a = sc.nextInt();
		
		if(a % 2 == 0) {
			System.out.println("even");
		}
		else {
			System.out.println("odd");
		}
		
		System.out.println(1);
		
	}

}
