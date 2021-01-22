package project;

public class coment {
	private int id;
	private int parentId; //postmember number
	private String coment;
	private String nickname;
	private String date;
	
	
	




	public coment(int id, int parentId, String coment, String nickname, String date) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.coment = coment;
		this.nickname = nickname;
		this.date = date;
	}
	
	

	

	public int getParentId() {
		return parentId;
	}





	public void setParentId(int parentId) {
		this.parentId = parentId;
	}





	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getComent() {
		return coment;
	}



	public void setComent(String coment) {
		this.coment = coment;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
}
