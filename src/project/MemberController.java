package project;

import java.util.Scanner;

public class MemberController extends Controller{
	
	MemberDao mb = new MemberDao();
	signup loginedMember = null;
	String coment = "";
	int viewNuber = 0;
	int comentNumber = 1;
	int love = 0;
	int esq = 4; // 게시물 번호
	
	void DoCommand(String command) {
		
		if (command.equals("signup")) {
			postSignup();
		}
		/*==========================================================================*/
		else if (command.equals("add") || command.equals("update") || command.equals("delete")
				|| command.equals("read") || command.equals("search")) {
			needogin();
		}
		/*==========================================================================*/

		else if (command.equals("signin")) {
			postSignin();
			while (true) {
				System.out.println("명령어를 입력해주세요[" + loginedMember.getId() + "(" + loginedMember.getNickname() + ")" + "] :");
				String userCommand = ms.nextLine();

				/* ===========================게시물 추가기능========================== */
				if (userCommand.equals("add")) {
					addPost();
				}

				/* ===========================게시물 수정기능========================== */
				else if (userCommand.equals("update")) {
					updatePost();
				}
				/* ===========================게시물 삭제기능========================== */
				else if (userCommand.equals("delete")) {
					deletPost();
				}

				/* ===========================게시물 상세보기 기능========================== */
				else if (userCommand.equals("read")) {
					readPost();

				}
				/* ===========================게시물 찾기 기능========================== */
				else if (userCommand.equals("search")) {
					searchPost();

				}

				else if (userCommand.equals("logout")) {
					System.out.println("로그아웃 되었습니다.");
					break;
				}

			}
		}
	}

	public void postSignup() {
		System.out.println("==== 회원 가입을 진행합니다 ====");
		System.out.println("아이디를 입력해 주세요. : ");
		String id = ms.nextLine();
		System.out.println("비밀번호를 입력해주세요. : ");
		String ps = ms.nextLine();
		System.out.println("닉네임을 입력해주세요. : ");
		String nick = ms.nextLine();


		signup sign = new signup(id, ps, nick);
		mb.InsertMember(sign);

		System.out.println(" ==== 회원가입이 완료되었습니다. ====");

	}
	
	/*==========================================================================*/
	public void postSignin() {
		System.out.println("아이디 : ");
		String id = ms.nextLine();
		System.out.println("비밀번호 : ");
		String pw = ms.nextLine();

		signup sgu = mb.getMemberByLoginIdAndPw(id, pw);

		if (sgu != null) {
			System.out.println(sgu.nickname + "님환영합니다!");
			loginedMember = sgu;
		} else {
			System.out.println("잘못된 회원 정보입니다.");
		}
	}
	
	/*==========================================================================*/
	public void addPost() {
		System.out.println("제목을 입력해주세요.");
		String title = ms.nextLine();
		System.out.println("내용을 입력해주세요.");
		String contents = ms.nextLine();
		String name = loginedMember.getNickname();
		String postcoment = coment;
		int postviews = viewNuber;
		int good = love;

		postMember member = new postMember(esq, title, contents, UtilDao.getCurrentDate(), postviews, name, love, loginedMember.getNumber());

		esq++;
		article.AddMember(member);
	}
	
	/*==========================================================================*/
	public void updatePost() {
		System.out.println("수정할 게시물의 번호를 입력하세요. :");
		int id = Integer.parseInt(ms.nextLine());
		postMember member = article.GetIndex(id);
		if (member == null) {
			System.out.println("없는 게시물 번호 입니다.");

		} else {
			updateProcess(id);

			System.out.println("수정이 완료되었습니다.");
		}

	}

	/*==========================================================================*/
	public void updateProcess(int id) {
		System.out.println("새 제목 :");
		String title = ms.nextLine();

		System.out.println("새 내용 :");
		String contents = ms.nextLine();
		String postdate = UtilDao.getCurrentDate();
		int postview = viewNuber;
		String name = loginedMember.getNickname();
		String postcoment = coment;
		int good = love;

		postMember member = new postMember(id, title, contents, postdate, postview, name, good);
		article.UpdateProccessSet(id, member);
	}
	
	/*==========================================================================*/
	public void deletPost() {
		System.out.println("삭제할 게시물의 번호를 입력해주세요. :");
		int delet = Integer.parseInt(ms.nextLine());
		postMember member = article.GetIndex(delet);

		if (member == null) {
			System.out.println("없는 게시물 번호 입니다.");
		} else {
			article.deletProcess(member);
		}

	}
	
	/*==========================================================================*/
	public void readPost() {
		System.out.println("원하는 게시물의 번호:");
		int postNumber = Integer.parseInt(ms.nextLine());

		postMember member = article.GetIndex(postNumber);

		if (member == null) {
			System.out.println("없는 게시물입니다.");
		} else {
			printReadPost(member);
			readProcess(postNumber, member);
		}
		member.setPostviews(member.getPostviews() + 1); // 조회수 값 올리기
	}

	/*==========================================================================*/
	public void readProcess(int id, postMember members) {
		while (true) {
			System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) :");
			int item = Integer.parseInt(ms.nextLine());

			if (item == 1) {
				System.out.println("댓글 : ");
				String postcoment = ms.nextLine();

				coment co = new coment(comentNumber, members.getPostnumber(), postcoment, loginedMember.getNickname(),
						UtilDao.getCurrentDate());
				article.AddComent(co);

				System.out.println("댓글이 등록되었습니다.");
				printReadPost(members);

			} else if (item == 2) {

				members.setLove(members.getLove() + 1);
				printReadPost(members);

			} else if (item == 3) {
				if(members.getId() == loginedMember.getNumber()) {
					int num = members.getPostnumber();
					updateProcess(num);					
				}
				else {
					System.out.println("자신의 게시물만 변경할 수있습니다.");
				}
				

			} else if (item == 4) {
				postMember mb = article.GetIndex(members.getPostnumber());
				article.deletProcess(mb);
				

			} else if (item == 5) {
				break;
			}
		}
	}
	
	/*==========================================================================*/
	private void searchPost() {
		System.out.println("검색 항목을 선택해주세요.(1.제목, 2.내용, 3. 제목+내용, 4.작성자) : ");
		int item = Integer.parseInt(ms.nextLine());
		System.out.println("검색 키워드를 입력해주세요. : ");
		String keywoard = ms.nextLine();

		article.SerachPost(item, keywoard);

	}
	
	/*==========================================================================*/
	private void printReadPost(postMember members) {
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
	
	/*==========================================================================*/
	public static void needogin() {
		System.out.println("로그인이 필요한 기능입니다.");

	}
	

}
