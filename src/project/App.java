package project;

import java.util.Scanner;

public class App {
	
	Scanner ms = new Scanner(System.in);
	void start() {
		while (true) {
			System.out.println("명령어를 입력해주세요.:");
			String command = ms.nextLine();
			
			String[] cs = command.split(" ");
			String ac = cs[0];
			String mc = cs[1];
			
			if(ac.equals("article")) {
				ArticleController acr = new ArticleController();
				acr.DoCommand(mc);
			}
			else if(ac.equals("member")) {
				MemberController mcr = new MemberController();
				mcr.DoCommand(mc);
			}
			if (command.equals("exit")) {
				break;
			}
			
		}	
	}
}
