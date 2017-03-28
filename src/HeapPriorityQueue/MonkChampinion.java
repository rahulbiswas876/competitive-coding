package HeapPriorityQueue;


import java.util.*;
import java.util.PriorityQueue;
public class MonkChampinion{
	public static void main(String[] args){
		int t=0;
		Scanner in = new Scanner(System.in);
		StringBuilder res = new StringBuilder("");
		int M = in.nextInt();
                int N = in.nextInt();
                
                PriorityQueue pq = new PriorityQueue<Integer>(new Comparator(){
                    public int compare(Object a,Object b){
                        return -Integer.compare((int)a,(int) b);
                    }
                });
                
                for(int i=1;i <= M;i++){
                    int temp = in.nextInt();
                    pq.add(temp);
                }
                
                long sum = 0;
                
                for(int i=1;i <= N;i++){
                    int max = (int)pq.remove();
                    sum += max;
                    pq.add(max-1);
                }
                
                System.out.println(sum);
	}
}