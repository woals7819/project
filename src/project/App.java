package project;

import java.util.Scanner;

public class App {
	
	Scanner ms = new Scanner(System.in);
	MemberDao md = new MemberDao();
	ArticleDao ad = new ArticleDao();
	Contoller mct = new Contoller();
	void start() {

			mct.DoCommand();				
			
			
//			System.out.println("잘못된 명령어 입니다.");

			
		}	
}