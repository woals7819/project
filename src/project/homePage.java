package project;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class homePage {

	static MemberDao mb = new MemberDao();
	static ArticleDao article = new ArticleDao();
	static Scanner ms = new Scanner(System.in);
	static String nickname = "";
	static String coment = "";
	static signup loginedMember = null;
	static int viewNuber = 0;
	static int esq = 4; // 게시물 번호
	static int comentNumber = 1;
	static int love = 0;

	public static void main(String[] args) {

		while (true) {
			System.out.println("명령어를 입력해주세요.:");
			String command = ms.next();

			/* ===========================회원가입 기능========================== */
			if (command.equals("member signup")) {
				postSignup();
			}

			/* ===========================게시물 출력기능========================== */
			else if (command.equals("article list")) {

				article.printPosttitle(article.ReturnPostArray());
			}
			/* ===========================기능 종료========================== */
			else if (command.equals("article exit")) {
				break;
			}

			/* ===========================로그인필요 기능========================== */
			else if (command.equals("article add")) {
				NeedLogin();
			} else if (command.equals("article read")) {
				NeedLogin();
			} else if (command.equals("article search")) {
				NeedLogin();
			} else if (command.equals("article update")) {
				NeedLogin();
			} else if (command.equals("article delete")) {
				NeedLogin();
			}
			/* ===========================로그인 기능========================== */
			else if (command.equals("member signin")) {
				postSignin();
				while (true) {
					System.out.println(
							"명령어를 입력해주세요[" + loginedMember.getId() + "(" + loginedMember.getNickname() + ")" + "] :");
					String userCommand = ms.next();

					/* ===========================게시물 추가기능========================== */
					if (userCommand.equals("member add")) {
						addPost();
					}

					/* ===========================게시물 수정기능========================== */
					else if (userCommand.equals("member update")) {
						updatePost();
					}
					/* ===========================게시물 삭제기능========================== */
					else if (userCommand.equals("member delete")) {
						deletPost();
					}

					/* ===========================게시물 상세보기 기능========================== */
					else if (userCommand.equals("member read")) {
						readPost();

					}
					/* ===========================게시물 찾기 기능========================== */
					else if (userCommand.equals("member search")) {
						searchPost();

					}

					else if (userCommand.equals("logout")) {
						break;
					}

				}
			}

		}

	}

	public static void NeedLogin() {
		System.out.println(" 로그인 후 사용 가능합니다.");

	}

	/*=======================================로그인 메서드=============================================*/
	private static void postSignin() {
		System.out.println("아이디 : ");
		String id = ms.next();
		System.out.println("비밀번호 : ");
		String pw = ms.next();

		signup sgu = mb.getMemberByLoginIdAndPw(id, pw);

		if (sgu == null) {
			System.out.println("잘못된 회원 정보입니다.");
		} else {
			System.out.println(sgu.nickname + "님환영합니다!");
			loginedMember = sgu;
		}

	}
	/*=======================================회원가입 메서드=============================================*/
	private static void postSignup() {
		System.out.println("==== 회원 가입을 진행합니다 ====");
		System.out.println("아이디를 입력해 주세요. : ");
		String id = ms.next();
		System.out.println("비밀번호를 입력해주세요. : ");
		String ps = ms.next();
		System.out.println("닉네임을 입력해주세요. : ");
		String nick = ms.next();
		signup sign = new signup(id, ps, nick);

		MemberDao membersgu = new MemberDao();
		membersgu.InsertMember(sign);

		System.out.println(" ==== 회원가입이 완료되었습니다. ====");

	}

	/*=======================================상세보기 메서드=============================================*/
	private static void readPost() {
		System.out.println("원하는 게시물의 번호:");
		int postNumber = ms.nextInt();
		
		postMember member = article.GetIndex(postNumber);
		

		if(member == null) {
			System.out.println("없는 게시물입니다.");
		}else {
			printReadPost(member);
			readProcess(postNumber, member);			
		}
		member.setPostviews(member.getPostviews() + 1); // 조회수 값 올리기
	}

	/*===================================상세보기(프로세스)메서드====================================*/
	private static void readProcess(int id, postMember members) {
		while (true) {
			System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) :");
			int item = ms.nextInt();

			if (item == 1) {
				System.out.println("댓글 : ");
				String postcoment = ms.next();

				coment co = new coment(comentNumber, members.getPostnumber(), postcoment, nickname, UtilDao.getCurrentDate());
				article.AddComent(co);

				System.out.println("댓글이 등록되었습니다.");
				printReadPost(members);

			} else if (item == 2) {

				members.setLove(members.getLove() + 1);
				printReadPost(members);

			} else if (item == 3) {
				int num = members.getPostnumber();
				updateProcess(num);

			} else if (item == 4) {
				postMember mb = article.GetIndex(members.getPostnumber());
				article.deletProcess(mb);

			} else if (item == 5) {
				break;
			}
		}
	}

	/*=======================================상세보기출력 메서드=============================================*/
	private static void printReadPost(postMember members) {
		System.out.println("==========" + members.getPostnumber() + "번의 게시물 =========");
		System.out.println("번호 : " + members.getPostnumber());
		System.out.println("제목 : " + members.getPosttitle());
		System.out.println("내용 : " + members.getPostcontents());
		System.out.println("작성자 : " + members.getNickname());
		System.out.println("조회수 : " + members.getPostviews());
		System.out.println("날짜 : " + members.getPostdate());
		System.out.println("좋아요 : " + members.getLove());

		System.out.println("================================");
		System.out.println("================댓글==============");
		article.PrintComents(members);
	}

	/*=======================================삭제 메서드=============================================*/
	private static void deletPost() {
		System.out.println("삭제할 게시물의 번호를 입력해주세요. :");
		int delet = ms.nextInt();
		postMember member = article.GetIndex(delet);
		
		if(member == null) {
			System.out.println("없는 게시물 번호 입니다.");			
		}
		else {
			article.deletProcess(member);
		}

	}

	/*====================================게시물 검색 메서드==========================================*/
	private static void searchPost() {
		System.out.println("검색 항목을 선택해주세요.(1.제목, 2.내용, 3. 제목+내용, 4.작성자) : ");
		int item = ms.nextInt();
		System.out.println("검색 키워드를 입력해주세요. : ");
		String keywoard = ms.next();

		article.SerachPost(item, keywoard);

	}

	/*=======================================수정 메서드=============================================*/
	private static void updatePost() {
		System.out.println("수정할 게시물의 번호를 입력하세요. :");
		int id = ms.nextInt();
		postMember member = article.GetIndex(id);
		if (member == null) {
			System.out.println("없는 게시물 번호 입니다.");

		} else {
			updateProcess(id);
			
			System.out.println("수정이 완료되었습니다.");
		}

	}

	/*==================================수정(프로세스) 메서드========================================*/
	public static void updateProcess(int id) {
		System.out.println("새 제목 :");
		String title = ms.next();

		System.out.println("새 내용 :");
		String contents = ms.next();
		String postdate = UtilDao.getCurrentDate();
		int postview = viewNuber;
		String name = nickname;
		String postcoment = coment;
		int good = love;

		postMember member = new postMember(id, title, contents, postdate, postview, name, good);
		article.UpdateProccessSet(id, member);
	}


	/*======================================추가 메서드============================================*/
	public static void addPost() {
		System.out.println("제목을 입력해주세요.");
		String title = ms.next();
		System.out.println("내용을 입력해주세요.");
		String contents = ms.next();
		System.out.println("작성자 : ");
		String name = ms.next();
		String postcoment = coment;
		int postviews = viewNuber;
		int good = love;

		postMember member = new postMember(esq, title, contents, UtilDao.getCurrentDate(), postviews, name, love);

		esq++;
		article.AddMember(member);
	}
	/*=============================================================================================*/

	

}
