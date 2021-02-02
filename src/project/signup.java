package project;

public class signup {
	int number;
	String id;
	String password;
	String nickname;
	
	

	public signup(int number, String id, String password, String nickname) {
		super();
		this.number = number;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	
	public signup(String id, String password, String nickname) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}


	

	public int getNumber() {
		return number;
	}




	public void setNumber(int number) {
		this.number = number;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
