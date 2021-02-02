package project;

import java.util.Scanner;

public class ArticleController extends Controller{
		
	void DoCommand(String command) {
		/* ===========================게시물 출력기능========================== */
		if (command.equals("list")) {

			article.printPosttitle(article.ReturnPostArray());
		}

		
	}

}
