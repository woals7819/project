package test;

import java.util.ArrayList;
import java.util.Scanner;

public class exm2 {

	public static void main(String[] args) {
		ArrayList<parson> a = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		
//		parson p1 = new parson(17, "홍길동");
//	    parson p2 = new parson(19, "임꺽정");
//	    parson p3 = new parson(27, "이순신");
//	    parson p4 = new parson(32, "강감찬");
//	    parson p5 = new parson(53, "을지문덕");
//	    parson p6 = new parson(12, "황진이");
	    
	    int count = 1;
	    
	    while(true) {
	    	System.out.println("명령어 : ");
	    	String command = sc.next();
	    	
	    	
	    	if(command.equals("add")) {
	    		System.out.println("나이 : " );
	    		int age = sc.nextInt();
	    		
	    		System.out.println("이름 : ");
	    		String name = sc.next();
	    		
	    		parson ps = new parson(count, age, name);
	    		
	    		count++;
	    		a.add(ps);
	    		
	    	}
	    	
	    	
	    	else if(command.equals("name")) {
	    		for(int i = 0; i < a.size(); i++) {
//	    			parson ps = a.get(i);	    			
//	    			System.out.println(a.get(i).name);
	    			parson pps = new parson();
	    			pps.ghaud();
	    		}
	    	}
	    	// 2. 사람의 나이가 20 이하인 사람만 호명하게 해주세요.
	    	else if(command.equals("20down")) {
	    		for(int i = 0; i < a.size(); i++) {
	    			if(20 > a.get(i).age) {
	    				System.out.println("나이 : " + a.get(i).age);
	    				System.out.println("이름 : " + a.get(i).name);
	    			}
	    		}
	    	}
	    }
	   

	    
	    
	

	}

}
class parson{
	int number;
	int age;
	String name;
	
	parson(int a, int b, String c){
		age = a;
		number = b;
		name = c;
	}
	
	parson(){
		
	}
	
	void ghaud() {
		System.out.println(name);
	}
}
