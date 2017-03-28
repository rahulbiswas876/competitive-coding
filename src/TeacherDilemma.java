import java.util.*;
import java.io.*;

public class TeacherDilemma{
        
	public static void main(String[] args){
		int t=0;
                 int root[];
                 boolean isRoot[];
                 int size[];
                try{
                //InputStream fi = new FileInputStream("C:\\Users\\Naveen\\Documents\\NetBeansProjects\\Hackerearth\\src\\input7.txt");
		Scanner in = new Scanner(System.in);
		StringBuilder res = new StringBuilder("");
		
                int N = in.nextInt();
                int M = in.nextInt();
                
                //N+1 because we are using 1 based indexing
                root = new int[N+1];
                isRoot = new boolean[N +1];
                size = new int[N+1];
                
                //initialize loop
                for(int i=1 ;i < root.length ;i++){
                    root[i] = i;
                    size[i] = 1;
                    isRoot[i] = true;
                }
                
                for(int i=1;i <= M;i++){
                    int nodeA = in.nextInt();
                    int nodeB = in.nextInt();
                    union(nodeA, nodeB ,root , isRoot, size);
                    
                }
                
                displayResult(root , isRoot, size);
                
                }catch(Exception e){
                    
                }
	}
        
        static void union(int nodeA, int nodeB , int[] root,boolean[] isRoot ,int[] size){
            int rootA = root(nodeA , root);
            int rootB = root(nodeB , root);
            
            //condition to optimize. smaller component will be finded and attatched to larger component
            if(rootA != rootB){
                if(size[rootA] > size[rootB]){
                //since rootB is smaller, therefore rootB will be attatched to rootA
                root[rootB] = rootA;
                size[rootA] += size[rootB];
                isRoot[rootB] = false;
                }else{
                    root[rootA] = rootB;
                    size[rootB] += size[rootA];
                    isRoot[rootA] = false;
                }
            }
            
        }
        
        static int root(int node ,int[] root){
            if(root[node] == node)
                return node;
                
            return root(root[node] ,root);
            
        }
        
        static void displayResult(int[] root,boolean[] isRoot ,int[] size){
            long product = 1;
            int M = 1000000007;
            for(int i=1; i < root.length;i++){
                if(isRoot[i])
                    product = (product*size[i])%M;
                //System.out.print(size[root(root[i])] - 1 + " ");
            }
            
            //long result = product % M;
            System.out.println(product);
        }
}