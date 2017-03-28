import java.util.*;
public class Math{
	public static void main(String[] args){
		int t=0;
		Scanner in = new Scanner(System.in);
		StringBuilder res = new StringBuilder("");
		t = in.nextInt();
		while(t-- > 0){
                    long A = in.nextLong();
                    StringBuilder s = new StringBuilder("0");
                    s.append(Long.toBinaryString(A));
//                    System.out.println(Long.toBinaryString(A));
//                    System.out.println(s);
                    for(int i = s.length()-1 ;i >=0; i--){
                        if(s.charAt(i) == '0'){
                            s.setCharAt(i, '1');  
                            break;
                        }
                    }
//                    System.out.println(s);
		res.append( Integer.parseInt(s.toString(),2)+ "\n");
			
		}
		System.out.print(res);
	}
}