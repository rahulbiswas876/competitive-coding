package HeapPriorityQueue;

import java.util.*;
public class MaxInQueue{
	public static void main(String[] args){
		int t=0;
		Scanner in = new Scanner(System.in);
                int maxCapx = 1000000;
                PriorityQueue pq = new PriorityQueue(maxCapx);
		int N = in.nextInt();
                
                for(int i=1;i <= N;i++){
                    try{
                        int elm = in.nextInt();
                        pq.insertElement(elm);
                    }catch(Exception e){
                        
                    }
                }
                
                int Q = in.nextInt();
                
                for(int i=1;i <= Q ;i++){
                    int type = in.nextInt();
                    if(type == 1){
                        try{
                        int elm = in.nextInt();
                        pq.insertElement(elm);
                        }catch(Exception e){

                        }
                    }else{
                        try{
                        int elm = pq.maximum();
                        System.out.println(elm);
                        }catch(Exception e){

                        }
                    }
                }
                
                
	}
        
}
