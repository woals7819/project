package project;

public class postMember {
	private int postnumber;
	private String posttitle;
	private String postcontents;
	private String postdate;
	private int postviews;
	private String nickname;


	
	public postMember(int postnumber, String posttitle, String postcontents, String postdate, int postviews,
			String nickname) {
		super();
		this.postnumber = postnumber;
		this.posttitle = posttitle;
		this.postcontents = postcontents;
		this.postdate = postdate;
		this.postviews = postviews;
		this.nickname = nickname;

	}
	



	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPostnumber() {
		return postnumber;
	}

	public void setPostnumber(int postnumber) {
		this.postnumber = postnumber;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostcontents() {
		return postcontents;
	}

	public void setPostcontents(String postcontents) {
		this.postcontents = postcontents;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public int getPostviews() {
		return postviews;
	}

	public void setPostviews(int postviews) {
		this.postviews = postviews;
	}
	
	

}
