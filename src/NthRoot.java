import java.util.*;
public class NthRoot{
	public static void main(String[] args){
		int t=0;
		Scanner in = new Scanner(System.in);
		StringBuilder res = new StringBuilder("");
		t = in.nextInt();
		while(t-- > 0){
                    //long A = in.nextLong();
                    double N = in.nextDouble();
                    double M = in.nextDouble();
                    
                    double result = java.lang.Math.pow(M, (1.0/N));
                    
                    if(java.lang.Math.floor(result)== result){
                        //System.out.println((int)result);
                        res.append((int)result + "\n");
                    }
                    else{
                        //System.out.println(-1);
                        res.append(-1 + "\n");
                    }
			
		}
		System.out.print(res);
	}
}