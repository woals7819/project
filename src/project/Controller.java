package project;

import java.util.Scanner;

public abstract class Controller {
	
	Scanner ms = new Scanner(System.in);
	ArticleDao article = new ArticleDao();
	
	abstract void DoCommand(String command);
		
	
}
