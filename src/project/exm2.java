package project;

import java.util.ArrayList;

public class exm2 {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<String> b = new ArrayList<>();
		String[][] zv = new String[6][2];
		int count  = 0;
		
		parson 사람1 = new parson(17, "홍길동");
	    parson 사람2 = new parson(19, "임꺽정");
	    parson 사람3 = new parson(27, "이순신");
	    parson 사람4 = new parson(32, "강감찬");
	    parson 사람5 = new parson(53, "을지문덕");
	    parson 사람6 = new parson(12, "황진이");
	    parson av = new parson();
	    
	    for(int i= 0; i < zv.length; i++) {
//	    	zv[count][0] = a.get(i);
	    	zv[count][1] = b.get(i);
	    }
	    
	    
	    a.add(사람1.age);
	    b.add(사람1.name);
	    a.add(사람2.age);
	    b.add(사람2.name);
	    a.add(사람3.age);
	    b.add(사람3.name);
	    a.add(사람4.age);
	    b.add(사람4.name);
	    a.add(사람5.age);
	    b.add(사람5.name);
	    a.add(사람6.age);
	    b.add(사람6.name);
	    
	    
	    
	    
	    
	    for(int i = 0; i < b.size(); i++) {
	    	zv[count][0] = a.get(i);

	    	
	    }
	    
	    
		

	}

}
class parson{
	int age;
	String name;
	
	parson(int a, String b){
		age = a;
		name = b;
	}
	
	parson(){
		
	}
	
	void ghaud() {
		System.out.println(name);
	}
}
