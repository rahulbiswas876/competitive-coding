import java.util.*;
import java.lang.Math;
public class SortString{
	public static void main(String[] args){
		int t=0;
		Scanner in = new Scanner(System.in);
		StringBuilder res = new StringBuilder("");
		int N = 1000 ;
                
                //N = in.nextInt();
                
                String[] temp = {"abc","ab","cd","bc","abcde","bcde","def","degai"};
                String[] names = new String[N];
                
                for(int i=0;i < N;i++){
                   // names[i] = in.next();
                   int rand = ((int)Math.floor((Math.random()*100)) + 1)% 8 ;
                   names[i] = temp[rand];
                }
                
                Arrays.sort(names);
                
                insertionSortString(names);
                
                System.out.println("**********************");
                for(int i=0; i < N;i++){
                    System.out.println(names[i]);
                }
                
	}
        
        static void insertionSortString(String[] names){
            for(int i=1; i < names.length ;i++){
                String temp = names[i];
                int j=i - 1;
                while( j >= 0 && names[j].length()> temp.length()){
                    names[j+1] = names[j];
                    j--;
                }
                
                names[j + 1] = temp;
            }
        }
}