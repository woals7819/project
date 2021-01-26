package project;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class homePage {

	static ArrayList<postMember> post = new ArrayList<>(); // 내용리스트
	static ArrayList<coment> coments = new ArrayList<>();
	static ArrayList<signup> sgu = new ArrayList<>();
	static Scanner ms = new Scanner(System.in);
	static String nickname = "익명";
	static String coment = "";
	static signup loginedMember = null;
	static int viewNuber = 0;
	static int esq = 4; // 게시물 번호
	static int comentNumber = 1;
	static int userNumber = 1;
	static int love = 0;

	public static void main(String[] args) {

		postMember member1 = new postMember(1, "제목1", "내용1", getCurrentDate(), viewNuber, nickname, love);
		postMember member2 = new postMember(2, "제목2", "내용2", getCurrentDate(), viewNuber, nickname, love);
		postMember member3 = new postMember(3, "제목3", "내용3", getCurrentDate(), viewNuber, nickname, love);

		post.add(member1);
		post.add(member2);
		post.add(member3);

		while (true) {
				System.out.println("명령어를 입력해주세요.:");
				String command = ms.next();				
			
			/* ===========================회원가입 기능========================== */
			if (command.equals("signup")) {
				postSignup();
			}
			
			/* ===========================게시물 출력기능========================== */
			else if (command.equals("list")) {
				
				printPosttitle(post);
			}
			/* ===========================기능 종료========================== */
			else if (command.equals("exit")) {
				break;
			}
			/* ===========================로그인 기능========================== */
			else if (command.equals("signin")) {
				postSignin();
				while(true) {
					System.out.println("명령어를 입력해주세요["+ loginedMember.getId() +"(" +loginedMember.getNickname() +")"+ "] :");
					String userCommand = ms.next();
					
					/* ===========================게시물 추가기능========================== */
					if (userCommand.equals("add")) {
						addPost();
					}
					
					/* ===========================게시물 수정기능========================== */
					else if (userCommand.equals("update")) {
						updatePost();
					}
					/* ===========================게시물 삭제기능========================== */
					else if (userCommand.equals("delet")) {
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
					
					else if (userCommand.equals("exit")) {
						break;
					}

				}
			}

			

			

		}

	}
	
	
	/*============================================로그인 메서드==================================================*/
	private static void postSignin() {
		System.out.println("아이디 : ");
		String id = ms.next();
		System.out.println("비밀번호 : ");
		String pw = ms.next();
		boolean successed = true;
		for (int i = 0; i < sgu.size(); i++) {
			signup member = sgu.get(i);
			String userid = member.getId();
			String userPw = member.getPassword();
			if (userid.equals(id) && userPw.equals(pw)) {
				successed = false;
				loginedMember = sgu.get(i);
				String name = loginedMember.getNickname();
				System.out.println(member.getNickname() + "님 환영합니다!.");
				break;
			} 
		}
		if(successed) {
			System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
		}

	}
	/*=========================================================================================================*/
	
	/*============================================회원가입 메서드==================================================*/
	private static void postSignup() {
		System.out.println("==== 회원 가입을 진행합니다 ====");
		System.out.println("아이디를 입력해 주세요. : ");
		String id = ms.next();
		System.out.println("비밀번호를 입력해주세요. : ");
		String ps = ms.next();
		System.out.println("닉네임을 입력해주세요. : ");
		String nick = ms.next();

		signup sign = new signup(userNumber, id, ps, nick);

		userNumber++;
		sgu.add(sign);

		System.out.println(" ==== 회원가입이 완료되었습니다. ====");

	}
	/*=========================================================================================================*/

	/*============================================상세보기 메서드==================================================*/
	private static void readPost() {
		System.out.println("원하는 게시물의 번호:");
		int postNumber = ms.nextInt();
		int readNumber = searchNuber(postNumber);

		if (readNumber != -1) {
			postMember member = post.get(readNumber);

			member.setPostviews(member.getPostviews() + 1); // 조회수 값 올리기
			printReadPost(member);
			readProcess(postNumber,member);

		} else {
			System.out.println("없는 게시물 입니다.");
		}
	}
	/*=========================================================================================================*/
	
	/*========================================상세보기(프로세스) 메서드==============================================*/
	private static void readProcess(int id,postMember members) {
		while (true) {
			System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) :");
			int item = ms.nextInt();

			if (item == 1) {
				System.out.println("댓글 : ");
				String postcoment = ms.next();

				coment co = new coment(comentNumber, members.getPostnumber(),postcoment, nickname, getCurrentDate());
				coments.add(co);

				System.out.println("댓글이 등록되었습니다.");
				printReadPost(members);

			} else if (item == 2) {
				
				members.setLove(members.getLove() + 1);			
				printReadPost(members);

			} else if (item == 3) {
				int num = members.getPostnumber();
				updateProcess(num);
				

			} else if (item == 4) {
				int num = members.getPostnumber();
				deletProcess(num);

			} else if (item == 5) {
				break;
			}
		}
	}
	/*=========================================================================================================*/
	
	
	/*============================================상세정보출력 메서드==================================================*/
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
		for (int i = 0; i < coments.size(); i++) {
			coment co = coments.get(i);
			if (co.getParentId() == members.getPostnumber()) {
				System.out.println("내용 : " + co.getComent());
				System.out.println("작성자 : " + co.getNickname());
				System.out.println("작성일 : " + co.getDate());
			}

		}
	}
	/*=========================================================================================================*/

	
	/*============================================삭제 메서드==================================================*/
	private static void deletPost() {
		System.out.println("삭제할 게시물의 번호를 입력해주세요. :");
		int delet = ms.nextInt();
		int deletNumber = searchNuber(delet);

		if (deletNumber != -1) {
			deletProcess(delet);
		} else {
			System.out.println("없는 게시물 번호 입니다.");
		}

	}
	/*=========================================================================================================*/
	
	/*========================================삭제(프로세스) 메서드==============================================*/
	private static void deletProcess(int delet) {
		post.remove(searchNuber(delet));

		System.out.println("삭제가 완료되었습니다.");

		for (int j = 0; j < post.size(); j++) {
			postMember memberlist = post.get(j);
			System.out.println("번호 : " + memberlist.getPostnumber());
			System.out.println("제목 : " + memberlist.getPosttitle());
			System.out.println("================================");
		}
	}
	/*=========================================================================================================*/
	
	
	/*==========================================게시물번호 검색 메서드===============================================*/
	public static int searchNuber(int id) {
		int targetNumber = -1;

		for (int i = 0; i < post.size(); i++) {

			if (id == post.get(i).getPostnumber()) {
				targetNumber = i;

			}
		}
		return targetNumber;
	}
	/*=========================================================================================================*/
	
	
	/*============================================게시물검색 메서드==================================================*/
	private static void searchPost() {
		System.out.println("검색 항목을 선택해주세요.(1.제목, 2.내용, 3. 제목+내용, 4.작성자) : ");
		int item = ms.nextInt();
		System.out.println("검색 키워드를 입력해주세요. : ");
		String keyword = ms.next();

		ArrayList<postMember> searchTitle = new ArrayList<>();

		if (item == 1) {
			for (int i = 0; i < post.size(); i++) {
				postMember member = post.get(i);
				String title = member.getPosttitle();
				if (title.contains(keyword)) {
					searchTitle.add(member);
				}
			}
			printPosttitle(searchTitle);

		} else if (item == 2) {
			for (int i = 0; i < post.size(); i++) {
				postMember member = post.get(i);
				String contents = member.getPostcontents();
				if (contents.contains(keyword)) {
					searchTitle.add(member);
				}
			}
			printPosttitle(searchTitle);
		} else if (item == 3) {
			for (int i = 0; i < post.size(); i++) {
				postMember member = post.get(i);
				String title = member.getPosttitle();
				String contents = member.getPostcontents();
				if (contents.contains(keyword) || title.contains(keyword)) {
					searchTitle.add(member);
				}
			}
			printPosttitle(searchTitle);
		} else if (item == 4) {
			for (int i = 0; i < post.size(); i++) {
				postMember member = post.get(i);
				String name = member.getNickname();
				if (name.contains(keyword)) {
					searchTitle.add(member);
				}
			}
			printPosttitle(searchTitle);
		}

	}
	/*=========================================================================================================*/
	
	
	/*============================================게시물수정 메서드==================================================*/
	private static void updatePost() {
		System.out.println("수정할 게시물의 번호를 입력하세요. :");
		int id = ms.nextInt();
//		int updateNumber = searchNuber(id);
		if (id != -1) {
			updateProcess(id);
			

			System.out.println("수정이 완료되었습니다.");

		} else {
			System.out.println("없는 게시물 번호 입니다.");
		}

		

	}
	/*=========================================================================================================*/

	
	/*========================================수정(프로세스) 메서드==============================================*/
	public static void updateProcess(int id) {
		System.out.println("새 제목 :");
		String title = ms.next();

		System.out.println("새 내용 :");
		String contents = ms.next();
		String postdate = getCurrentDate();
		int postview = viewNuber;
		String postcoment = coment;
		int good = love;
		
		postMember member = new postMember(id, title , contents, postdate, postview, nickname, good);
		post.set(searchNuber(id), member);
		
		for (int j = 0; j < post.size(); j++) {
			postMember memberlist = post.get(j);
			System.out.println("번호 : " + memberlist.getPostnumber());
			System.out.println("제목 : " + memberlist.getPosttitle());
			System.out.println("날짜 : " + memberlist.getPostdate());
			System.out.println("================================");
		}
	}
	/*=========================================================================================================*/
	
	
	/*========================================list실행 메서드==============================================*/
	public static void printPosttitle(ArrayList<postMember> post) {
		for (int i = 0; i < post.size(); i++) {
			postMember member = post.get(i);
			String str = member.getPostdate();
			str = str.substring(0, 10);

			System.out.println("번호 : " + member.getPostnumber());
			System.out.println("제목 : " + member.getPosttitle());
			System.out.println("작성자 : " + member.getNickname());
			System.out.println("조회수 : " + member.getPostviews());
			System.out.println("날짜 : " + member.getPostdate());
			System.out.println("================================");
		}
	}
	/*=========================================================================================================*/
	
	
	/*========================================게시물추가 메서드==============================================*/
	public static void addPost() {
		System.out.println("제목을 입력해주세요.");
		String title = ms.next();
		System.out.println("내용을 입력해주세요.");
		String contents = ms.next();
		String postcoment = coment;
		int postviews = viewNuber;
		int good = love;

		postMember member = new postMember(esq, title, contents, getCurrentDate(), postviews, nickname, love);

		esq++;
		post.add(member);
	}
	/*=========================================================================================================*/
	
	
	
	/*========================================게시물날짜 메서드==============================================*/
	public static String getCurrentDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:ss");
		Date time = new Date();
		String time1 = date.format(time);

		return time1;
	}

}
